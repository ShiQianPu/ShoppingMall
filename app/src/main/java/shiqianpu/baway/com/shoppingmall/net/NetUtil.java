package shiqianpu.baway.com.shoppingmall.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.Map;

import shiqianpu.baway.com.shoppingmall.MyApplication;

public class NetUtil {
    private static final NetUtil ourInstance = new NetUtil();

    public static NetUtil getInstance() {
        return ourInstance;
    }

    private NetUtil() {
    }
    public void doNetGet(final String url,final CallBackTask backTask){
        //
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backTask.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backTask.onError(2002, "无数据");
            }
        });
        MyApplication.getQueue().add(request);
    }
    //post
    public void doNetPost(String url, final Map<String,String> param,final CallBackTask backTask){
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backTask.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backTask.onError(2002,"不行");
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return param;
            }
        };
            MyApplication.getQueue().add(request);
    }
   public interface CallBackTask{
        void onError(int code,String msg);
        void onSuccess(String s);
   }
}
