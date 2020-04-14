package ge.android.tsu.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ge.android.tsu.project1.data.Storage1;
import ge.android.tsu.project1.data.StorageSharePreferenceImpl;

public class SeeActivity extends AppCompatActivity {

    private TextView mUsernameText;
    private String point;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see);
        mUsernameText = findViewById(R.id.username_text);

        Intent intent = getIntent();
        if (intent.hasExtra("point")) {
            point=intent.getStringExtra("point");
        }
        if (intent.hasExtra("username")) {
            mUsernameText.setText(intent.getStringExtra("username")+"  "+point);
        }
    }

    public void logout(View view) {
        Storage1 storage = new StorageSharePreferenceImpl();
        storage.save(this, "logged_user", null);
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
        finish();
    }
}
