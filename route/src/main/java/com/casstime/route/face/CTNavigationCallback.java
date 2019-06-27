package com.casstime.route.face;

/**
 * Created by maiwenchang at 2019-06-19 09:45
 * Description ：路由跳转监听接口封装
 */
public interface CTNavigationCallback {

    /**
     * Callback when find the destination.
     *
     * @param postcard meta
     */
    void onFound(ICTPostcard postcard);

    /**
     * Callback after lose your way.
     *
     * @param postcard meta
     */
    void onLost(ICTPostcard postcard);

    /**
     * Callback after navigation.
     *
     * @param postcard meta
     */
    void onArrival(ICTPostcard postcard);

    /**
     * Callback on interrupt.
     *
     * @param postcard meta
     */
    void onInterrupt(ICTPostcard postcard);

}
