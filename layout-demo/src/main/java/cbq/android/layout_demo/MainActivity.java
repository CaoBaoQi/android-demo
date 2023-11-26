package cbq.android.layout_demo;

import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cbq.android.layout_demo.activity.FrameActivity;
import cbq.android.layout_demo.activity.GridActivity;
import cbq.android.layout_demo.activity.LinerActivity;
import cbq.android.layout_demo.activity.RelativeActivity;
import cbq.android.layout_demo.activity.TableActivity;

/**
 * 启动
 *
 * @author cbq
 * @date 2023/10/31 14:19
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity {
    /**
     * 线性布局
     */
    private Button liner_btn;
    /**
     * 表格布局
     */
    private Button table_btn;
    /**
     * 网格布局
     */
    private Button grid_btn;
    /**
     * 相对布局
     */
    private Button relative_btn;
    /**
     * 帧布局
     */
    private Button frame_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liner_btn = findViewById(R.id.main_btn_liner);
        table_btn = findViewById(R.id.main_btn_table);
        grid_btn = findViewById(R.id.main_btn_grid);
        relative_btn = findViewById(R.id.main_btn_relative);
        frame_btn = findViewById(R.id.main_btn_frame);

        liner_btn.setOnClickListener(v -> startActivity(new Intent(this, LinerActivity.class)));
        table_btn.setOnClickListener(v -> startActivity(new Intent(this, TableActivity.class)));
        grid_btn.setOnClickListener(v -> startActivity(new Intent(this, GridActivity.class)));
        relative_btn.setOnClickListener(v -> startActivity(new Intent(this, RelativeActivity.class)));
        frame_btn.setOnClickListener(v -> startActivity(new Intent(this, FrameActivity.class)));
    }
}