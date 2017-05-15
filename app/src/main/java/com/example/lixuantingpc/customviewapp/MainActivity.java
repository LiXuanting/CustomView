package com.example.lixuantingpc.customviewapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity implements View.OnClickListener{

    private CustomView mNormal;

    private CustomView mSelectBlue;

    private CustomView mSelectGreen;

    private boolean mClickNormal;

    private boolean mClickSelectBlue;

    private boolean mClickSelectGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNormal = (CustomView)findViewById(R.id.normal);
        mSelectBlue = (CustomView)findViewById(R.id.select_blue);
        mSelectGreen = (CustomView)findViewById(R.id.select_green);
        mNormal.setInfo(this.getResources().getString(R.string.text_normal));
        mSelectBlue.setInfo(this.getResources().getString(R.string.text_select_blue));
        mSelectGreen.setInfo(this.getResources().getString(R.string.text_setlect_green));
        mNormal.setIsSelect(false);
        mSelectBlue.setIsSelect(true);
        mSelectGreen.setIsSelect(true);
        mSelectBlue.setIsBackgroundBlue(true);
        mSelectGreen.setIsBackgroundBlue(false);
        mNormal.setOnClickListener(this);
        mSelectBlue.setOnClickListener(this);
        mSelectGreen.setOnClickListener(this);
        mClickNormal = false;
        mClickSelectBlue = true;
        mClickSelectGreen = true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.normal:
                mNormal.setIsSelect(!mClickNormal);
                mNormal.setIsBackgroundBlue(true);
                mNormal.invalidate();
                mClickNormal = !mClickNormal;
                break;
            case R.id.select_blue:
                mSelectBlue.setIsSelect(!mClickSelectBlue);
                mSelectBlue.invalidate();
                mClickSelectBlue = !mClickSelectBlue;
                break;
            case R.id.select_green:
                mSelectGreen.setIsSelect(!mClickSelectGreen);
                mSelectGreen.invalidate();
                mClickSelectGreen = !mClickSelectGreen;
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
