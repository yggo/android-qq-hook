package cn.tniub.androidqqhook.hooks.methods;

import android.content.Context;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class GetIMSI extends AbstractHookRequest {

    public GetIMSI(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.util"),
                "get_IMSI",
                Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String imsi = new String((byte[]) param.getResult());
//                        xpLog("imsi: " + imsi);
                        new MyAsyncTask().execute("get_IMSI", imsi);
                    }
                });
    }
}
