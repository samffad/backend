package org.bupt.travel.exception;


public enum MessageCode {

    BIZ_00000("平台错误!"),

    BIZ_00001("请登录后再进行相关操作!"),

    BIZ_00002("文件未上传!"),
    
    BIZ_00003("文件表头title不正确!"),
    
    BIZ_00004("行数据格式不正确!"),

    BIZ_00005("的店面信息不存在,请删除无效店面后重试!"),
    

    BIZ_00006("单元格格式不正确,请参照模板!"),
    
    BIZ_00007("插入成本明细失败！"),
    
    BIZ_00008("请使用07版Excel上传！"),
    
    BIZ_00009("经纪人工号不存在"),
    
    BIZ_00010("请上传近两个月的成本！"),

    BIZ_00011("文件上传失败,请检查文件后重新上传！"),
    
    BIZ_00012("数字列格式不正确,不能有空格或者“-”,请检查该列内容后重新上传！"),
    
    PROXY_00000("业绩文件不存在"),

    PROXY_00001("写入数据中心文件失败!"),
    
    BattleTeamOrmError("查询数据失败");

    private String errCode = null;
    private String errDesc = null;

    private MessageCode(String errDesc) {
        this.errCode = name();
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrDesc() {
        return this.errDesc;
    }

    public void setErrDesc(String errDesc) {
        this.errDesc = errDesc;
    }

    public String toString() {
        return this.errCode;
    }
}
