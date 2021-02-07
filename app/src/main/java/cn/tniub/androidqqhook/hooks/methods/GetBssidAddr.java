package cn.tniub.androidqqhook.hooks.methods;

import android.content.Context;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class GetBssidAddr extends AbstractHookRequest {

    public GetBssidAddr(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.util"),
                "get_bssid_addr",
                Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String bssidAddr = new String((byte[]) param.getResult());
//                        xpLog("bssidAddr: " + bssidAddr);
                        new MyAsyncTask().execute("get_bssid_addr", bssidAddr);
                    }
                });
    }
}
