package per.dg.test.utils.httputil.model;

public class DataResponse<T> {

    private T data;
//errorCode = 0 代表执行成功，不建议依赖任何非0的 errorCode.
//errorCode = -1001 代表登录失效，需要重新登录。
    private int errorCode;

    private String errorMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
