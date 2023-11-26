package cbq.android.list_demo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

/**
 * SpinnerActivity
 *
 * @author Cola777jz
 * @date 2023/10/31 16:38
 * @since 1.0.0
 */
public class SpinnerActivity extends AppCompatActivity {
    private String[] boys = {"cbqH", "SongWenJie", "WangWenZhao"};
    private String[] girls = {"cbq", "cbqQ"};
    private Spinner spB;
    private Spinner spG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spB = findViewById(R.id.sp_choice_b);
        spB.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, boys));

        spG = findViewById(R.id.sp_choice_g);
        spG.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, girls));
    }
}
