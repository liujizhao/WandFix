package com.example.miqt.dexmvppdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.motorlib.AppParsenter;
import com.miqt.wand.ClassInstall;
import com.miqt.wand.Wand;
import com.miqt.wand.anno.InjectObject;
import com.miqt.wand.anno.ParentalEntrustmentLevel;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Wand.MotorListener {

    @InjectObject(
            value = "com.example.motordex.AppParsenterImpl",
            level = ParentalEntrustmentLevel.NEVER)
    AppParsenter ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Wand.get().init(this).listener(this);
    }

    public void getStr(View view) {
        ClassInstall.inject(this);
        String str = ap.getStr();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void fix(View view) {
        Wand.get().attachPackUrl("https://github.com/miqt/WandFix/raw/master/hotfix_pack.dex");
    }

    @Override
    public void initFnish() {

    }

    @Override
    public void initError(Throwable throwable) {

    }

    @Override
    public void onNewPackAttach(File file) {
        Toast.makeText(this, "一个新的修复包被应用！", Toast.LENGTH_SHORT).show();
    }
}
