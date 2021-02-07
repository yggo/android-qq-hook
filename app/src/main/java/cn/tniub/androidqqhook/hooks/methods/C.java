package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class C extends AbstractHookRequest {

    public C(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.request.oicq_request"),
                "c",
                byte[].class, byte[].class, byte[].class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String arg1 = Util.hexDump((byte[]) param.args[0]);
                        String arg2 = Util.hexDump((byte[]) param.args[1]);
                        String arg3 = Util.hexDump((byte[]) param.args[2]);
                        String res = Util.hexDump((byte[]) param.getResult());
                        xpLog(String.format("arg1: %s arg2: %s arg3: %s res: %s",
                                arg1, arg2, arg3, res));
                    }
                });
    }
}
