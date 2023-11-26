package cbq.android.work_loginv2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = findViewById(R.id.iv_head);

        button.setOnClickListener(v -> Toast.makeText(MainActivity.this,"您点击了登陆图标",Toast.LENGTH_SHORT).show());
    }
}