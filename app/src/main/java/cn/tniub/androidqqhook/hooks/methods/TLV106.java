package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class TLV106 extends AbstractHookRequest {

    public TLV106(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tlv_type.tlv_t106"),
                "get_tlv_106",
                long.class, long.class, int.class, long.class, byte[].class, byte[].class,
                int.class, byte[].class, long.class, byte[].class, byte[].class,
                int.class, byte[].class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        String arg1 = param.args[0].toString();
                        String arg2 = param.args[1].toString();
                        String arg3 = param.args[2].toString();
                        String arg4 = param.args[3].toString();
                        String arg5 = Util.hexDump((byte[]) param.args[4]);
                        String arg6 = Util.hexDump((byte[]) param.args[5]);
                        String arg7 = param.args[6].toString();
                        String arg8 = Util.hexDump((byte[]) param.args[7]);
                        String arg9 = param.args[8].toString();
                        String arg10 = Util.hexDump((byte[]) param.args[9]);
                        String arg11 = Util.hexDump((byte[]) param.args[10]);
                        String arg12 = param.args[11].toString();
                        String arg13 = Util.hexDump((byte[]) param.args[12]);
                        String arg14 = param.args[13].toString();
                        StringBuilder sb = new StringBuilder();
                        sb.append(arg1).append("\n");
                        sb.append(arg2).append("\n");
                        sb.append(arg3).append("\n");
                        sb.append(arg4).append("\n");
                        sb.append(arg5).append("\n");
                        sb.append(arg6).append("\n");
                        sb.append(arg7).append("\n");
                        sb.append(arg8).append("\n");
                        sb.append(arg9).append("\n");
                        sb.append(arg10).append("\n");
                        sb.append(arg11).append("\n");
                        sb.append(arg12).append("\n");
                        sb.append(arg13).append("\n");
                        sb.append(arg14).append("\n");
                        xpLog(sb.toString());
                    }
                });

        Class<?> WUserSigInfo = XposedHelpers.findClass("oicq.wlogin_sdk.request.WUserSigInfo", loadPackageParam.classLoader);
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.request.k"),
                "a",
                long.class, long.class, long.class, int.class, byte[].class, byte[].class,
                byte[].class, int.class, int.class, long[].class, int.class, long.class, int.class,
                int.class, int.class, int.class, byte[].class, WUserSigInfo,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        String arg5 = Util.hexDump((byte[]) param.args[4]);
                        String arg6 = Util.hexDump((byte[]) param.args[5]);
                        String arg7 = Util.hexDump((byte[]) param.args[6]);
                        String arg10 = Util.hexDump((byte[]) param.args[9]);
                        String arg17 = Util.hexDump((byte[]) param.args[16]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("arg5: ").append(arg5).append("\n");
                        sb.append("arg6: ").append(arg6).append("\n");
                        sb.append("arg7: ").append(arg7).append("\n");
                        sb.append("arg10: ").append(arg10).append("\n");
                        sb.append("arg17: ").append(arg17).append("\n");
                        xpLog(sb.toString());
                    }
                });
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.request.k"),
                "a",
                long.class, long.class, long.class, int.class, byte[].class, byte[].class,
                byte[].class, int.class, int.class, int.class, long[].class, int.class, long.class,
                int.class, int.class, int.class, int.class, byte[].class, WUserSigInfo,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        String arg5 = Util.hexDump((byte[]) param.args[4]);
                        String arg6 = Util.hexDump((byte[]) param.args[5]);
                        String arg7 = Util.hexDump((byte[]) param.args[6]);
                        String arg17 = Util.hexDump((byte[]) param.args[17]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("arg5: ").append(arg5).append("\n");
                        sb.append("arg6: ").append(arg6).append("\n");
                        sb.append("arg7: ").append(arg7).append("\n");
                        sb.append("arg18: ").append(arg17).append("\n");
                        xpLog(sb.toString());
                    }
                });
    }
}
