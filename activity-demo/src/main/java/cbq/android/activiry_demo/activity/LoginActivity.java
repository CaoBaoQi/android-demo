package cbq.android.activiry_demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import cbq.android.activiry_demo.R;

/**
 * LoginActivity
 *
 * @author cbq
 * @date 2023/11/1 16:46
 * @since 1.0.0
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView registerView = findViewById(R.id.login_tx_register);
        EditText userNameEditText = findViewById(R.id.et_user_name);
        Button loginButton = findViewById(R.id.btn_login);

        userNameEditText.setText("鸡你太美");

        registerView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, UserCenterActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("text","你干嘛~哎呦 🐔🐔🐔");
            intent.putExtra("username", userNameEditText.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        });

    }
}
