package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class A2 extends AbstractHookRequest {

    public A2(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("com.tencent.mobileqq.msf.core.auth.a"),
                "e",
                byte[].class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String A2 = Util.hexDump((byte[]) param.args[0]);
//                        xpLog("A2: " + A2);
                        new MyAsyncTask().execute("A2", A2);
                    }
                });
    }
}
