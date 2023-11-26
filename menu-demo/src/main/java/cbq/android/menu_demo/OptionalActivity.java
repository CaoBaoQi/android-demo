package cbq.android.menu_demo;

import android.os.Bundle;
import android.view.*;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * OptionalActivity
 *
 * @author Cola777jz
 * @date 2023/10/31 19:04
 * @since 1.0.0
 */
public class OptionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_optional);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_optional, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.option_style) {
            Toast.makeText(this, "这是字体大小菜单", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_10) {
            Toast.makeText(this, "这是10号字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_20) {
            Toast.makeText(this, "这是20号字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_30) {
            Toast.makeText(this, "这是30号字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_color) {
            Toast.makeText(this, "这是字体颜色菜单", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_red) {
            Toast.makeText(this, "这是红色字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_blue) {
            Toast.makeText(this, "这是蓝色字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_yellow) {
            Toast.makeText(this, "这是黄色字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_gray) {
            Toast.makeText(this, "这是灰色字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_normal) {
            Toast.makeText(this, "OPTIONAL-NORMAL", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
