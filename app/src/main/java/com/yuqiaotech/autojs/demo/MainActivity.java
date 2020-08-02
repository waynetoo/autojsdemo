package com.yuqiaotech.autojs.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.yuqiaotech.autojs.demo.autojs.DemoAutoJs;
import com.yuqiaotech.autojs.demo.launch.GlobalProjectLauncher;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndPermission.with(this)
                .runtime()
                .permission(Permission.Group.STORAGE)
                .onGranted(permissions -> {

                })
                .onDenied(permissions -> {

                })
                .start();
    }

    /**
     * 执行main.js
     *
     * @param view
     */
    public void runJs(View view) {
        new Thread(() -> {
            try {
                GlobalProjectLauncher.INSTANCE.launch(MainActivity.this);
            } catch (Exception e) {
                e.printStackTrace();
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        DemoAutoJs.Companion.getInstance().getGlobalConsole().printAllStackTrace(e);
                    }
                });
            }
        }).start();
    }
}