package com.licheedev.imequicksetting;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChangeImeActivity extends AppCompatActivity {

    private final AtomicBoolean mShown = new AtomicBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_change_ime);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            if (mShown.get()) {
                finish();
            } else {
                new Handler().postDelayed(this::showInputMethodPicker, 1L);
            }
        }
    }

    public void showInputMethodPicker() {

        InputMethodManager imm =
            (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showInputMethodPicker();

        mShown.set(true);
    }
}