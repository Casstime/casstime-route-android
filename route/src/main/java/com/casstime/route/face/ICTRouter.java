package com.casstime.route.face;

import android.content.Context;
import android.net.Uri;

/**
 * Created by maiwenchang at 2019-06-18 16:33
 * Description ：
 */
public interface ICTRouter {


    void inject(Object thiz);


    ICTPostcard build(String path);


    ICTPostcard build(Uri url);


    <T> T navigation(Class<? extends T> service);


    Object navigation(Context mContext, ICTPostcard postcard, int requestCode, CTNavigationCallback callback);


}
