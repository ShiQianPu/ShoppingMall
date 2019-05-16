package shiqianpu.baway.com.shoppingmall.mvp;

import android.content.Context;

import shiqianpu.baway.com.shoppingmall.net.NetUtil;

public interface MainCanstract {
    public interface IMainView{
        void showLogin(String s);
        void loginError();
        void showZhuce(String s);
        void zhuceError();
    }
    public interface IMainModel{
        void doNetPost(String url, String phone, String pwd, NetUtil.CallBackTask backTask);
    }
    public interface IMainPresenter{
        void attach(IMainView view);

        void detach();
        void getLogin(String url,String phone,String pwd);
        void getZhuce(String url,String phone,String pwd);
        void toMain(Context context);
    }
}
