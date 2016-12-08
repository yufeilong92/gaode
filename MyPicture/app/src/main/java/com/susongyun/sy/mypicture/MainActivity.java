package com.susongyun.sy.mypicture;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] items = {"照片", "小视频"};
    private Button btnCamera;
    private Button baidudemo;
    private Button GaodeDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

//        AMapLocationClient.setApiKey("75edb5c5e4787bdf4a0fbac9d1abe635");
    }

    private void ShowDialog() {
        Dialog dialog = new Dialog(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(
                MainActivity.this);

        //items使用全局的finalCharSequenece数组声明

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                String select_item = items[which].toString();
//                Toast.makeText(MainActivity.this,
//                        "选择了---》" + select_item, Toast.LENGTH_SHORT)
//                        .show();

                if (select_item.equals("照片")) {
                    Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                    startActivity(intent);

                } else if (select_item.equals("小视频")) {
                    Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                    startActivity(intent);
                }

            }
        });
        builder.show();
    }

    private void initView() {
        btnCamera = (Button) findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(this);
        baidudemo = (Button) findViewById(R.id.baidudemo);
        baidudemo.setOnClickListener(this);
        GaodeDemo = (Button) findViewById(R.id.GaodeDemo);
        GaodeDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCamera:
                ShowDialog();
                break;
            case R.id.baidudemo:
                break;
            case R.id.GaodeDemo:
               startActivity(new Intent(MainActivity.this,Location_Activity.class));


                break;
        }
    }
}
