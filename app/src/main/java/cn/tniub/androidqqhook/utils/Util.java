package cn.tniub.androidqqhook.utils;

import cn.hutool.core.util.HexUtil;

public class Util {

    public static String hexDump(byte[] bytes) {
        return hexDump(HexUtil.encodeHexStr(bytes));
    }

    public static String hexDump(String hexStr) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < hexStr.length(); i++) {
            if (i % 2 == 0) {
                res.append(hexStr, i, i + 2).append(" ");
            }
        }
        return res.toString().trim().toUpperCase();
    }
}
