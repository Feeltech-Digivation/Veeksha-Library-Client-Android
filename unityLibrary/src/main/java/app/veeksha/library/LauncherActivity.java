package app.veeksha.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class LauncherActivity extends UnityPlayerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String token = getIntent().getStringExtra("token");
        if (token == null) {
            finish();

        } else
            UnityPlayer.UnitySendMessage("ClientLibraryBehaviourController", "LoadContent", token);
    }

    public static void launch(Context packageContext, String authToken) {
        if (authToken == null || packageContext ==null){
            throw new NullPointerException("authToken or context is Null");
        }
        Intent intent = new Intent(packageContext, LauncherActivity.class);
        intent.putExtra("token", authToken);
        packageContext.startActivity(intent);
    }
}
