package cn.tniub.androidqqhook;

import android.os.Environment;

import java.io.File;

class Constant {

    static final String FILENAME_HTTP_SERVER_URL = "http_server_url.txt";
    static final String PATH_SAVE_HTTP_SERVER_URL = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "config/";
}
