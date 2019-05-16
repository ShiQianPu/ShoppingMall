package shiqianpu.baway.com.shoppingmall.mvp;

import android.content.Context;
import android.content.Intent;

import shiqianpu.baway.com.shoppingmall.HomeActivity;
import shiqianpu.baway.com.shoppingmall.net.NetUtil;

public class MainPresenterImpl implements MainCanstract.IMainPresenter {
    private MainCanstract.IMainModel model;
    private MainCanstract.IMainView view;
    @Override
    public void attach(MainCanstract.IMainView view) {
        this.view=view;
        model=new MainModelImpl();
    }

    @Override
    public void detach() {
        if (view!=null){
            view=null;
        }
        if (model!=null){
            model=null;
        }
        System.gc();
    }

    @Override
    public void getLogin(String url, String phone, String pwd) {
        model.doNetPost(url, phone, pwd, new NetUtil.CallBackTask() {
            @Override
            public void onError(int code, String msg) {

            }

            @Override
            public void onSuccess(String s) {
                view.showLogin(s);
            }
        });
    }

    @Override
    public void getZhuce(String url, String phone, String pwd) {
        model.doNetPost(url, phone, pwd, new NetUtil.CallBackTask() {
            @Override
            public void onError(int code, String msg) {

            }

            @Override
            public void onSuccess(String s) {
                view.showZhuce(s);
            }
        });
    }

    @Override
    public void toMain(Context context) {
        context.startActivity(new Intent(context, HomeActivity.class));
    }
}
