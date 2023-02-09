package com.unity3d.player;

import android.os.Bundle;

public class UnityLauncherActivity extends UnityPlayerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getIntent().getStringExtra("url");
        UnityPlayer.UnitySendMessage("AssetbundleTesting", "StartABTestFromServer", url);
    }
}
