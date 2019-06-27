# casstime-route-android

#### 介绍
开思时代模块间通信组件，基于Arouter开发，扩展了接口调用功能，彻底解耦业务模块。


#### 安装教程
1. 在基础模块的`build.gradle`中引入组件
```
implementation 'com.casstime.ec:route:0.0.1'
```

2. 使用Gradle插件实现路由表的自动加载，解决加固引起的初始化失败问题
```
buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath "com.alibaba:arouter-register:1.0.2"
    }
}
```

3. 在业务模块的'build.gradle'中使用arouter路由表的自动加载插件

方法一(推荐)：

把`arouter.gradle`(java版本)拷贝到您的项目根目录，然后在业务模块的'build.gradle'中引用：
```
apply from: '../arouter.gradle'
```

方法二：

在业务模块的'build.gradle'中添加：
```
apply plugin: 'com.alibaba.arouter'

android {
    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [AROUTER_MODULE_NAME: project.getName(), AROUTER_GENERATE_DOC: "enable"]
            }
        }
    }
}

dependencies {
    annotationProcessor "com.alibaba:arouter-compiler:1.2.2"
}
```

> kotin版本引用方式：
```
apply plugin: 'com.alibaba.arouter'

kapt {
    arguments {
        arg("AROUTER_MODULE_NAME", project.getName())
        arg("AROUTER_GENERATE_DOC", "enable")
    }
}

dependencies {
    kapt "com.alibaba:arouter-compiler:1.2.2"
}
```




#### 使用说明

与Arouter的使用类似（参考：[README_CN](https://github.com/alibaba/ARouter/blob/master/README_CN.md)）


1. 初始化SDK:
```
CTRouteInitHelper.initWithApplication(application, BuildConfig.DEBUG);
```
2. 添加注解
```
// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
@Route(path = "/test/activity")
public class YourActivity extend Activity {
    ...
}
```

3. 发起路由操作
```
// 1. 应用内简单的跳转
CTRouter.getInstance().build("/test/activity").navigation();

// 2. 跳转并携带参数
CTRouter.getInstance().build("/test/1")
            .withLong("key1", 666L)
            .withString("key3", "888")
            .withObject("key4", new Test("Jack", "Rose"))
            .navigation();
```

4. 声明服务(任意业务模块中，无需下沉到基础模块)
```
// 声明接口,其他组件通过接口来调用服务
public interface HelloService extends ICTProvider {
    String sayHello(String name);
}

// 实现接口,暴露服务
@Route(path = "/user/hello", name = "测试服务")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
    return "hello, " + name;
    }

    @Override
    public void init(Context context) {

    }
}

```

5. 调用服务
```
//发现服务
ICTProvider userProvider = (ICTProvider) CTRouter.getInstance().build("/user/hello").navigation();

//调用服务
userProvider.call("sayHello","xiaoming");

```

### 详细文档请前往：[Android开发技术文档/组件/route](http://maiwenchang.gitee.io/cassec-mkdocs-android/component/route/%E5%BF%AB%E9%80%9F%E5%BC%80%E5%A7%8B/)

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
