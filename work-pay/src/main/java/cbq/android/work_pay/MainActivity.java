package cbq.android.work_pay;

import android.app.AlertDialog;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = findViewById(R.id.btn_submit);


        submit.setOnClickListener(v -> {
            AlertDialog.Builder payBbuilder = new AlertDialog.Builder(MainActivity.this);

            TextView textV = findViewById(R.id.tv_sum);
            textV.setText("需付款？ 100 元");

            payBbuilder
                    .setTitle("Ask")
                    .setIcon(R.drawable.manner)
                    .setMessage("是否支付")
                    .setPositiveButton("确认支付", (dialog, which) -> {
                        AlertDialog.Builder sucbuilder = new AlertDialog.Builder(MainActivity.this);
                        sucbuilder
                                .setTitle("恭喜您支付成功")
                                .setPositiveButton("确定", (dialog1, which1) -> {
                                    Toast.makeText(MainActivity.this, "欢迎下次光临", Toast.LENGTH_SHORT).show();
                                })
                                .create().show();
                    })
                    .setNegativeButton("取消支付", (dialog, which) -> Toast.makeText(MainActivity.this, "您取消了支付", Toast.LENGTH_SHORT).show())
                    .create().show();
        });
    }
}