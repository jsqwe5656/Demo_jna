package com.example.zbf.demo_jna;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

/**
 *
 * Created by zbf on 2018/2/5.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数3:Push推送业务的secret
         */
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "5a77c5ac8f4a9d71d900004b");

        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true);
    }
}
