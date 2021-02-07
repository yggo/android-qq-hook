package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class SetShareKey extends AbstractHookRequest {

    private Class<?> EcdhCrypt;

    public SetShareKey(XC_LoadPackage.LoadPackageParam loadPackageParam) throws ClassNotFoundException {
        super(loadPackageParam);
        EcdhCrypt = loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.EcdhCrypt");
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(EcdhCrypt, "set_g_share_key",
                byte[].class, new XC_MethodHook() {

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String shareKey = Util.hexDump((byte[]) param.args[0]);
                        //new MyAsyncTask().execute();
                        new MyAsyncTask().execute("set_g_share_key", shareKey);
                    }
                });
    }
}
