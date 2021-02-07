package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SetPriKey extends AbstractHookRequest {

    private Class<?> EcdhCrypt;

    public SetPriKey(XC_LoadPackage.LoadPackageParam loadPackageParam) throws ClassNotFoundException {
        super(loadPackageParam);
        EcdhCrypt = loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.EcdhCrypt");
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(EcdhCrypt, "set_c_pri_key",
                byte[].class, new XC_MethodHook() {

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String priKey = Util.hexDump((byte[]) param.args[0]);
                        new MyAsyncTask().execute("set_c_pri_key", priKey);
                    }
                });
    }
}
