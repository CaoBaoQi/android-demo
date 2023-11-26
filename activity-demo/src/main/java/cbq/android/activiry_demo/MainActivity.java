package cbq.android.activiry_demo;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cbq.android.activiry_demo.activity.LoginActivity;
import cbq.android.activiry_demo.activity.RegisterActivity;
import cbq.android.activiry_demo.activity.UserCenterActivity;

/**
 * 启动
 *
 * @author cbq
 * @date 2023/11/1 16:46
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * 登录
     */
    private Button btn_login;
    /**
     * 注册
     */
    private Button btn_register;
    /**
     * 用户中心
     */
    private Button btn_user_center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_user_center = findViewById(R.id.btn_user_center);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_user_center.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_login) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.btn_register) {
            startActivity(new Intent(this, RegisterActivity.class));
        } else if (id == R.id.btn_user_center) {
            startActivity(new Intent(this, UserCenterActivity.class));
        }
    }
}