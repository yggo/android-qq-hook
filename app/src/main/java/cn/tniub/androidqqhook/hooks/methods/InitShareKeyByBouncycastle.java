package cn.tniub.androidqqhook.hooks.methods;

import java.lang.reflect.Field;
import java.security.PrivateKey;
import java.security.PublicKey;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class InitShareKeyByBouncycastle extends AbstractHookRequest {

    private Class<?> EcdhCrypt;

    public InitShareKeyByBouncycastle(XC_LoadPackage.LoadPackageParam loadPackageParam) throws ClassNotFoundException {
        super(loadPackageParam);
        EcdhCrypt = loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tools.EcdhCrypt");
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(EcdhCrypt, "initShareKeyByBouncycastle",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        Class<?> clazz = param.thisObject.getClass();

                        Field _c_pub_key = clazz.getDeclaredField("_c_pub_key");
                        byte[] pub_key = (byte[]) _c_pub_key.get(param.thisObject);

                        Field _g_share_key = clazz.getDeclaredField("_g_share_key");
                        _g_share_key.setAccessible(true);
                        byte[] share_key = (byte[]) _g_share_key.get(param.thisObject);

                        Field x509PublicKey = clazz.getDeclaredField("x509PublicKey");
                        PublicKey _x509PublicKey = (PublicKey) x509PublicKey.get(param.thisObject);

                        Field pkcs8PrivateKey = clazz.getDeclaredField("pkcs8PrivateKey");
                        PrivateKey _pkcs8PrivateKey = (PrivateKey) pkcs8PrivateKey.get(param.thisObject);

                        new MyAsyncTask().execute("InitShareKeyByBouncycastle",
                                String.format("pub_key=%s, share_key=%s, x509PublicKey=%s, pkcs8PrivateKey=%s",
                                        Util.hexDump(pub_key), Util.hexDump(share_key),
                                        Util.hexDump(_x509PublicKey.getEncoded()),
                                        Util.hexDump(_pkcs8PrivateKey.getEncoded()
                                        )
                                )
                        );
                    }
                });
    }
}
