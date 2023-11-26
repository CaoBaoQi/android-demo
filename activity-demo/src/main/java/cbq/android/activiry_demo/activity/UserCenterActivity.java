package cbq.android.activiry_demo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import cbq.android.activiry_demo.R;

/**
 * UserCenterActivity
 *
 * @author cbq
 * @date 2023/11/1 16:56
 * @since 1.0.0
 */
public class UserCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);

        Toast.makeText(this, "(Intend)欢迎：" + getIntent().getExtras().getString("username"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "(Bundle)text:" + getIntent().getExtras().getString("text"), Toast.LENGTH_SHORT).show();
        RelativeLayout rlOrder = findViewById(R.id.rl_order);
        RelativeLayout rlAddress = findViewById(R.id.rl_address);
        RelativeLayout rlLogout = findViewById(R.id.rl_logout);

        rlOrder.setOnClickListener(view -> dialog("下一步将查询个人订单"));
        rlAddress.setOnClickListener(view -> dialog("下一步将编辑个人地址"));
        rlLogout.setOnClickListener(view -> dialog("下一步将退出登录"));

    }

    public void login(View view) {
        dialog("下一步将跳转到登陆页面");
    }


    private void dialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage(msg)
                .setPositiveButton("确定", (dialogInterface, i) -> {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                }).create().show();
    }
}
