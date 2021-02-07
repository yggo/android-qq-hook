package cn.tniub.androidqqhook.hooks.methods;

import java.lang.reflect.Field;

import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class AsyncContext extends AbstractHookRequest {

    public AsyncContext(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.request.t"),
                "b",
                long.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        Class<?> aClass = param.getResult().getClass();
                        Field[] declaredFields = aClass.getDeclaredFields();
                        for (Field declaredField : declaredFields) {
                            declaredField.setAccessible(true);
                            if (declaredField.getName().equals("_tmp_pwd")) {
                                //md5(pass) once
                                xpLog("_tmp_pwd " + Util.hexDump((byte[]) declaredField.get(param.getResult())));
                            }
                            if (declaredField.getName().equals("_mpasswd")) {
//                                xpLog("_mpasswd " + declaredField.get(param.getResult()));
                                xpLog("_mpasswd is empty ? " + declaredField.get(param.getResult()).equals(""));
                            }
                        }
                    }
                });
        Class<?> WUserSigInfo = XposedHelpers.findClass("oicq.wlogin_sdk.request.WUserSigInfo", loadPackageParam.classLoader);
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.request.WtloginHelper"),
                "GetStWithPasswd",
                String.class, long.class, int.class, long.class, long[].class, boolean.class, String.class,
                WUserSigInfo, byte[][].class, boolean.class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        xpLog("GetStWithPasswd arg1: " + param.args[0]);
                        xpLog("GetStWithPasswd arg6: " + param.args[6] + " , " + Util.hexDump(param.args[6].toString().getBytes()));
                        xpLog("GetStWithPasswd isSmsLogin: " + param.args[9]);
                    }
                });
    }
}
