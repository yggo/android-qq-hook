package cn.tniub.androidqqhook.hooks.methods;

import android.content.Context;

import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class TLV544 extends AbstractHookRequest {

    public TLV544(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tlv_type.tlv_t544"),
                "get_tlv_544",
                Context.class, long.class, int.class, byte[].class, int.class, String.class, int.class,
                new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        xpLog("beforeHookedMethod");
                    }

                    @Override
                    protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        xpLog("afterHookedMethod");
                        xpLog(Util.hexDump((byte[]) param.getResult()));
                    }
                });
    }
}
