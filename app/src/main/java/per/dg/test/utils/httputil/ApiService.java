package per.dg.test.utils.httputil;

import java.util.List;

import per.dg.test.utils.httputil.model.Articles;
import per.dg.test.utils.httputil.model.Banner;
import per.dg.test.utils.httputil.model.DataResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {

    @GET(ConstantHttp.HOME_BANNER)
    Call<DataResponse<List<Banner>>> getHomeBanner();


    @GET(ConstantHttp.ARTICLES)
    Call<DataResponse<Articles>> getArticles();

}
