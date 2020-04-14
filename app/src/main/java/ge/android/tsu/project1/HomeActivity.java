package ge.android.tsu.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ge.android.tsu.project1.data.Storage1;
import ge.android.tsu.project1.data.StorageSharePreferenceImpl;

public class HomeActivity extends AppCompatActivity {
    private Button Start1;
    private EditText Username1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Start1 = findViewById(R.id.start);
        Username1 =findViewById(R.id.username);
    }
    public void start_click1(View view){
        String username = Username1.getText().toString().trim();
        if (username.isEmpty()) {
            Toast.makeText(this, "შეიყვანეთ სახელი", Toast.LENGTH_LONG).show();
            return;
        }
        Storage1 storage = new StorageSharePreferenceImpl();
        if (storage.exists(this, username)) {
            Toast.makeText(this, "უკვე არსებობს მომხმარებელი", Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this, "Successfully login", Toast.LENGTH_LONG).show();
        storage.save(this, "logged_user", username);
        Intent intent = new Intent(this, TestsActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
        finish();
    }
}
