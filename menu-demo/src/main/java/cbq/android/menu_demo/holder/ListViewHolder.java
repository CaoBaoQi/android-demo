package cbq.android.menu_demo.holder;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * ListViewHolder
 *
 * @author Cola777jz
 * @date 2023/10/31 19:59
 * @since 1.0.0
 */
public class ListViewHolder {
    private TextView tvTitle;
    private TextView tvDepict;

    public ListViewHolder() {
    }

    public ListViewHolder(TextView tvTitle, TextView tvDepict) {
        this.tvTitle = tvTitle;
        this.tvDepict = tvDepict;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(TextView tvTitle) {
        this.tvTitle = tvTitle;
    }

    public TextView getTvDepict() {
        return tvDepict;
    }

    public void setTvDepict(TextView tvDepict) {
        this.tvDepict = tvDepict;
    }
}
