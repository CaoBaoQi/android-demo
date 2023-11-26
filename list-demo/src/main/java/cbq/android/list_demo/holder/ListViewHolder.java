package cbq.android.list_demo.holder;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * ViewHolder
 *
 * @author Cola777jz
 * @date 2023/10/31 16:57
 * @since 1.0.0
 */
public class ListViewHolder {
    private TextView tvTitle;
    private TextView tvDepict;
    private ImageView iv;

    public ListViewHolder() {
    }

    public ListViewHolder(TextView tvTitle, TextView tvDepict, ImageView iv) {
        this.tvTitle = tvTitle;
        this.tvDepict = tvDepict;
        this.iv = iv;
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

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }
}

