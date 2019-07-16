package com.casstime.route.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Created by WenChang Mai on 2019/1/31 10:04.
 * Description:
 */
@Interceptor(priority = 0, name = "测试用拦截器")
public class TestInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
    }
}
