#
# in your quartz properties file, you'll need to set 
# org.quartz.jobstore.driverdelegateclass = org.quartz.impl.jdbcjobstore.stdjdbcdelegate
#
#
# by: ron cordell - roncordell
#  i didn't see this anywhere, so i thought i'd post it here. this is the script from quartz to create the tables in a mysql database, modified to use innodb instead of myisam.
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS qrtz_fired_triggers;
DROP TABLE IF EXISTS qrtz_paused_trigger_grps;
DROP TABLE IF EXISTS qrtz_scheduler_state;
DROP TABLE IF EXISTS qrtz_locks;
DROP TABLE IF EXISTS qrtz_simple_triggers;
DROP TABLE IF EXISTS qrtz_simprop_triggers;
DROP TABLE IF EXISTS qrtz_cron_triggers;
DROP TABLE IF EXISTS qrtz_blob_triggers;
DROP TABLE IF EXISTS qrtz_triggers;
DROP TABLE IF EXISTS qrtz_job_details;
DROP TABLE IF EXISTS qrtz_calendars;

DROP TABLE IF EXISTS qrtz_job_logs;
DROP TABLE IF EXISTS qrtz_job_failed_logs;

CREATE TABLE qrtz_job_details(
sched_name VARCHAR(120) NOT NULL,
job_name VARCHAR(200) NOT NULL,
job_group VARCHAR(200) NOT NULL,
description VARCHAR(250) NULL,
job_class_name VARCHAR(250) NOT NULL,
is_durable VARCHAR(1) NOT NULL,
is_nonconcurrent VARCHAR(1) NOT NULL,
is_update_data VARCHAR(1) NOT NULL,
requests_recovery VARCHAR(1) NOT NULL,
job_data BLOB NULL,
PRIMARY KEY (sched_name,job_name,job_group))
ENGINE=INNODB;

CREATE TABLE qrtz_triggers (
sched_name VARCHAR(120) NOT NULL,
trigger_name VARCHAR(200) NOT NULL,
trigger_group VARCHAR(200) NOT NULL,
job_name VARCHAR(200) NOT NULL,
job_group VARCHAR(200) NOT NULL,
description VARCHAR(250) NULL,
next_fire_time BIGINT(13) NULL,
prev_fire_time BIGINT(13) NULL,
priority INTEGER NULL,
trigger_state VARCHAR(16) NOT NULL,
trigger_type VARCHAR(8) NOT NULL,
start_time BIGINT(13) NOT NULL,
end_time BIGINT(13) NULL,
calendar_name VARCHAR(200) NULL,
misfire_instr SMALLINT(2) NULL,
job_data BLOB NULL,
PRIMARY KEY (sched_name,trigger_name,trigger_group),
FOREIGN KEY (sched_name,job_name,job_group)
REFERENCES qrtz_job_details(sched_name,job_name,job_group))
ENGINE=INNODB;

CREATE TABLE qrtz_simple_triggers (
sched_name VARCHAR(120) NOT NULL,
trigger_name VARCHAR(200) NOT NULL,
trigger_group VARCHAR(200) NOT NULL,
repeat_count BIGINT(7) NOT NULL,
repeat_interval BIGINT(12) NOT NULL,
times_triggered BIGINT(10) NOT NULL,
PRIMARY KEY (sched_name,trigger_name,trigger_group),
FOREIGN KEY (sched_name,trigger_name,trigger_group)
REFERENCES qrtz_triggers(sched_name,trigger_name,trigger_group))
ENGINE=INNODB;

CREATE TABLE qrtz_cron_triggers (
sched_name VARCHAR(120) NOT NULL,
trigger_name VARCHAR(200) NOT NULL,
trigger_group VARCHAR(200) NOT NULL,
cron_expression VARCHAR(120) NOT NULL,
time_zone_id VARCHAR(80),
PRIMARY KEY (sched_name,trigger_name,trigger_group),
FOREIGN KEY (sched_name,trigger_name,trigger_group)
REFERENCES qrtz_triggers(sched_name,trigger_name,trigger_group))
ENGINE=INNODB;

CREATE TABLE qrtz_simprop_triggers
  (          
    sched_name VARCHAR(120) NOT NULL,
    trigger_name VARCHAR(200) NOT NULL,
    trigger_group VARCHAR(200) NOT NULL,
    str_prop_1 VARCHAR(512) NULL,
    str_prop_2 VARCHAR(512) NULL,
    str_prop_3 VARCHAR(512) NULL,
    int_prop_1 INT NULL,
    int_prop_2 INT NULL,
    long_prop_1 BIGINT NULL,
    long_prop_2 BIGINT NULL,
    dec_prop_1 NUMERIC(13,4) NULL,
    dec_prop_2 NUMERIC(13,4) NULL,
    bool_prop_1 VARCHAR(1) NULL,
    bool_prop_2 VARCHAR(1) NULL,
    PRIMARY KEY (sched_name,trigger_name,trigger_group),
    FOREIGN KEY (sched_name,trigger_name,trigger_group) 
    REFERENCES qrtz_triggers(sched_name,trigger_name,trigger_group))
ENGINE=INNODB;

CREATE TABLE qrtz_blob_triggers (
sched_name VARCHAR(120) NOT NULL,
trigger_name VARCHAR(200) NOT NULL,
trigger_group VARCHAR(200) NOT NULL,
blob_data BLOB NULL,
PRIMARY KEY (sched_name,trigger_name,trigger_group),
INDEX (sched_name,trigger_name, trigger_group),
FOREIGN KEY (sched_name,trigger_name,trigger_group)
REFERENCES qrtz_triggers(sched_name,trigger_name,trigger_group))
ENGINE=INNODB;

