package org.keetech.a190201_implicit_intent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Implicit example");

        Button btnDial = findViewById(R.id.btnDial);
        Button btnWeb = findViewById(R.id.btnWeb);
        Button btnGoogle = findViewById(R.id.btnGoogle);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnSms = findViewById(R.id.btnSms);
        Button btnPhoto = findViewById(R.id.btnPhoto);
        Log.i("text","연결 완료");

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:010-1234-5678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                Log.i("text","다이얼 완료");
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.hanb.co.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                Log.i("text","웹 완료");
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:37.5543,126.9135");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                Log.i("text","구글완료");
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,"android");
                startActivity(intent);
                Log.i("text","안드로이드 완료");
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("sms_body", "hi?");
                intent.setType("vnd.android-dir/mms/sms");
                startActivity(intent);
            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.fromFile(new File("/sdcard/jeju13.jpg"));
                intent.setDataAndType(uri, "image/jpeg");
                startActivity(intent);
            }
        });
    }
}
