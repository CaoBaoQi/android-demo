package cbq.android.menu_demo;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button optional_bth = findViewById(R.id.main_btn_optional);
        Button context_bth = findViewById(R.id.main_btn_context);
        Button popup_bth = findViewById(R.id.main_btn_popup);

        optional_bth.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, OptionalActivity.class);
            startActivity(intent);
        });
        context_bth.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContextActivity.class);
            startActivity(intent);
        });
        popup_bth.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PopupActivity.class);
            startActivity(intent);
        });
    }


}