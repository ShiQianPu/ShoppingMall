package shiqianpu.baway.com.shoppingmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import shiqianpu.baway.com.shoppingmall.mvp.MainCanstract;
import shiqianpu.baway.com.shoppingmall.mvp.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainCanstract.IMainView {
        private MainCanstract.IMainPresenter presenter;
    private EditText phone;
    private EditText pwd;
    private Button zhuce;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl();
            presenter.attach(this);
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        zhuce = findViewById(R.id.zhuce);
        login = findViewById(R.id.login);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getZhuce("http://172.17.8.100/small/user/v1/register",phone.getText().toString(),pwd.getText().toString());
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getLogin("http://172.17.8.100/small/user/v1/login",phone.getText().toString(),pwd.getText().toString());
            }
        });
    }

    @Override
    public void showLogin(String s) {
        try {
            JSONObject jsonObject=new JSONObject(s);
            String message = jsonObject.getString("message");
            if (message.equals("登录成功")){
                presenter.toMain(this);
            }else {
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loginError() {

    }

    @Override
    public void showZhuce(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void zhuceError() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

}
