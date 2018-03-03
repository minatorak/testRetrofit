package com.example.minatorak.testjsonplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edt_number);
        textView = findViewById(R.id.tv_show);
        button = findViewById(R.id.btn_click);

        button.setOnClickListener(v -> {
            String number = editText.getText().toString();
            if (number != null){
                Log.d("number",number);
                new NetworkConnectionManager().connect(callbackListener,number);
            }
        });
    }
    OnNetworkCallbackListener callbackListener = new OnNetworkCallbackListener() {
        @Override
        public void onResponse(Pojo pojo) {
            textView.setText(pojo.getBody());
        }

        @Override
        public void onBodyError(ResponseBody responseBodyError) {

        }

        @Override
        public void onBodyErrorIsNull() {

        }

        @Override
        public void onFailure(Throwable t) {

        }
    };
}
