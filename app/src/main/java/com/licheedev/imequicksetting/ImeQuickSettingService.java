package com.licheedev.imequicksetting;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.view.inputmethod.InputMethodManager;

public class ImeQuickSettingService extends TileService {

    private static final String TAG = "ImeQuickSettingService";

    @Override
    public void onTileAdded() {
        //LogPlus.d(TAG, "onTileAdded");
        getQsTile().setState(Tile.STATE_INACTIVE);
    }

    @Override
    public void onTileRemoved() {
        //LogPlus.d(TAG, "onTileRemoved");
    }

    @Override
    public void onClick() {
        //LogPlus.d(TAG, "onClick");

        // 锁屏状态不处理
        if (isLocked()) {
            return;
        }

        // 隐藏下拉通知
        Intent it = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        sendBroadcast(it);
        // 弹出切换输入法对话框
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q && checkPermission()) {
            // 需要 android.permission.WRITE_SECURE_SETTINGS 权限
            showInputMethodPicker();
        } else {
            Intent intent = new Intent(this, ChangeImeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    }

    private void showInputMethodPicker() {
        InputMethodManager imm =
            (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showInputMethodPicker();
    }

    private boolean checkPermission() {
        PackageManager pm = getPackageManager();
        return pm.checkPermission("android.permission.WRITE_SECURE_SETTINGS", getPackageName())
            == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onStartListening() {
        //LogPlus.d(TAG, "onStartListening");
    }

    @Override
    public void onStopListening() {
        //LogPlus.d(TAG, "onStopListening");
    }
}