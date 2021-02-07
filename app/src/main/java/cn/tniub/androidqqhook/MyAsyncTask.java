package cn.tniub.androidqqhook;

import android.os.AsyncTask;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

public class MyAsyncTask extends AsyncTask<String, Void, Void> {

    private static final String HOOK_METHOD_NAME = "methodName";
    private static final String HOOK_METHOD_VALUE = "methodValue";

    private static String httpServerUrl;

    public MyAsyncTask() {
        try {
            httpServerUrl = FileUtil.readString(Constant.PATH_SAVE_HTTP_SERVER_URL + Constant.FILENAME_HTTP_SERVER_URL, CharsetUtil.UTF_8);
        } catch (IORuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Void doInBackground(String... strings) {
        if (strings.length != 2) return null;
        if (httpServerUrl == null || httpServerUrl.equals("")) return null;
        String hookMethodName = strings[0];
        String hookMethodValue = strings[1];

        if (StrUtil.isNotEmpty(hookMethodName) && StrUtil.isNotEmpty(hookMethodValue)) {
            String post_data = String.format("%s=%s&%s=%s", HOOK_METHOD_NAME, hookMethodName,
                    HOOK_METHOD_VALUE, hookMethodValue);
            try {
                HttpUtil.post(httpServerUrl, post_data, 3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
