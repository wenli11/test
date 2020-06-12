package per.dg.test.utils.httputil;

public interface HttpCallback<T> {

    void onSuccess(T t);

    void onFail(int errorCode, String errorMsg);

}
