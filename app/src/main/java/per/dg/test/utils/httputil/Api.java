package per.dg.test.utils.httputil;

import android.util.Log;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import per.dg.test.utils.httputil.model.Banner;
import per.dg.test.utils.httputil.model.DataResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

public class Api {

    private static Api instance;

    private ApiService apiService;

    public static Api getInstance(){
        if(instance == null){
            synchronized (Api.class) {
                if(instance == null){
                    instance = new Api();
                }
            }
        }
        return instance;
    }

    private Api(){
        init();
    }

    private void init(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
//                .addInterceptor(headerInterceptor)
//                .addInterceptor(new HeaderInterceptor())
//                .connectTimeout(100, TimeUnit.SECONDS)
//                .writeTimeout(100, TimeUnit.SECONDS)
//                .readTimeout(100, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantHttp.BASEURL)
//                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void getHomeBanner(MyCallback<List<Banner>> result){
        apiService.getHomeBanner().enqueue(result);
    }

    public void getHomeBanner(){
        MediatorLiveData<List<Banner>> bannersLiveDate = new MediatorLiveData<>();

        apiService.getHomeBanner().enqueue(new MyCallback<List<Banner>>() {
            @Override
            public void onSuccess(List<Banner> banners) {

            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }

}
