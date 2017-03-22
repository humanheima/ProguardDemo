package com.hm.proguarddemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hm.proguarddemo.fragment.MyFragment;
import com.hm.proguarddemo.util.NativeUtils;
import com.hm.proguarddemo.util.Utils;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener{

    private String toastTip = "toast in MainActivity";

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, new MyFragment()).commit();
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodWithGlobalVariable();
                methodWithLocalVariable();
                Utils utils = new Utils();
                utils.methodNormal();
                NativeUtils.methodNative();
                NativeUtils.methodNotNative();
                Connector.getDatabase();
            }
        });
    }

    public void methodWithGlobalVariable() {
        Toast.makeText(MainActivity.this, toastTip, Toast.LENGTH_SHORT).show();
    }

    public void methodWithLocalVariable() {
        String logMessage = "log in MainActivity";
        logMessage = logMessage.toLowerCase();
        System.out.println(logMessage);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
