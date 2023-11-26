package cbq.android.list_demo;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GridActivity
 *
 * @author Cola777jz
 * @date 2023/10/31 16:37
 * @since 1.0.0
 */
public class GridActivity extends AppCompatActivity {
    private GridView gridView;
    private List<Map<String, Object>> datas = new ArrayList<>();
    private int[] icons = {
            R.drawable.mcdd_01,
            R.drawable.mcdd_02,
            R.drawable.mcdd_03,
            R.drawable.mcdd_01,
            R.drawable.mcdd_02,
            R.drawable.mcdd_03,
            R.drawable.mcdd_01,
            R.drawable.mcdd_02,
            R.drawable.mcdd_03,
            R.drawable.mcdd_01,
            R.drawable.mcdd_02,
            R.drawable.mcdd_03,
            R.drawable.mcdd_04
    };

    private String[] titles = {
            "错愕",
            "霍霍",
            "画画",
            "错愕",
            "霍霍",
            "画画",
            "错愕",
            "霍霍",
            "画画",
            "错愕",
            "霍霍",
            "画画",
            "送花"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initData();
        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(new SimpleAdapter(GridActivity.this,datas,R.layout.grid_item,new String[]{"icons","titles"},new int[]{R.id.iv,R.id.tv_title}));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            String text = "名称: " + titles[position];
            Toast.makeText(GridActivity.this, text, Toast.LENGTH_SHORT).show();
        });
    }
    void initData(){
        for (int i = 0; i < icons.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("icons", icons[i]);
            item.put("titles", titles[i]);
            datas.add(item);

        }
    }
}
