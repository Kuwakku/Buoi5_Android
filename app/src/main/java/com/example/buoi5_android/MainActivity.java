package com.example.buoi5_android;

import static com.example.buoi5_android.PrefManager.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    static boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isLogin = getSharedPreferences("Buoi5_Android", MODE_PRIVATE).getBoolean("IS_LOGIN", false);

//        Log.d("TAG", "onCreate: " + isLogin);
//        SharedPreferences sharedPreferences = this.getSharedPreferences("Buoi5_Android", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean("IS_LOGIN", true);
//        editor.apply(); // 1 luong
//        editor.commit(); // da luong
        PrefManager.saveString(this,"USER_NAME", "Thai");

        UserModel userModel = new UserModel();
        userModel.setUserName("Thai");
        userModel.setAddress("HN");
        userModel.setPassword("123456");

        Gson gson = new Gson();
        String data = gson.toJson(userModel, UserModel.class); // chuyen du lieu ve json

        UserModel userModel1 = gson.fromJson(data, UserModel.class); // chuyen json ve du lieu
        Log.d("TAG", "onCreate: " + userModel1.toString());

        Log.d("TAG", "onCreate: " + PrefManager.getString(this, "USER_NAME"));

    }
}