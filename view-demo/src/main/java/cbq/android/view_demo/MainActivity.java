package cbq.android.view_demo;

import android.annotation.SuppressLint;
import android.text.Html;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView htmlView = findViewById(R.id.main_text_html);

        htmlView.setText(Html.fromHtml("<h1>这是 H1 标签</h1>", Html.FROM_HTML_MODE_LEGACY));
    }
}