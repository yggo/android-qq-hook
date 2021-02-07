package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Cryptor extends AbstractHookRequest {

    public Cryptor(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        Class<?> cryptor = loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.cryptor");
        XposedHelpers.findAndHookMethod(
                cryptor,
                "decrypt",
                byte[].class, int.class, int.class, byte[].class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String decrypt_key = Util.hexDump((byte[]) param.args[3]);
                        new MyAsyncTask().execute("Cryptor.decrypt", decrypt_key);
                    }
                });
        XposedHelpers.findAndHookMethod(
                cryptor,
                "encrypt",
                byte[].class, int.class, int.class, byte[].class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String encrypt_key = Util.hexDump((byte[]) param.args[3]);
                        new MyAsyncTask().execute("Cryptor.encrypt", encrypt_key);
                    }
                });
    }
}
