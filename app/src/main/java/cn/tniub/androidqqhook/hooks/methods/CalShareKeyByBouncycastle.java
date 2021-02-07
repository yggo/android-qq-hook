package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class CalShareKeyByBouncycastle extends AbstractHookRequest {

    private final Class<?> EcdhCrypt;

    public CalShareKeyByBouncycastle(XC_LoadPackage.LoadPackageParam loadPackageParam) throws ClassNotFoundException {
        super(loadPackageParam);
        EcdhCrypt = loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.EcdhCrypt");
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(EcdhCrypt, "calShareKeyByBouncycastle",
                byte[].class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String shareKey = Util.hexDump((byte[]) param.getResult());
                        xpLog("calShareKeyByBouncycastle input: " + Util.hexDump((byte[]) param.args[0]));
                        new MyAsyncTask().execute("calShareKeyByBouncycastle", shareKey);
                    }
                });
    }
}
