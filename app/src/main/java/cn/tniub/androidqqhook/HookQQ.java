package cn.tniub.androidqqhook;

import cn.tniub.androidqqhook.hooks.methods.A1;
import cn.tniub.androidqqhook.hooks.methods.A2;
import cn.tniub.androidqqhook.hooks.methods.A3;
import cn.tniub.androidqqhook.hooks.methods.C;
import cn.tniub.androidqqhook.hooks.methods.CalShareKeyByBouncycastle;
import cn.tniub.androidqqhook.hooks.methods.Cryptor;
import cn.tniub.androidqqhook.hooks.methods.D2Key;
import cn.tniub.androidqqhook.hooks.methods.GenECDHKeyEx;
import cn.tniub.androidqqhook.hooks.methods.GetAndroidId;
import cn.tniub.androidqqhook.hooks.methods.GetBssidAddr;
import cn.tniub.androidqqhook.hooks.methods.GetIMSI;
import cn.tniub.androidqqhook.hooks.methods.GetMacAddr;
import cn.tniub.androidqqhook.hooks.methods.GetQIMEI;
import cn.tniub.androidqqhook.hooks.methods.InitShareKeyByBouncycastle;
import cn.tniub.androidqqhook.hooks.methods.LoginPwd;
import cn.tniub.androidqqhook.hooks.methods.NickName;
import cn.tniub.androidqqhook.hooks.methods.SetPriKey;
import cn.tniub.androidqqhook.hooks.methods.SetPubKey;
import cn.tniub.androidqqhook.hooks.methods.SetShareKey;
import cn.tniub.androidqqhook.hooks.methods.SetSigInfo;
import cn.tniub.androidqqhook.hooks.methods.TGTKey;
import cn.tniub.androidqqhook.hooks.methods.TLV547;
import cn.tniub.androidqqhook.hooks.methods.WloginSigInfo;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookQQ implements IXposedHookLoadPackage {

    private XC_LoadPackage.LoadPackageParam loadPackageParam;

    private boolean isMobileQQ() {
        return loadPackageParam.packageName.equals("com.tencent.mobileqq");
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        this.loadPackageParam = loadPackageParam;
        if (!isMobileQQ()) {
            return;
        }
        XposedBridge.log("com.tencent.mobileqq hooked!");
        new SetPriKey(loadPackageParam).hookMethod();
        new SetPubKey(loadPackageParam).hookMethod();
        new SetShareKey(loadPackageParam).hookMethod();
        new GenECDHKeyEx(loadPackageParam).hookMethod();
        new CalShareKeyByBouncycastle(loadPackageParam).hookMethod();
        new InitShareKeyByBouncycastle(loadPackageParam).hookMethod();

        new GetAndroidId(loadPackageParam).hookMethod();
        new GetMacAddr(loadPackageParam).hookMethod();
        new GetIMSI(loadPackageParam).hookMethod();

        new D2Key(loadPackageParam).hookMethod();
        new A1(loadPackageParam).hookMethod();
        new A2(loadPackageParam).hookMethod();
        new A3(loadPackageParam).hookMethod();
        new GetQIMEI(loadPackageParam).hookMethod();
        new GetBssidAddr(loadPackageParam).hookMethod();

        new TGTKey(loadPackageParam).hookMethod();
        new Cryptor(loadPackageParam).hookMethod();
        new NickName(loadPackageParam).hookMethod();
        new C(loadPackageParam).hookMethod();
        new WloginSigInfo(loadPackageParam).hookMethod();
        new SetSigInfo(loadPackageParam).hookMethod();
        new LoginPwd(loadPackageParam).hookMethod();

    }
}
