package cbq.android.activiry_demo.activity;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import cbq.android.activiry_demo.R;
import org.jetbrains.annotations.NotNull;

/**
 * RegisterActivity
 *
 * @author cbq
 * @date 2023/11/1 16:46
 * @since 1.0.0
 */
public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiry_register);

        /*
        动态申请权限 （TODO API 30 以上不生效）
         */
/*        ActivityCompat.requestPermissions(RegisterActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE ,
                        Manifest.permission.ACCESS_NOTIFICATION_POLICY},1);*/



        if (!NotificationManagerCompat.from(RegisterActivity.this).areNotificationsEnabled()) {
            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), null));

             startActivity(intent);
        }


        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel("test1", "测试通知", NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);

        Notification notification = new NotificationCompat.Builder(RegisterActivity.this,"test1")
                .setContentTitle("鸡")
                .setContentText("太美丽了")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .build();

        manager.notify(1, notification);
    }

    /**
     * 授权回调
     * @param requestCode The request code passed in {@link #requestPermissions(
     * android.app.Activity, String[], int)}
     * @param permissions The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *     which is either {@link android.content.pm.PackageManager#PERMISSION_GRANTED}
     *     or {@link android.content.pm.PackageManager#PERMISSION_DENIED}. Never null.
     *
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1){
            for (int i = 0; i < permissions.length; i++) {
                if (permissions[i].equals
                        ("android.permission.ACCESS_NOTIFICATION_POLICY") &&
                         grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
