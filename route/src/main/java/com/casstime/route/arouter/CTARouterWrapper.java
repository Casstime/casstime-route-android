package com.casstime.route.arouter;


import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.casstime.route.face.CTNavigationCallback;
import com.casstime.route.face.ICTPostcard;
import com.casstime.route.face.ICTRouter;

/**
 * Created by maiwenchang at 2019-06-18 16:31
 * Description ：Arouter的包装类
 */
public class CTARouterWrapper implements ICTRouter {

    @Override
    public void inject(Object thiz) {
        ARouter.getInstance().inject(thiz);
    }

    @Override
    public ICTPostcard build(String path) {
        Postcard postcard = ARouter.getInstance().build(path);
        return new CTARouterPostcard(postcard);
    }

    @Override
    public ICTPostcard build(Uri url) {
        Postcard postcard = ARouter.getInstance().build(url);
        return new CTARouterPostcard(postcard);
    }

    @Override
    public <T> T navigation(Class<? extends T> service) {
        return ARouter.getInstance().navigation(service);
    }

    @Override
    public Object navigation(Context mContext, ICTPostcard postcard, int requestCode, CTNavigationCallback callback) {
        if (!(postcard instanceof CTARouterPostcard)) {
            return null;
        }
        if (callback == null) {
            return ARouter.getInstance().navigation(mContext, (((CTARouterPostcard) postcard).getPostcard()), requestCode, null);
        }
        return ARouter.getInstance().navigation(mContext, ((CTARouterPostcard) postcard).getPostcard(), requestCode, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                callback.onFound(new CTARouterPostcard(postcard));
            }

            @Override
            public void onLost(Postcard postcard) {
                callback.onLost(new CTARouterPostcard(postcard));
            }

            @Override
            public void onArrival(Postcard postcard) {
                callback.onArrival(new CTARouterPostcard(postcard));
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                callback.onInterrupt(new CTARouterPostcard(postcard));
            }
        });
    }


}
