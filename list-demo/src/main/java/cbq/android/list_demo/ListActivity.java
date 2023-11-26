package cbq.android.list_demo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cbq.android.list_demo.holder.ListViewHolder;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ListActivity
 *
 * @author Cola777jz
 * @date 2023/10/31 16:37
 * @since 1.0.0
 */
public class ListActivity extends AppCompatActivity {
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

    private String[] depicts = {
            "错愕的抹茶",
            "霍霍的抹茶",
            "画画的抹茶",
            "错愕的抹茶",
            "霍霍的抹茶",
            "画画的抹茶",
            "错愕的抹茶",
            "霍霍的抹茶",
            "画画的抹茶",
            "错愕的抹茶",
            "霍霍的抹茶",
            "画画的抹茶",
            "Mom to Flower"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomBaseAdapter());

        /**
         * 点击
         */
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String text = "名称: " + titles[position] + "\n" + "描述: " + depicts[position];
            Toast.makeText(ListActivity.this, text, Toast.LENGTH_SHORT).show();
        });

        /**
         * 长按
         */
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
            AtomicReference<Boolean> flag = new AtomicReference<>(false);
            builder
                    .setMessage("确定要删除吗？")
                    .setPositiveButton("确定", (dialog, which) -> {
                        Toast.makeText(ListActivity.this, "您点击了 确定", Toast.LENGTH_SHORT).show();
                        flag.set(true);
                        Toast.makeText(ListActivity.this,"FLAG" + flag.get(),Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("取消", (dialog, which) -> {
                        Toast.makeText(ListActivity.this, "您点击了 取消", Toast.LENGTH_SHORT).show();
                        Toast.makeText(ListActivity.this,"FLAG" + flag.get(),Toast.LENGTH_SHORT).show();
                    })
                    .create().show();
            return flag.get();
        });
    }

    /**
     * 自定义 Adapter
     */
    private class CustomBaseAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * 增强 listView （缓冲）
         * @param position The position of the item within the adapter's data set of the item whose view
         *        we want.
         * @param convertView The old view to reuse, if possible. Note: You should check that this view
         *        is non-null and of an appropriate type before using. If it is not possible to convert
         *        this view to display the correct data, this method can create a new view.
         *        Heterogeneous lists can specify their number of view types, so that this View is
         *        always of the right type (see {@link #getViewTypeCount()} and
         *        {@link #getItemViewType(int)}).
         * @param parent The parent that this view will eventually be attached to
         * @return convertView 缓冲对象
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(ListActivity.this, R.layout.list_item, null);
                viewHolder = new ListViewHolder(
                        convertView.findViewById(R.id.tv_title),
                        convertView.findViewById(R.id.tv_depict),
                        convertView.findViewById(R.id.iv)
                );
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ListViewHolder) convertView.getTag();
            }


            viewHolder.getIv().setBackgroundResource(icons[position]);
            viewHolder.getTvTitle().setText(titles[position]);
            viewHolder.getTvDepict().setText(depicts[position]);

            return convertView;
        }
    }
}
