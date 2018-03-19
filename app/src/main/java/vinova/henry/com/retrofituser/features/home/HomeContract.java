package vinova.henry.com.retrofituser.features.home;

import vinova.henry.com.retrofituser.pojo.IUserService;

/**
 * Created by dminh on 2/2/2018.
 */

public interface HomeContract {
    interface View  {
        void showSuccess();
        void showFail();
    }
    interface Presenter {
        void getUserFromServer(IUserService iUserService);
    }
}