CREATE TABLE qrtz_calendars (
sched_name VARCHAR(120) NOT NULL,
calendar_name VARCHAR(200) NOT NULL,
calendar BLOB NOT NULL,
PRIMARY KEY (sched_name,calendar_name))
ENGINE=INNODB;

CREATE TABLE qrtz_paused_trigger_grps (
sched_name VARCHAR(120) NOT NULL,
trigger_group VARCHAR(200) NOT NULL,
PRIMARY KEY (sched_name,trigger_group))
ENGINE=INNODB;

CREATE TABLE qrtz_fired_triggers (
sched_name VARCHAR(120) NOT NULL,
entry_id VARCHAR(95) NOT NULL,
trigger_name VARCHAR(200) NOT NULL,
trigger_group VARCHAR(200) NOT NULL,
instance_name VARCHAR(200) NOT NULL,
fired_time BIGINT(13) NOT NULL,
sched_time BIGINT(13) NOT NULL,
priority INTEGER NOT NULL,
state VARCHAR(16) NOT NULL,
job_name VARCHAR(200) NULL,
job_group VARCHAR(200) NULL,
is_nonconcurrent VARCHAR(1) NULL,
requests_recovery VARCHAR(1) NULL,
PRIMARY KEY (sched_name,entry_id))
ENGINE=INNODB;

CREATE TABLE qrtz_scheduler_state (
sched_name VARCHAR(120) NOT NULL,
instance_name VARCHAR(200) NOT NULL,
last_checkin_time BIGINT(13) NOT NULL,
checkin_interval BIGINT(13) NOT NULL,
PRIMARY KEY (sched_name,instance_name))
ENGINE=INNODB;

CREATE TABLE qrtz_locks (
sched_name VARCHAR(120) NOT NULL,
lock_name VARCHAR(40) NOT NULL,
PRIMARY KEY (sched_name,lock_name))
ENGINE=INNODB;



CREATE TABLE qrtz_job_logs (
  pkid BIGINT(20) NOT NULL AUTO_INCREMENT,
  entry_id VARCHAR(200) DEFAULT NULL,
  trigger_name VARCHAR(200) DEFAULT NULL,
  trigger_group VARCHAR(200) DEFAULT NULL,
  start_time DATETIME DEFAULT NULL,
  end_time DATETIME DEFAULT NULL,
  state INT(2) DEFAULT NULL,
  job_name VARCHAR(200) DEFAULT NULL,
  job_group VARCHAR(4000) DEFAULT NULL,
  run_type INT(2) DEFAULT NULL,
  PRIMARY KEY (pkid)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
CREATE TABLE qrtz_job_failed_logs (
  pkid BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  log_id BIGINT(20) DEFAULT NULL,
  failed_step INT(2) DEFAULT NULL,
  object_id VARCHAR(4000) DEFAULT NULL,
  created_time DATETIME DEFAULT NULL,
  info VARCHAR(4000) DEFAULT NULL,
  trigger_name VARCHAR(200) DEFAULT NULL,
  job_name VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (pkid)
) ENGINE=INNODB DEFAULT CHARSET=utf8;







CREATE INDEX idx_qrtz_j_req_recovery ON qrtz_job_details(sched_name,requests_recovery);
CREATE INDEX idx_qrtz_j_grp ON qrtz_job_details(sched_name,job_group);

CREATE INDEX idx_qrtz_t_j ON qrtz_triggers(sched_name,job_name,job_group);
CREATE INDEX idx_qrtz_t_jg ON qrtz_triggers(sched_name,job_group);
CREATE INDEX idx_qrtz_t_c ON qrtz_triggers(sched_name,calendar_name);
CREATE INDEX idx_qrtz_t_g ON qrtz_triggers(sched_name,trigger_group);
CREATE INDEX idx_qrtz_t_state ON qrtz_triggers(sched_name,trigger_state);
CREATE INDEX idx_qrtz_t_n_state ON qrtz_triggers(sched_name,trigger_name,trigger_group,trigger_state);
CREATE INDEX idx_qrtz_t_n_g_state ON qrtz_triggers(sched_name,trigger_group,trigger_state);
CREATE INDEX idx_qrtz_t_next_fire_time ON qrtz_triggers(sched_name,next_fire_time);
CREATE INDEX idx_qrtz_t_nft_st ON qrtz_triggers(sched_name,trigger_state,next_fire_time);
CREATE INDEX idx_qrtz_t_nft_misfire ON qrtz_triggers(sched_name,misfire_instr,next_fire_time);
CREATE INDEX idx_qrtz_t_nft_st_misfire ON qrtz_triggers(sched_name,misfire_instr,next_fire_time,trigger_state);
CREATE INDEX idx_qrtz_t_nft_st_misfire_grp ON qrtz_triggers(sched_name,misfire_instr,next_fire_time,trigger_group,trigger_state);

CREATE INDEX idx_qrtz_ft_trig_inst_name ON qrtz_fired_triggers(sched_name,instance_name);
CREATE INDEX idx_qrtz_ft_inst_job_req_rcvry ON qrtz_fired_triggers(sched_name,instance_name,requests_recovery);
CREATE INDEX idx_qrtz_ft_j_g ON qrtz_fired_triggers(sched_name,job_name,job_group);
CREATE INDEX idx_qrtz_ft_jg ON qrtz_fired_triggers(sched_name,job_group);
CREATE INDEX idx_qrtz_ft_t_g ON qrtz_fired_triggers(sched_name,trigger_name,trigger_group);
CREATE INDEX idx_qrtz_ft_tg ON qrtz_fired_triggers(sched_name,trigger_group);

SET FOREIGN_KEY_CHECKS = 1;
COMMIT; 
