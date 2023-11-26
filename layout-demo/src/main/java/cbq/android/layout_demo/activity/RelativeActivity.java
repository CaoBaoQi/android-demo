package cbq.android.layout_demo.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cbq.android.layout_demo.R;

/**
 * 相对布局
 *
 * @author cbq
 * @date 2023/10/31 14:20
 * @since 1.0.0
 */
public class RelativeActivity extends AppCompatActivity {
    /**
     * 更新按钮
     */
    private Button bt_update;
    /**
     * 取消更新按钮
     */
    private Button bt_no_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);


        bt_update = findViewById(R.id.bt_update);
        bt_no_update = findViewById(R.id.bt_no_update);

        bt_update.setOnClickListener(v -> Toast.makeText(this, "更新", Toast.LENGTH_SHORT).show());
        bt_no_update.setOnClickListener(v -> Toast.makeText(this, "取消更新", Toast.LENGTH_SHORT).show());
    }
}
