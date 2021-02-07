package cn.tniub.androidqqhook;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.CharsetUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_test;
    private Button btn_save;
    private EditText et_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        loadConfig();
        setListener();
    }

    private void findView() {
        btn_test = findViewById(R.id.btn_test);
        btn_save = findViewById(R.id.btn_save);
        et_url = findViewById(R.id.et_url);
    }

    private void loadConfig() {
        try {
            String http_server_url = FileUtil.readString(Constant.PATH_SAVE_HTTP_SERVER_URL + Constant.FILENAME_HTTP_SERVER_URL, CharsetUtil.UTF_8);
            et_url.setText(http_server_url);
        } catch (IORuntimeException e) {
            e.printStackTrace();
        }
    }

    private void setListener() {
        btn_test.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                doTest();
                break;
            case R.id.btn_save:
                doSave();
                loadConfig();
                break;
            default:
                break;
        }
    }

    private void doTest() {
        new MyAsyncTask().execute("test", "test rand " + new Random().nextInt(Integer.MAX_VALUE));
    }

    private void doSave() {
        try {
            FileUtil.writeString(et_url.getText().toString(), Constant.PATH_SAVE_HTTP_SERVER_URL + Constant.FILENAME_HTTP_SERVER_URL, CharsetUtil.UTF_8);
        } catch (IORuntimeException e) {
            e.printStackTrace();
        }
    }
}
