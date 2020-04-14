package ge.android.tsu.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import ge.android.tsu.project1.data.Storage1;
import ge.android.tsu.project1.data.StorageSharePreferenceImpl;

public class LaunchActivity extends Activity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Storage1 storage1 = new StorageSharePreferenceImpl();
        if (storage1.exists(this, "logged_user")) {
            Intent intent = new Intent(this, SeeActivity.class);
            intent.putExtra("username", storage1.get(this, "logged_user"));
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        finish();
    }
}
