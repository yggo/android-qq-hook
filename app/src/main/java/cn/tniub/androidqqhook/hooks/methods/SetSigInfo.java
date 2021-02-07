package cn.tniub.androidqqhook.hooks.methods;

import com.alibaba.fastjson.JSON;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SetSigInfo extends AbstractHookRequest {

    public SetSigInfo(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.sharemem.WloginSigInfo"),
                "SetSigInfo",
                long.class, long.class, long.class, long.class, byte[].class, byte[].class, byte[].class, byte[].class, byte[].class, byte[].class, byte[].class, byte[].class, byte[].class, byte[].class, byte[].class, byte[].class, byte[][].class, long[].class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        new MyAsyncTask().execute("SetSigInfo", JSON.toJSONString(param.thisObject));
                    }
                });
    }
}
