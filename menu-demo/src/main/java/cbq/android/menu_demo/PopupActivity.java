package cbq.android.menu_demo;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import cbq.android.menu_demo.holder.ListViewHolder;

/**
 * PopupActivity
 *
 * @author Cola777jz
 * @date 2023/10/31 19:04
 * @since 1.0.0
 */
public class PopupActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_menu_popup);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new PopupActivity.CustomBaseAdapter());

        listView.setOnItemClickListener((parent, view, position, id) -> {
            PopupMenu popupMenu = new PopupMenu(PopupActivity.this, view);
            popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
            popupMenu.show();

            popupMenu.setOnMenuItemClickListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.popup_add) {
                    Toast.makeText(PopupActivity.this, " " + titles[position], Toast.LENGTH_SHORT).show();
                    Toast.makeText(PopupActivity.this, "popup_add", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.popup_delete) {
                    Toast.makeText(PopupActivity.this, " " + depicts[position], Toast.LENGTH_SHORT).show();
                    Toast.makeText(PopupActivity.this, "popup_delete", Toast.LENGTH_SHORT).show();

                } else if (itemId == R.id.popup_more) {
                    Toast.makeText(PopupActivity.this, "popup_more", Toast.LENGTH_SHORT).show();
                }
                return false;
            });
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

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ListViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(PopupActivity.this, R.layout.list_item, null);
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
