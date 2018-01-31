package vinova.henry.com.retrofituser.models.pojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dminh on 1/31/2018.
 */

public interface IUserService {
    @GET("users?")
    Call<ResultResponse> getServerData(@Query("page") String page, @Query("limit") String limit);

}
