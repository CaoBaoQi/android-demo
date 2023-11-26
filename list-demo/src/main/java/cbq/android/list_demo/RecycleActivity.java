package cbq.android.list_demo;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import cbq.android.list_demo.adapter.OrderAdapter;
import cbq.android.list_demo.entity.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RecycleActivity
 *
 * @author Cola777jz
 * @date 2023/10/31 16:38
 * @since 1.0.0
 */
public class RecycleActivity extends AppCompatActivity {
    private static final int ORDER_COUNT = 30;
    private List<OrderItem> orderList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        orderList = new ArrayList<>();
        initOrderItemList(orderList);

        ListView listView = findViewById(R.id.listView);

        OrderAdapter adapter = new OrderAdapter(orderList, RecycleActivity.this);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(RecycleActivity.this, "" + orderList.get(position), Toast.LENGTH_SHORT).show());
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(RecycleActivity.this);

            builder
                    .setMessage("确定删除吗？")
                    .setPositiveButton("确定", (dialog, which) -> {
                        orderList.remove(position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("取消", (dialog, which) -> Toast.makeText(RecycleActivity.this, "您取消了删除", Toast.LENGTH_SHORT).show()).create().show();
            return true;
        });
    }

    /**
     * 初始化数据
     * @param orderList orderList
     */
    void initOrderItemList(List<OrderItem> orderList) {
        Random random = new Random();
        for (int i = 0; i < ORDER_COUNT; i++) {
            OrderItem item = new OrderItem(
                    "title_" + random.nextInt(100),
                    random.nextDouble() + random.nextInt(50),
                    random.nextBoolean()
            );
            orderList.add(item);
        }
    }
}
