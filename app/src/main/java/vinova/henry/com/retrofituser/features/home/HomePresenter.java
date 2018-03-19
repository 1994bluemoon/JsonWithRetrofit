package vinova.henry.com.retrofituser.features.home;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinova.henry.com.retrofituser.models.ResultResponse;
import vinova.henry.com.retrofituser.models.User;
import vinova.henry.com.retrofituser.pojo.IUserService;

/**
 * Created by dminh on 2/2/2018.
 */

public class HomePresenter implements HomeContract.Presenter{

    HomeContract.View view;
    List<User> users;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        users = new ArrayList<>();
    }

    @Override
    public void getUserFromServer(IUserService iUserService) {
        Call<ResultResponse> call = iUserService.getServerData("0", "10");
        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                users.addAll(response.body());
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {

            }
        });
    }
}
