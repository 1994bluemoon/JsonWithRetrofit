package vinova.henry.com.retrofituser.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinova.henry.com.retrofituser.R;
import vinova.henry.com.retrofituser.adapters.UserAdapter;
import vinova.henry.com.retrofituser.models.User;
import vinova.henry.com.retrofituser.models.pojo.ApiUtils;
import vinova.henry.com.retrofituser.models.pojo.IUserService;
import vinova.henry.com.retrofituser.models.pojo.ResultResponse;

public class MainActivity extends AppCompatActivity {

    IUserService IuserService;
    List<User> users;
    public UserAdapter adapter;

    @BindView(R.id.rcv_main)
    RecyclerView rcvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        users = null;
        adapter = new UserAdapter(this);
        rcvMain.setAdapter(adapter);
        rcvMain.setLayoutManager(new LinearLayoutManager(this));

        IuserService = ApiUtils.getSOService();

        Call<ResultResponse> call = IuserService.getServerData("0", "10");
        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {

                users = (response.body().getUsers());
                adapter.setUsers(users);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                Log.d("TAG", "fail");
                call.cancel();
            }
        });
    }
}
