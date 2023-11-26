package cbq.android.work_chat.entity;

import android.graphics.Bitmap;

/**
 * MessageItem
 *
 * @author Cola777jz
 * @date 2023/10/31 17:31
 * @since 1.0.0
 */
public class MessageItem {
    private Bitmap image;
    private String title;
    private int mag_type;//消息的类型

    public MessageItem(Bitmap image,String title,int mag_type){
        this.mag_type=mag_type;
        this.title=title;
        this.image=image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMag_type() {
        return mag_type;
    }

    public void setMag_type(int mag_type) {
        this.mag_type = mag_type;
    }
}
