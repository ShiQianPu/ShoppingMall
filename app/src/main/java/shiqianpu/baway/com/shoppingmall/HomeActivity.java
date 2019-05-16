package shiqianpu.baway.com.shoppingmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import shiqianpu.baway.com.shoppingmall.adapter.MovieAdapter;
import shiqianpu.baway.com.shoppingmall.bean.MovieBean;
import shiqianpu.baway.com.shoppingmall.net.NetUtil;

public class HomeActivity extends AppCompatActivity {
    private String ser = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=10";
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadData();
    }

    private void loadData() {
        NetUtil.getInstance().doNetGet(ser, new NetUtil.CallBackTask() {
            @Override
            public void onError(int code, String msg) {

            }

            @Override
            public void onSuccess(String s) {
                Gson gson = new Gson();
                MovieBean movieBean = gson.fromJson(s, MovieBean.class);
                List<MovieBean.ResultBean> result = movieBean.getResult();
                MovieAdapter movieAdapter = new MovieAdapter(HomeActivity.this, result);
                recyclerView.setAdapter(movieAdapter);
            }
        });
    }
}
