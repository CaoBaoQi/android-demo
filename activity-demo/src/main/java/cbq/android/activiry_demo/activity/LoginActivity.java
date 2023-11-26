package cbq.android.activiry_demo.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cbq.android.activiry_demo.R;

/**
 * 登录
 *
 * @author cbq
 * @date 2023/11/1 16:46
 * @since 1.0.0
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(this, "登录 Activity", Toast.LENGTH_SHORT).show();
    }
}
