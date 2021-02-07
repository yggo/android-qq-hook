package cn.tniub.androidqqhook.hooks.methods;

import com.alibaba.fastjson.JSONObject;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class GenECDHKeyEx extends AbstractHookRequest {

    private final Class<?> EcdhCrypt;

    public GenECDHKeyEx(XC_LoadPackage.LoadPackageParam loadPackageParam) throws ClassNotFoundException {
        super(loadPackageParam);
        EcdhCrypt = loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.EcdhCrypt");
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(EcdhCrypt, "GenECDHKeyEx",
                String.class, String.class, String.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        String s_pub_key = param.args[0].toString();
                        String arg2 = param.args[1].toString();
                        String arg3 = param.args[2].toString();
                        new MyAsyncTask().execute("GenECDHKeyEx", JSONObject.toJSONString(param.args));
                    }
                });
    }
}
