package com.zhuelise.lab05androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int lifetimeOnCreate, lifetimeOnPause, lifetimeOnStop, lifetimeOnDestroy, lifetimeOnStart, lifetimeOnResume, lifetimeOnRestart = 0;
    int thisRunOnCreate, thisRunOnStart, thisRunOnResume, thisRunOnPause, thisRunOnStop, thisRunOnRestart, thisRunOnDestroy = 0;
    TextView lOnCreate, lOnStart, lOnResume, lOnPause, lOnStop, lOnRestart, lOnDestroy, tOnCreate, tOnStart, tOnResume, tOnPause, tOnStop, tOnRestart, tOnDestroy;
    Button lifetimeRestart, thisRunRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lOnCreate = findViewById(R.id.lifetime_oncreate);
        lOnStart = findViewById(R.id.lifetime_onstart);
        lOnResume = findViewById(R.id.lifetime_onresume);
        lOnPause = findViewById(R.id.lifetime_onpause);
        lOnStop = findViewById(R.id.lifetime_onstop);
        lOnRestart = findViewById(R.id.lifetime_onrestart);
        lOnDestroy = findViewById(R.id.lifetime_ondestroy);
        tOnCreate = findViewById(R.id.this_run_oncreate);
        tOnStart = findViewById(R.id.this_run_onstart);
        tOnResume = findViewById(R.id.this_run_onresume);
        tOnPause = findViewById(R.id.this_run_onpause);
        tOnStop = findViewById(R.id.this_run_onstop);
        tOnRestart = findViewById(R.id.this_run_onrestart);
        tOnDestroy = findViewById(R.id.this_run_ondestroy);
        lifetimeRestart = findViewById(R.id.lifetime_reset);
        thisRunRestart = findViewById(R.id.this_run_reset);
        preferences = getSharedPreferences("com.zhuelise.lab05.androidlifecycle", Context.MODE_PRIVATE);
        editor = preferences.edit();

        setInitialValues();
        lifetimeOnCreate++;
        thisRunOnCreate++;
        lOnCreate.setText(getString(R.string.lifetime_on_create, lifetimeOnCreate));
        tOnCreate.setText(getString(R.string.this_run_on_create, thisRunOnCreate));
    }

    @Override
    protected void onStart(){
        super.onStart();
        lifetimeOnStart++;
        thisRunOnStart++;
        lOnStart.setText(getString(R.string.lifetime_on_start, lifetimeOnStart));
        tOnStart.setText(getString(R.string.this_run_on_start, thisRunOnStart));
    }

    @Override
    protected void onResume(){
        super.onResume();
        lifetimeOnResume++;
        thisRunOnResume++;
        lOnResume.setText(getString(R.string.lifetime_on_resume, lifetimeOnResume));
        tOnResume.setText(getString(R.string.this_run_on_resume, thisRunOnResume));
        }

    @Override
    protected void onPause() {
        super.onPause();
        lifetimeOnPause++;
        thisRunOnPause++;
        lOnPause.setText(getString(R.string.lifetime_on_pause, lifetimeOnPause));
        tOnPause.setText(getString(R.string.this_run_on_pause, thisRunOnPause));
        editor.putInt("lifetimeOnCreate", lifetimeOnCreate);
        editor.putInt("lifetimeOnStart", lifetimeOnStart);
        editor.putInt("lifetimeOnResume", lifetimeOnResume);
        editor.putInt("lifetimeOnPause", lifetimeOnPause);
        editor.putInt("lifetimeOnStop", lifetimeOnStop);
        editor.putInt("lifetimeOnRestart", lifetimeOnRestart);
        editor.putInt("lifetimeOnDestroy", lifetimeOnDestroy);
        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifetimeOnStop++;
        thisRunOnStop++;
        lOnStop.setText(getString(R.string.lifetime_on_stop, lifetimeOnStop));
        tOnStop.setText(getString(R.string.this_run_on_stop, thisRunOnStop));
        editor.putInt("lifetimeOnCreate", lifetimeOnCreate);
        editor.putInt("lifetimeOnStart", lifetimeOnStart);
        editor.putInt("lifetimeOnResume", lifetimeOnResume);
        editor.putInt("lifetimeOnPause", lifetimeOnPause);
        editor.putInt("lifetimeOnStop", lifetimeOnStop);
        editor.putInt("lifetimeOnRestart", lifetimeOnRestart);
        editor.putInt("lifetimeOnDestroy", lifetimeOnDestroy);
        editor.apply();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //setInitialValues();
        lifetimeOnRestart++;
        thisRunOnRestart++;
        lOnRestart.setText(getString(R.string.lifetime_on_restart, lifetimeOnRestart));
        tOnRestart.setText(getString(R.string.this_run_on_restart, thisRunOnRestart));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifetimeOnDestroy++;
        thisRunOnDestroy++;
        lOnDestroy.setText(getString(R.string.lifetime_on_destroy, lifetimeOnDestroy));
        tOnDestroy.setText(getString(R.string.this_run_on_destroy, thisRunOnDestroy));
        editor.putInt("lifetimeOnCreate", lifetimeOnCreate);
        editor.putInt("lifetimeOnStart", lifetimeOnStart);
        editor.putInt("lifetimeOnResume", lifetimeOnResume);
        editor.putInt("lifetimeOnPause", lifetimeOnPause);
        editor.putInt("lifetimeOnStop", lifetimeOnStop);
        editor.putInt("lifetimeOnRestart", lifetimeOnRestart);
        editor.putInt("lifetimeOnDestroy", lifetimeOnDestroy);
        editor.apply();
    }

    private void setInitialValues() {
        lOnCreate.setText(getString(R.string.lifetime_on_create, preferences.getInt("lifetimeOnCreate", 0)).toString());
        lOnStart.setText(getString(R.string.lifetime_on_start, preferences.getInt("lifetimeOnStart", 0)).toString());
        lOnResume.setText(getString(R.string.lifetime_on_resume, preferences.getInt("lifetimeOnResume", 0)).toString());
        lOnPause.setText(getString(R.string.lifetime_on_pause, preferences.getInt("lifetimeOnPause", 0)).toString());
        lOnStop.setText(getString(R.string.lifetime_on_stop, preferences.getInt("lifetimeOnStop", 0)).toString());
        lOnRestart.setText(getString(R.string.lifetime_on_restart, preferences.getInt("lifetimeOnRestart", 0)).toString());
        lOnDestroy.setText(getString(R.string.lifetime_on_destroy, preferences.getInt("lifetimeOnDestroy", 0)).toString());
    }

    public void LifetimeReset(View view) {
        lifetimeOnStart = 0;
        lifetimeOnCreate = 0;
        lifetimeOnRestart = 0;
        lifetimeOnResume = 0;
        lifetimeOnPause = 0;
        lifetimeOnDestroy = 0;
        lifetimeOnStop = 0;
        editor.clear();
        editor.apply();
        setInitialValues();
    }

    public void ThisRunReset(View view) {
        thisRunOnStart = 0;
        thisRunOnCreate = 0;
        thisRunOnRestart = 0;
        thisRunOnResume = 0;
        thisRunOnPause = 0;
        thisRunOnDestroy = 0;
        thisRunOnStop = 0;
        tOnCreate.setText(getString(R.string.this_run_on_create, 0));
        tOnStart.setText(getString(R.string.this_run_on_start, 0));
        tOnResume.setText(getString(R.string.this_run_on_resume, 0));
        tOnPause.setText(getString(R.string.this_run_on_pause, 0));
        tOnStop.setText(getString(R.string.this_run_on_stop, 0));
        tOnRestart.setText(getString(R.string.this_run_on_restart, 0));
        tOnDestroy.setText(getString(R.string.this_run_on_destroy, 0));
    }
}