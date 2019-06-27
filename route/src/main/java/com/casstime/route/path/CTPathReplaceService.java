package com.casstime.route.path;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.service.PathReplaceService;

import java.util.Map;

/**
 * description: 开思跳转协议重定向服务
 * <p>
 * email: jun.hou@casstime.com
 * <p>
 * date: created on 2019/2/28
 * <p>
 * author:   侯军(A01082)
 */
public class CTPathReplaceService implements PathReplaceService {

    @Override
    public Uri forUri(Uri uri) {
        return null;
    }

    @Override
    public void init(Context context) {
    }

    @Override
    public String forString(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        Map<String, String> map = CTPathReplaceMapping.getReplaceMapping();
        if (map == null || map.isEmpty()) {
            return null;
        }
        //todo replace
        return null;
    }
}
