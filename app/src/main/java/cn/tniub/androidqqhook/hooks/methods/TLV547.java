package cn.tniub.androidqqhook.hooks.methods;

import java.util.Arrays;

import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class TLV547 extends AbstractHookRequest {

    public TLV547(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.request.n"),
                "a",
                byte[].class, byte[].class, byte[].class, int.class, int.class, long[].class, byte[].class,
                new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        byte[] arg9 = (byte[]) param.args[0];
                        byte[] arg10 = (byte[]) param.args[1];
                        byte[] arg11 = (byte[]) param.args[2];
                        int arg12 = (int) param.args[3];
                        int arg13 = (int) param.args[4];
                        long[] arg14 = (long[]) param.args[5];
                        byte[] arg15 = (byte[]) param.args[6];
                        xpLog("arg9=" + Util.hexDump(arg9));
                        xpLog("arg10=" + Util.hexDump(arg10));
                        xpLog("arg11=" + Util.hexDump(arg11));
                        xpLog("arg12=" + arg12);
                        xpLog("arg13=" + arg13);
                        xpLog("arg14=" + Arrays.toString(arg14));
                        xpLog("arg15=" + Util.hexDump(arg15));
                    }

                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        xpLog(Util.hexDump((byte[]) param.getResult()));
                    }
                });

        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.request.oicq_request"),
                "b",
                byte[].class, int.class, int.class,
                new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        byte[] arg5 = (byte[]) param.args[0];
                        int arg6 = (int) param.args[1];
                        int arg7 = (int) param.args[42];
                        xpLog("arg5=" + Util.hexDump(arg5));
                        xpLog("arg6=" + arg6);
                        xpLog("arg7=" + arg7);
                    }

                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        xpLog(Util.hexDump((byte[]) param.getResult()));
                    }
                });
    }
}
