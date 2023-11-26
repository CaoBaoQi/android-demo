package cbq.android.menu_demo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import cbq.android.menu_demo.holder.ListViewHolder;

/**
 * ContextActivity
 *
 * @author Cola777jz
 * @date 2023/10/31 19:04
 * @since 1.0.0
 */
public class ContextActivity extends AppCompatActivity {

    private final String[] titles = {
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

    private final String[] depicts = {
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
        setContentView(R.layout.activity_menu_context);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomBaseAdapter());

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String text = "名称: " + titles[position] + "\n" + "描述: " + depicts[position];
            Toast.makeText(ContextActivity.this, text, Toast.LENGTH_SHORT).show();
        });

        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int position = menuInfo.position;
        int itemId = item.getItemId();

        if (itemId == R.id.context_add) {
            Toast.makeText(this, " " + titles[position], Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "context_add", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.context_delete) {
            Toast.makeText(this, " " + depicts[position], Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "context_delete", Toast.LENGTH_SHORT).show();

        } else if (itemId == R.id.context_more) {
            Toast.makeText(this, "context_more", Toast.LENGTH_SHORT).show();
        }

        return super.onContextItemSelected(item);
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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(ContextActivity.this, R.layout.list_item, null);
                viewHolder = new ListViewHolder(
                        convertView.findViewById(R.id.tv_title),
                        convertView.findViewById(R.id.tv_depict)
                );
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ListViewHolder) convertView.getTag();
            }


            viewHolder.getTvTitle().setText(titles[position]);
            viewHolder.getTvDepict().setText(depicts[position]);

            return convertView;
        }
    }
}
