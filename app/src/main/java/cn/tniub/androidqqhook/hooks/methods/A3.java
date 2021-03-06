package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class A3 extends AbstractHookRequest {

    public A3(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("com.tencent.mobileqq.msf.core.auth.a"),
                "f",
                byte[].class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String A3 = Util.hexDump((byte[]) param.args[0]);
//                        xpLog("A3: " + A3);
                        new MyAsyncTask().execute("A3", A3);
                    }
                });
    }
}
