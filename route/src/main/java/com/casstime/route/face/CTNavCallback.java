package com.casstime.route.face;

/**
 * Created by maiwenchang at 2019-06-19 12:39
 * Description ：路由跳转监听接口封装
 */
public abstract class CTNavCallback implements CTNavigationCallback {

    @Override
    public void onFound(ICTPostcard postcard) {

    }

    @Override
    public void onLost(ICTPostcard postcard) {

    }

    @Override
    public void onArrival(ICTPostcard postcard) {

    }

    @Override
    public void onInterrupt(ICTPostcard postcard) {

    }
}
