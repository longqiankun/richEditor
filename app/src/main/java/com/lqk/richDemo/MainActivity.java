package com.lqk.richDemo;

import android.os.Bundle;
import android.os.Environment;

import org.xwalk.core.XWalkActivity;
import org.xwalk.core.XWalkDialogManager;
import org.xwalk.core.XWalkView;

public class MainActivity extends XWalkActivity {
    XWalkView xWalkWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xWalkWebView = (XWalkView) findViewById(R.id.xwalkWebView);

    }

    @Override
    protected void onXWalkFailed() {
        super.onXWalkFailed();
    }

    @Override
    protected XWalkDialogManager getDialogManager() {
        return super.getDialogManager();
    }

    @Override
    public boolean isXWalkReady() {
        return super.isXWalkReady();
    }

    @Override
    public boolean isSharedMode() {
        return super.isSharedMode();
    }

    @Override
    public boolean isDownloadMode() {
        return super.isDownloadMode();
    }

    @Override
    protected void onXWalkReady() {
        xWalkWebView.load("javascript:document.body.contentEditable=true;", null);
String picPath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/a20161028155926421.jpg";
    }
}