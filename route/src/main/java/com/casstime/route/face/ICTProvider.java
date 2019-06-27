package com.casstime.route.face;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by maiwenchang at 2019-06-19 10:25
 * Description ：开思Provider的接口
 */
public interface ICTProvider extends IProvider{

    /**
     * 方法调用:
     * 同步方法直接传方法名和参数即可，异步方法在参数中传一个通用的Callback即可,如io.reactivex.Observer
     * @param methodName 方法名
     * @param arguments 参数
     * @return 返回值
     */
    Object call(String methodName, Object... arguments);

}
