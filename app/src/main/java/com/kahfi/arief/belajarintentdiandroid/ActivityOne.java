package com.kahfi.arief.belajarintentdiandroid;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityOne extends AppCompatActivity {

    @BindView(R.id.setComponent)Button setComponent;
    @BindView(R.id.setClass)Button setClass;
    @BindView(R.id.setClassName)Button setClassName;
    @BindView(R.id.actionView)Button actionView;
    @BindView(R.id.actionSend)Button actionSend;
    @BindView(R.id.batterySaver)Button ownAction;
    @BindView(R.id.intentBrowser)Button browser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Log.e("getPackageName()",getPackageName());

        ButterKnife.bind(this);
    }



    //Implicit Intent//
    @OnClick(R.id.actionView)
    public void setActionViewIntent(View v){
       Intent actionViewIntent = new Intent(Intent.ACTION_VIEW);
       startActivity(actionViewIntent);
    }

    @OnClick(R.id.actionSend)
    public void setActionSendIntent(View v){
       Intent actionSendIntent = new Intent(Intent.ACTION_SEND);
       actionSendIntent.setType("text/html");
       startActivity(Intent.createChooser(actionSendIntent,"Click an app to handle this intent"));
    }
    @OnClick(R.id.intentBrowser)
    public void openBrowser(View v){
      Intent browser = new Intent(Intent.ACTION_VIEW);
      browser.setData(Uri.parse("https://developer.android.com"));
      startActivity(Intent.createChooser(browser,"Choose an app"));
    }
    //Implicit Intent//



    //Explicit Intent //
    @OnClick(R.id.batterySaver)
    public void setOwnActionIntent(View v){
        Intent ownActionIntent = new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
        startActivity(ownActionIntent);
    }

    @OnClick(R.id.setComponent)
    public void setComponentOnClick(View v){
        Intent intenComponentClick = new Intent();
        ComponentName compName = new ComponentName(getPackageName(),"com.kahfi.arief.belajarintentdiandroid.ActivityTwo");
        intenComponentClick.putExtra("inten","Ini Object Intent dengan setComponentName()");
        intenComponentClick.setComponent(compName);
        startActivity(intenComponentClick);
    }

    @OnClick(R.id.setClass)
    public void setClassOnClick(View v){
        Intent intenClassClick = new Intent();
        intenClassClick.setClass(this,ActivityTwo.class);
        intenClassClick.putExtra("inten","ini Object Intent dengan setClass()");

        startActivity(intenClassClick);
    }

    @OnClick(R.id.setClassName)
    public void setClassNameOnClick(View v){
        Intent intenClassName = new Intent();

        intenClassName.setClassName(this,"com.kahfi.arief.belajarintentdiandroid.ActivityTwo");
        intenClassName.putExtra("inten","ini Object Intent dengan setClassName()");

        startActivity(intenClassName);
    }
    //Explicit Intent//

}
