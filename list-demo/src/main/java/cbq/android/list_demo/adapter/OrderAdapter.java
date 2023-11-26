package cbq.android.list_demo.adapter;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import cbq.android.list_demo.R;
import cbq.android.list_demo.entity.OrderItem;
import cbq.android.list_demo.holder.OrderViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * OrderAdapter
 *
 * @author Cola777jz
 * @date 2023/10/31 17:18
 * @since 1.0.0
 */
public class OrderAdapter extends BaseAdapter {

    private final List<OrderItem> orderList;
    private final Activity activity;

    /**
     * 订单 Adapter
     * @param orderList 数据源
     * @param activity activity
     */
    public OrderAdapter(List<OrderItem> orderList, Activity activity) {
        this.orderList = orderList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Object getItem(int i) {
        return orderList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        OrderViewHolder holder;
        if (view == null) {
            holder = new OrderViewHolder();
            view = View.inflate(activity, R.layout.recycle_item, null);

            holder.setTitle(view.findViewById(R.id.tx_goods_title));
            holder.setPrice(view.findViewById(R.id.tx_order_price));
            holder.setStatus(view.findViewById(R.id.tx_order_status));
            holder.setTime(view.findViewById(R.id.tx_order_time));

            view.setTag(holder);
        } else {
            holder = (OrderViewHolder) view.getTag();
        }
        holder.getTitle().setText(orderList.get(i).getTitle());
        holder.getPrice().setText("价格：" + orderList.get(i).getPrice().intValue() + "元");
        holder.getStatus().setText(" 订单状态：" + (orderList.get(i).getStatus() ? "已结算" : "未结算"));
        holder.getTime().setText("创建时间：" + new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date()));

        return view;
    }
}

