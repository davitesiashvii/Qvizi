package ge.android.tsu.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ge.android.tsu.project1.data.Storage1;
import ge.android.tsu.project1.data.StorageSharePreferenceImpl;


public class TestsActivity extends AppCompatActivity {
    private int value = 0;
    private String username;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        Intent intent = getIntent();
        if (intent.hasExtra("username")) {
            username = intent.getStringExtra("username");
        }
    }

    public void Addpoint(View view) {
        value++;
    }

    Storage1 storage = new StorageSharePreferenceImpl();

    public void see(View view) {

        String string = String.valueOf(value);
        storage.save(this, username, string);
        Intent intent = new Intent(this, SeeActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("point", string);
        startActivity(intent);
    }
}