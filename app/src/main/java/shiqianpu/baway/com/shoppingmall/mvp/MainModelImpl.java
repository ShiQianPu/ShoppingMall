package shiqianpu.baway.com.shoppingmall.mvp;

import java.util.HashMap;
import java.util.Map;

import shiqianpu.baway.com.shoppingmall.net.NetUtil;

public class MainModelImpl implements MainCanstract.IMainModel {

private NetUtil util;
    private Map<String, String> map;

    public MainModelImpl() {
        util = NetUtil.getInstance();
    }

    @Override
    public void doNetPost(String url, String phone, String pwd, NetUtil.CallBackTask backTask) {
        map = new HashMap<>();
        map.put("phone",phone);
        map.put("pwd",pwd);
        util.doNetPost(url,map,backTask);
    }
}
