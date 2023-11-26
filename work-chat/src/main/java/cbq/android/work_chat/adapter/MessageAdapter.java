package cbq.android.work_chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cbq.android.work_chat.R;
import cbq.android.work_chat.entity.MessageItem;

import java.util.List;

/**
 * MessageAdapter
 *
 * @author Cola777jz
 * @date 2023/10/31 17:32
 * @since 1.0.0
 */
public class MessageAdapter extends BaseAdapter {
    private final List<MessageItem> data;
    private final Context context;

    public MessageAdapter(List<MessageItem> data,Context context){
        this.data=data;
        this.context=context;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        MessageItem m =data.get(i);
        if(view==null){
            holder= new ViewHolder();
            if (m.getMag_type()==0){
                view= LayoutInflater.from(context).inflate(R.layout.item_left,null);
                holder.image=view.findViewById(R.id.image_left);
                holder.title=view.findViewById(R.id.title_left);
            }else{
                view= LayoutInflater.from(context).inflate(R.layout.item_right,null);
                holder.image=view.findViewById(R.id.image_right);
                holder.title=view.findViewById(R.id.title_right);
            }
            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }
        holder.image.setImageBitmap(m.getImage());
        holder.title.setText(m.getTitle());
        return view;
    }
    static class ViewHolder{
        ImageView image;
        TextView title;
    }
}
