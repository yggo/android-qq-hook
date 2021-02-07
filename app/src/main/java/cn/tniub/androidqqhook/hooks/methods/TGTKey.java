package cn.tniub.androidqqhook.hooks.methods;

import cn.tniub.androidqqhook.MyAsyncTask;
import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class TGTKey extends AbstractHookRequest {

    public TGTKey(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.tlv_type.tlv_t106"),
                "get_tlv_106",
                long.class, long.class, int.class, long.class, byte[].class, byte[].class, int.class,
                byte[].class, long.class, byte[].class, byte[].class, int.class, byte[].class, int.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        /*StringBuilder sb = new StringBuilder();
                        sb.append("arg1=").append(param.args[0].toString()).append("\n");
                        sb.append("arg2=").append(param.args[1].toString()).append("\n");
                        sb.append("arg3=").append(param.args[2].toString()).append("\n");
                        sb.append("arg4=").append(param.args[3].toString()).append("\n");
                        sb.append("arg5=").append(HexUtil.encodeHexStr((byte[]) param.args[4])).append("\n");
                        sb.append("arg6=").append(HexUtil.encodeHexStr((byte[]) param.args[5])).append("\n");
                        sb.append("arg7=").append(param.args[6].toString()).append("\n");
                        sb.append("arg8=").append(HexUtil.encodeHexStr((byte[]) param.args[7])).append("\n");
                        sb.append("arg9=").append(param.args[8].toString()).append("\n");//md5(pass) once
                        sb.append("arg10=").append(HexUtil.encodeHexStr((byte[]) param.args[9])).append("\n");
                        //arg11 tgtkey rand16
                        sb.append("arg11=").append(HexUtil.encodeHexStr((byte[]) param.args[10])).append("\n");
                        sb.append("arg12=").append(param.args[11].toString()).append("\n");
                        sb.append("arg13=").append(HexUtil.encodeHexStr((byte[]) param.args[12])).append("\n");
                        sb.append("arg14=").append(param.args[13].toString()).append("\n");*/
//                        new MyAsyncTask().execute(hexDump(HexUtil.encodeHexStr((byte[]) param.args[10])));
                        String tgtKey = Util.hexDump((byte[]) param.args[10]);
                        new MyAsyncTask().execute("tgtkey", tgtKey);
                    }
                });
    }
}
