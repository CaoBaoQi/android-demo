package cbq.android.activiry_demo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cbq.android.activiry_demo.activity.LoginActivity;

/**
 * 启动
 *
 * @author cbq
 * @date 2023/11/1 16:46
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, LoginActivity.class));
    }
}