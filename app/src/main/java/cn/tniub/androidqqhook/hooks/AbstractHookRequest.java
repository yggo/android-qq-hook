package cn.tniub.androidqqhook.hooks;

import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public abstract class AbstractHookRequest {
    protected XC_LoadPackage.LoadPackageParam loadPackageParam;

    public AbstractHookRequest(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        this.loadPackageParam = loadPackageParam;
    }

    protected void xpLog(String text) {
        XposedBridge.log(text);
    }

    protected void xpLog(Throwable t) {
        XposedBridge.log(t);
    }

    abstract public void hookMethod() throws ClassNotFoundException;
}
