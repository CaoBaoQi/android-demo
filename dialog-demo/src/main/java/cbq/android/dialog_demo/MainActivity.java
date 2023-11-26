package cbq.android.dialog_demo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * 启动
 *
 * @author cbq
 * @date 2023/10/31 14:19
 * @since 1.0.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 普通对话框
     */
    private Button commonDialog;
    /**
     * 单选对话框
     */
    private Button singleDialog;
    /**
     * 多选对话框
     */
    private Button multipleDialog;
    /**
     * 不带进度条的对话框
     */
    private Button simpleProcessDialog;
    /**
     * 带进度条的对话框
     */
    private Button processDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commonDialog = findViewById(R.id.btn_common_dialog);
        singleDialog = findViewById(R.id.btn_single_dialog);
        multipleDialog = findViewById(R.id.btn_multiple_dialog);
        simpleProcessDialog = findViewById(R.id.btn_simple_process_dialog);
        processDialog = findViewById(R.id.btn_process_dialog);

        showCommonDialog(commonDialog);
        showSingleDialog(singleDialog);
        showMultipleDialog(multipleDialog);
        showSimpleProcessDialog(simpleProcessDialog);
        showProcessDialog(processDialog);
    }

    /**
     * 普通对话框
     *
     * @param button commonDialog
     */
    public void showCommonDialog(Button button) {
        button.setOnClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setTitle("commonDialog")
                    .setIcon(R.drawable.ic_launcher_background)
                    .setMessage("恭喜您支付成功")
                    .setNegativeButton("取消", (dialog, which) -> Toast.makeText(MainActivity.this, "您单击了取消按钮", Toast.LENGTH_SHORT).show())
                    .setPositiveButton("确定", (dialog, which) -> Toast.makeText(MainActivity.this, "您单击了确定按钮", Toast.LENGTH_SHORT).show()).create().show();
        });
    }

    /**
     * 单选对话框
     *
     * @param button singleDialog
     */
    public void showSingleDialog(Button button) {
        String[] items = {"男", "女"};
        boolean[] checkedItems = {true, false};

        button.setOnClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setTitle("单选对话框")
                    .setSingleChoiceItems(items, 0, (dialog, which) -> {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                        }
                        checkedItems[which] = true;
                    })
                    .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                    .setPositiveButton("确定", (dialog, which) -> {
                        String str = "";
                        for (int i = 0; i < checkedItems.length; i++) {
                            if (checkedItems[i]) {
                                str = items[i];
                            }
                        }
                        Toast.makeText(MainActivity.this, "您选择了" + str, Toast.LENGTH_SHORT).show();
                    }).create().show();
        });
    }

    /**
     * 多选对话框
     *
     * @param button multipleDialog
     */
    public void showMultipleDialog(Button button) {
        String[] items = {"数学", "语文", "英语", "政治"};
        boolean[] checkedItems = {false, true, false, false};

        button.setOnClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setTitle("多选对话框")
                    .setMultiChoiceItems(items, checkedItems, (dialog, which, isChecked) -> {
                        if (isChecked) {
                            checkedItems[which] = true;
                        } else {
                            checkedItems[which] = false;
                            Toast.makeText(MainActivity.this, "您取消了" + items[which], Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("取消", (dialog, which) -> dialog.dismiss())
                    .setPositiveButton("确定", (dialog, which) -> {
                        StringBuilder str = new StringBuilder();
                        for (int i = 0; i < checkedItems.length; i++) {
                            if (checkedItems[i]) {
                                str.append(items[i]);
                            }
                        }
                        Toast.makeText(MainActivity.this, "您选择了" + str, Toast.LENGTH_SHORT).show();
                    }).create().show();
        });
    }

    /**
     * 不带进度条的对话框
     *
     * @param button simpleProcessDialog
     */
    public void showSimpleProcessDialog(Button button) {
        button.setOnClickListener(v -> {
            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("不带进度条的对话框");
            progressDialog.setMessage("正在加载");
            progressDialog.show();
        });

    }

    /**
     * 带进度条的对话框
     *
     * @param button processDialog
     */
    public void showProcessDialog(Button button) {
        button.setOnClickListener(v -> {
            ProgressDialog dialog = new ProgressDialog(MainActivity.this);

            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setTitle("带进度条的对话框");
            dialog.setMessage("正在加载");
            dialog.setMax(200);
            dialog.show();
            new Thread(() -> {
                for (int i = 0; i <= 200; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    dialog.setProgress(i);
                }
            }).start();
        });
    }
}