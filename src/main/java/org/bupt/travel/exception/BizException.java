package org.bupt.travel.exception;

/**
 * 类名称：BizException    
 * 类描述：此系统抛出业务异常    
 * 创建人：shanyb@lianjia.com  
 * 创建时间：2014-12-16 下午4:46:53     
 * @version
 */
public class BizException extends RuntimeException {

    private String errCode = null;


    public BizException(MessageCode exceptionCode) {
        super(exceptionCode.getErrDesc());
        this.errCode = exceptionCode.getErrCode();
    }

    public BizException(MessageCode exceptionCode, Throwable cause) {
        super(exceptionCode.getErrDesc(), cause);
        this.errCode = exceptionCode.getErrCode();
    }

    public BizException(MessageCode exceptionCode, String message) {
        super(message);
        this.errCode = exceptionCode.getErrCode();
    }

    public BizException(MessageCode exceptionCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = exceptionCode.getErrCode();
    }

    public BizException(String errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = String.valueOf(errCode);
    }

    public BizException(String errCode, String message) {
        super(message);
        this.errCode = String.valueOf(errCode);
    }

    public String getErrCode() {
        return this.errCode;
    }

}
