package cn.tniub.androidqqhook.hooks.methods;

import com.alibaba.fastjson.JSON;

import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class ReceiveMessageFromMSF extends AbstractHookRequest {

    public ReceiveMessageFromMSF(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        Class<?> toServiceMsgClass = XposedHelpers.findClass("com.tencent.qphone.base.remote.ToServiceMsg", loadPackageParam.classLoader);
        Class<?> fromServiceMsgClass = XposedHelpers.findClass("com.tencent.qphone.base.remote.FromServiceMsg", loadPackageParam.classLoader);

        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("mqq.app.MainService"),
                "receiveMessageFromMSF",
                toServiceMsgClass, fromServiceMsgClass,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        if (param.args[0] != null) {
                            xpLog(JSON.toJSONString(param.args[0]));
                        }
                        if (param.args[1] != null) {
                            xpLog(JSON.toJSONString(param.args[1]));
                        }
                        //xpLog("to is null: " + (param.args[0] == null) + " fromr is null: " + (param.args[1] == null));
                    }
                });
    }
}
