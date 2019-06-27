package com.casstime.route;

import android.content.Context;
import android.net.Uri;

import com.casstime.route.arouter.CTARouterWrapper;
import com.casstime.route.face.CTNavigationCallback;
import com.casstime.route.face.ICTPostcard;
import com.casstime.route.face.ICTRouter;

/**
 * Created by maiwenchang at 2019-05-24 16:21
 * Description ：开思组件间路由器
 */
public class CTRouter {

    private ICTRouter mRouter;

    private CTRouter(){
        //初始化ARouter包装类
        mRouter = new CTARouterWrapper();
    }

    private volatile static CTRouter instance;

    //实现单例模式
    public static CTRouter getInstance() {
        if (instance == null) {
            synchronized (CTRouter.class) {
                if (instance == null) {
                    instance = new CTRouter();
                }
            }
        }
        return instance;
    }

    /**
     * Inject params and services.
     */
    public void inject(Object thiz) {
        mRouter.inject(thiz);
    }

    /**
     * Build the roadmap, draw a postcard.
     *
     * @param path Where you go.
     */
    public ICTPostcard build(String path) {
        return mRouter.build(path);
    }

    /**
     * Build the roadmap, draw a postcard.
     *
     * @param url the path
     */
    public ICTPostcard build(Uri url) {
        return mRouter.build(url);
    }

    /**
     * Launch the navigation by type
     *
     * @param service interface of service
     * @param <T>     return type
     * @return instance of service
     */
    public <T> T navigation(Class<? extends T> service) {
        return mRouter.navigation(service);
    }

    /**
     * Launch the navigation.
     *
     * @param mContext    .
     * @param postcard    .
     * @param requestCode Set for startActivityForResult
     * @param callback    cb
     */
    public Object navigation(Context mContext, ICTPostcard postcard, int requestCode, CTNavigationCallback callback) {
        return mRouter.navigation(mContext, postcard, requestCode, callback);
    }

}
