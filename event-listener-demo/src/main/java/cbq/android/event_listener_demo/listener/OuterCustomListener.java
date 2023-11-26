package cbq.android.event_listener_demo.listener;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * OuterCustomListener
 *
 * @author Cola777jz
 * @date 2023/10/31 16:20
 * @since 1.0.0
 */
public class OuterCustomListener implements View.OnClickListener {
    private Context context;

    public OuterCustomListener(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "外部类 V3", Toast.LENGTH_SHORT).show();
    }
}
