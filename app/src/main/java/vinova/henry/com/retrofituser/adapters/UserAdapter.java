package vinova.henry.com.retrofituser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vinova.henry.com.retrofituser.R;
import vinova.henry.com.retrofituser.models.User;

/**
 * Created by dminh on 1/31/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    List<User> users;
    Context mContext;

    public UserAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public Context getmContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_view_user, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(mContext).load(users.get(position).getAvatar()).into(holder.imAvata);
        holder.tvName.setText("Name: " + users.get(position).getName());
        holder.tvUsername.setText("UserName: " + users.get(position).getUsername());
        holder.tvEmail.setText("Email: " + users.get(position).getEmail());
        holder.tvCountry.setText("Country: " + users.get(position).getAddress().getCity());
        holder.tvCity.setText("City: " + users.get(position).getAddress().getCity());
        holder.tvLat.setText("Lat: " + users.get(position).getAddress().getGeo().getLat());
        holder.tvLng.setText("Lng: " + users.get(position).getAddress().getGeo().getLng());
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.im_avata)
        ImageView imAvata;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_email)
        TextView tvEmail;
        @BindView(R.id.tv_country)
        TextView tvCountry;
        @BindView(R.id.tv_city)
        TextView tvCity;
        @BindView(R.id.tv_lat)
        TextView tvLat;
        @BindView(R.id.tv_lng)
        TextView tvLng;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
