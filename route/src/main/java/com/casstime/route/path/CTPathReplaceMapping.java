package com.casstime.route.path;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 开思重定向的path的mapping
 * <p>
 * email: jun.hou@casstime.com
 * <p>
 * date: created on 2019/2/28
 * <p>
 * author:   侯军(A01082)
 */
public class CTPathReplaceMapping {

    private static Map<String, String> sReplaceMapping;

    static {
        sReplaceMapping = new HashMap<>();
        //todo
    }

    /**
     * 移除重定向的配置
     *
     * @param originPath 原始path
     */
    public static void removeWithPath(String originPath) {
        if (TextUtils.isEmpty(originPath)) {
            return;
        }
        if (sReplaceMapping == null || sReplaceMapping.isEmpty()) {
            return;
        }
        if (!(sReplaceMapping.containsKey(originPath))) {
            return;
        }
        sReplaceMapping.remove(originPath);
    }

    /**
     * 更具json文件进行全量的配置
     *
     * @param config json配置
     */
    public static void replacePathWithConfig(String config) {
        if (TextUtils.isEmpty(config)) {
            return;
        }
        //todo
    }

    /**
     * 添加重定向path
     *
     * @param originPath 原始path
     * @param targetPath 重定向path
     */
    public static void replacePath2TargetPath(String originPath, String targetPath) {
        if (sReplaceMapping == null) {
            sReplaceMapping = new HashMap<>();
        }
        if (sReplaceMapping.containsKey(originPath)) {
            return;
        }
        if (TextUtils.isEmpty(originPath) || TextUtils.isEmpty(targetPath)) {
            return;
        }
        sReplaceMapping.put(originPath, targetPath);
    }

    /**
     * 清空
     */
    public static void clear() {
        if (sReplaceMapping == null || sReplaceMapping.isEmpty()) {
            return;
        }
        sReplaceMapping.clear();
    }

    /**
     * 获取重定向path的map配置
     *
     * @return 重定向path的map配置
     */
    public static Map<String, String> getReplaceMapping() {
        return sReplaceMapping;
    }
}
