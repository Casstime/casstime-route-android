package com.casstime.route;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * description: 开思路由初始化辅助类
 * <p>
 * email: jun.hou@casstime.com
 * <p>
 * date: created on 2019/3/8
 * <p>
 * author:   侯军(A01082)
 */
public class CTRouteInitHelper {

    /**
     * 路由初始化
     *
     * @param application 当前应用实例 {@link Application}
     * @param isDebug     是否是debug模式
     */
    public static void initWithApplication(Application application, boolean isDebug) {
        if (isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
            ARouter.printStackTrace();
        }
        ARouter.init(application);
    }

    private CTRouteInitHelper() {
    }
}
