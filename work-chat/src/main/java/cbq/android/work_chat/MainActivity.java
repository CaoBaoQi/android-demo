package cbq.android.work_chat;

import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import cbq.android.work_chat.adapter.MessageAdapter;
import cbq.android.work_chat.entity.MessageItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<MessageItem> data = new ArrayList<>();
    private MessageAdapter adapter;
    private EditText et_input;//输入的内容
    private Button btn_send;//发送信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        et_input = findViewById(R.id.et_input);
        btn_send = findViewById(R.id.btn_send);

        initData();

        adapter = new MessageAdapter(data, MainActivity.this);
        listView.setAdapter(adapter);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = et_input.getText().toString();
                MessageItem m = new MessageItem(BitmapFactory.decodeResource(getResources(), R.drawable.qq),
                        string, 0);
                data.add(m);
                listView.setSelection(data.size());

                MessageItem m2 = new MessageItem(BitmapFactory.decodeResource(getResources(), R.drawable.wchat),
                        string + "_Copy!", 1);
                data.add(m2);
                listView.setSelection(data.size() + 1);
                adapter.notifyDataSetChanged();
                et_input.setText("");
            }
        });
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.popuo_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        final int position = i;
                        MessageItem m = null;
                        final int itemId = menuItem.getItemId();
                        if (itemId == R.id.popup_add) {
                            if (data.get(position).getMag_type() == 0) {
                                m = new MessageItem(BitmapFactory.decodeResource(getResources(), R.drawable.wchat), "WeChat", 1);
                            } else if (data.get(position).getMag_type() == 1) {
                                m = new MessageItem(BitmapFactory.decodeResource(getResources(), R.drawable.qq), "QQ", 0);
                            }
                            data.add(m);
                            listView.setSelection(data.size());
                            adapter.notifyDataSetChanged();
                        } else if (itemId == R.id.popup_delete) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                            builder
                                    .setTitle("Are You Sure？")
                                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(MainActivity.this, "Please Choose Again", Toast.LENGTH_SHORT).show();

                                        }
                                    })
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            data.remove(position);
                                            listView.setSelection(data.size());
                                            adapter.notifyDataSetChanged();
                                        }
                                    }).create().show();

                        } else if (itemId == R.id.popup_more) {
                            Toast.makeText(MainActivity.this, "MORE-POPUP", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.option_style) {
            Toast.makeText(MainActivity.this,
                    "这是字体大小菜单", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_10) {
            Toast.makeText(MainActivity.this,
                    "这是10号字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_20) {
            Toast.makeText(MainActivity.this,
                    "这是20号字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_30) {
            Toast.makeText(MainActivity.this,
                    "这是30号字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_color || itemId == R.id.option_red) {
            Toast.makeText(MainActivity.this,
                    "这是红色字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_blue) {
            Toast.makeText(MainActivity.this,
                    "这是蓝色字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_yellow) {
            Toast.makeText(MainActivity.this,
                    "这是黄色字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_gray) {
            Toast.makeText(MainActivity.this,
                    "这是灰色字", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.option_normal) {
            Toast.makeText(MainActivity.this,
                    "这是普通菜单", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int position = menuInfo.position;
        MessageItem m = null;

        int itemId = item.getItemId();
        if (itemId == R.id.context_add) {
            if (data.get(position).getMag_type() == 0) {
                m = new MessageItem(BitmapFactory.decodeResource(getResources(), R.drawable.wchat), "WeChat", 1);
            } else if (data.get(position).getMag_type() == 1) {
                m = new MessageItem(BitmapFactory.decodeResource(getResources(), R.drawable.qq), "QQ", 0);
            }
            data.add(m);
            listView.setSelection(data.size());
            adapter.notifyDataSetChanged();
        } else if (itemId == R.id.context_delete) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder
                    .setTitle("确定删除吗？")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "请重新选择", Toast.LENGTH_SHORT).show();

                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            data.remove(position);
                            listView.setSelection(data.size());
                            adapter.notifyDataSetChanged();
                        }
                    }).create().show();
        } else if (itemId == R.id.context_more) {
            Toast.makeText(MainActivity.this, "MORE-CONTEXT", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    private void initData() {
        MessageItem m1 = new MessageItem(BitmapFactory.decodeResource(getResources(),
                R.drawable.qq), "你好！去上课吗？", 0);
        data.add(m1);
        MessageItem m2 = new MessageItem(BitmapFactory.decodeResource(getResources(),
                R.drawable.wchat), "是啊，要一起吗", 1);
        data.add(m2);
        MessageItem m3 = new MessageItem(BitmapFactory.decodeResource(getResources(),
                R.drawable.qq), "好啊！", 0);
        data.add(m3);
        MessageItem m4 = new MessageItem(BitmapFactory.decodeResource(getResources(),
                R.drawable.wchat), "走吧！", 1);
        data.add(m4);
        MessageItem m5 = new MessageItem(BitmapFactory.decodeResource(getResources(),
                R.drawable.qq), "好！", 0);
        data.add(m5);

    }
}