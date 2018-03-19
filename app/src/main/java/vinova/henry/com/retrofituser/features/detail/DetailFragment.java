package vinova.henry.com.retrofituser.features.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vinova.henry.com.retrofituser.R;
import vinova.henry.com.retrofituser.features.home.HomeContract;

public class DetailFragment extends Fragment implements DetailContract.View{


    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
}
