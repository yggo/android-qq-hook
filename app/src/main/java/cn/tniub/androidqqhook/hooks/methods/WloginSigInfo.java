package cn.tniub.androidqqhook.hooks.methods;

import android.os.Parcel;

import java.util.Objects;

import cn.tniub.androidqqhook.hooks.AbstractHookRequest;
import cn.tniub.androidqqhook.utils.Util;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class WloginSigInfo extends AbstractHookRequest {

    public WloginSigInfo(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        super(loadPackageParam);
    }

    @Override
    public void hookMethod() throws ClassNotFoundException {
        XposedHelpers.findAndHookMethod(
                loadPackageParam.classLoader.loadClass("oicq.wlogin_sdk.sharemem.WloginSigInfo"),
                "readFromParcel",
                Parcel.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        xpLog("===================================");
                        Parcel parcel = (Parcel) param.args[0];
                        String TGT = Util.hexDump(parcel.createByteArray());
                        String TGTKey = Util.hexDump(parcel.createByteArray());
                        String userStSig = Util.hexDump(parcel.createByteArray());
                        String userSt_Key = Util.hexDump(parcel.createByteArray());
                        String userStWebSig = Util.hexDump(parcel.createByteArray());
                        String userA5 = Util.hexDump(parcel.createByteArray());
                        String userA8 = Util.hexDump(parcel.createByteArray());
                        String lsKey = new String(Objects.requireNonNull(parcel.createByteArray()));
                        String sKey = new String(Objects.requireNonNull(parcel.createByteArray()));
                        String userSig64 = Util.hexDump(parcel.createByteArray());
                        String openid = Util.hexDump(parcel.createByteArray());
                        String openkey = Util.hexDump(parcel.createByteArray());
                        String vkey = Util.hexDump(parcel.createByteArray());
                        String en_A1 = Util.hexDump(parcel.createByteArray());
                        String access_token = Util.hexDump(parcel.createByteArray());
                        String D2 = Util.hexDump(parcel.createByteArray());
                        String D2Key = Util.hexDump(parcel.createByteArray());
                        String sid = Util.hexDump(parcel.createByteArray());
                        String noPicSig = Util.hexDump(parcel.createByteArray());
                        String aqSig = Util.hexDump(parcel.createByteArray());
                        String psKey = new String(Objects.requireNonNull(parcel.createByteArray()));
                        String superKey = new String(Objects.requireNonNull(parcel.createByteArray()));
                        String G = Util.hexDump(parcel.createByteArray());
                        String dpwd = Util.hexDump(parcel.createByteArray());
                        String randseed = Util.hexDump(parcel.createByteArray());
                        int login_bitmap = parcel.readInt();
                        long app_pri = parcel.readLong();
                        long A2_expire_time = parcel.readLong();
                        long lsKey_expire_time = parcel.readLong();
                        long sKey_expire_time = parcel.readLong();
                        long vKey_expire_time = parcel.readLong();
                        long userA8_expire_time = parcel.readLong();
                        long userStWebSig_expire_time = parcel.readLong();
                        long D2_expire_time = parcel.readLong();
                        long sid_expire_time = parcel.readLong();
                        long create_time = parcel.readLong();
                        long A2_create_time = parcel.readLong();
                        long userStSig_create_time = parcel.readLong();
                        long userStWebSig_create_time = parcel.readLong();
                        long userA5_create_time = parcel.readLong();
                        long userA8_create_time = parcel.readLong();
                        long lsKey_create_time = parcel.readLong();
                        long sKey_create_time = parcel.readLong();
                        long userSig64_create_time = parcel.readLong();
                        long openkey_create_time = parcel.readLong();
                        long vkey_create_time = parcel.readLong();
                        long access_token_create_time = parcel.readLong();
                        long D2_create_time = parcel.readLong();
                        long sid_create_time = parcel.readLong();
                        long aqSig_create_time = parcel.readLong();
                        long psKey_create_time = parcel.readLong();
                        String pay_token = Util.hexDump(parcel.createByteArray());
                        String pf = Util.hexDump(parcel.createByteArray());
                        String pfKey = Util.hexDump(parcel.createByteArray());
                        String DA2 = Util.hexDump(parcel.createByteArray());
                        String pt4Token = Util.hexDump(parcel.createByteArray());
                        String wtSessionTicket = Util.hexDump(parcel.createByteArray());
                        String wtSessionTicketKey = Util.hexDump(parcel.createByteArray());
                        String device_token = Util.hexDump(parcel.createByteArray());
                        long wtSessionTicketCreatTime = parcel.readLong();
                        StringBuilder sb = new StringBuilder();
                        sb.append(TGT).append("\n");
                        sb.append(TGTKey).append("\n");
                        sb.append(userStSig).append("\n");
                        sb.append(userSt_Key).append("\n");
                        sb.append(userStWebSig).append("\n");
                        sb.append(userA5).append("\n");
                        sb.append(userA8).append("\n");
                        sb.append(lsKey).append("\n");
                        sb.append(sKey).append("\n");
                        sb.append(userSig64).append("\n");
                        sb.append(openid).append("\n");
                        sb.append(openkey).append("\n");
                        sb.append(vkey).append("\n");
                        sb.append(en_A1).append("\n");
                        sb.append(access_token).append("\n");
                        sb.append(D2).append("\n");
                        sb.append(D2Key).append("\n");
                        sb.append(sid).append("\n");
                        sb.append(noPicSig).append("\n");
                        sb.append(aqSig).append("\n");
                        sb.append(psKey).append("\n");
                        sb.append(superKey).append("\n");
                        sb.append(G).append("\n");
                        sb.append(dpwd).append("\n");
                        sb.append(randseed).append("\n");
                        sb.append(login_bitmap).append("\n");
                        sb.append(app_pri).append("\n");
                        sb.append(A2_expire_time).append("\n");
                        sb.append(lsKey_expire_time).append("\n");
                        sb.append(sKey_expire_time).append("\n");
                        sb.append(vKey_expire_time).append("\n");
                        sb.append(userA8_expire_time).append("\n");
                        sb.append(userStWebSig_expire_time).append("\n");
                        sb.append(D2_expire_time).append("\n");
                        sb.append(sid_expire_time).append("\n");
                        sb.append(create_time).append("\n");
                        sb.append(A2_create_time).append("\n");
                        sb.append(userStSig_create_time).append("\n");
                        sb.append(userStWebSig_create_time).append("\n");
                        sb.append(userA5_create_time).append("\n");
                        sb.append(userA8_create_time).append("\n");
                        sb.append(lsKey_create_time).append("\n");
                        sb.append(sKey_create_time).append("\n");
                        sb.append(userSig64_create_time).append("\n");
                        sb.append(openkey_create_time).append("\n");
                        sb.append(vkey_create_time).append("\n");
                        sb.append(access_token_create_time).append("\n");
                        sb.append(D2_create_time).append("\n");
                        sb.append(sid_create_time).append("\n");
                        sb.append(aqSig_create_time).append("\n");
                        sb.append(psKey_create_time).append("\n");
                        sb.append(pay_token).append("\n");
                        sb.append(pf).append("\n");
                        sb.append(pfKey).append("\n");
                        sb.append(DA2).append("\n");
                        sb.append(pt4Token).append("\n");
                        sb.append(wtSessionTicket).append("\n");
                        sb.append(wtSessionTicketKey).append("\n");
                        sb.append(device_token).append("\n");
                        sb.append(wtSessionTicketCreatTime).append("\n");
                        xpLog(sb.toString());
                    }
                });
    }
}
