package org.bupt.travel.exception;

/**
 * 类名称：ProxyExcption    
 * 类描述：调用第三方平台异常    
 * 创建人：shanyb@lianjia.com  
 * 创建时间：2014-12-16 下午4:47:55     
 * @version
 */
public class ProxyException extends RuntimeException {

    private String errCode = null;


    public ProxyException(MessageCode exceptionCode) {
        super(exceptionCode.getErrDesc());
        this.errCode = exceptionCode.getErrCode();
    }

    public ProxyException(MessageCode exceptionCode, Throwable cause) {
        super(exceptionCode.getErrDesc(), cause);
        this.errCode = exceptionCode.getErrCode();
    }

    public ProxyException(MessageCode exceptionCode, String message) {
        super(message);
        this.errCode = exceptionCode.getErrCode();
    }

    public ProxyException(MessageCode exceptionCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = exceptionCode.getErrCode();
    }

    public ProxyException(String errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = String.valueOf(errCode);
    }

    public ProxyException(String errCode, String message) {
        super(message);
        this.errCode = String.valueOf(errCode);
    }

    public String getErrCode() {
        return this.errCode;
    }
}
