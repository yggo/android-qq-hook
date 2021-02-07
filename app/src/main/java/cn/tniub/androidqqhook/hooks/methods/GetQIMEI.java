package cn.tniub.androidqqhook.hooks.methods;

import android.content.Context;
import android.content.SharedPreferences;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class GetQIMEI extends AbstractHookRequest {

    public GetQIMEI(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.util"),
                "get_qimei",
                Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        SharedPreferences sp = ((Context) param.args[0]).getSharedPreferences("DENGTA_META", 0);
                        String qimei = sp.getString("QIMEI_DENGTA", "");
//                        xpLog("qimei: " + qimei);
                        new MyAsyncTask().execute("get_qimei", qimei);
                    }
                });
    }
}
