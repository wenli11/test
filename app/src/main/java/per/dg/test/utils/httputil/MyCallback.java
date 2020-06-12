package per.dg.test.utils.httputil;

import android.util.Log;

import per.dg.test.utils.httputil.model.DataResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public abstract class MyCallback<T> implements Callback<DataResponse<T>> {


    @Override
    public void onResponse(Call<DataResponse<T>> call, Response<DataResponse<T>> response) {
        DataResponse<T> dataResponse = response.body();
        int errorCode = dataResponse.getErrorCode();
        if(errorCode == 0){
            onSuccess(dataResponse.getData());
        }else {
            onFail(errorCode, dataResponse.getErrorMsg());
        }
    }

    @Override
    public void onFailure(Call<DataResponse<T>> call, Throwable t) {
        onFail(-1, HttpExceptionUtil.exceptionHandler(t));
    }

    public abstract void onSuccess(T t);

    public abstract void onFail(int errCode, String errMsg);
}
