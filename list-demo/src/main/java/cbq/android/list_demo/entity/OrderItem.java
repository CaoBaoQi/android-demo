package cbq.android.list_demo.entity;

/**
 * OrderItem
 *
 * @author Cola777jz
 * @date 2023/10/31 17:19
 * @since 1.0.0
 */
public class OrderItem {
    private String title;
    private Double price;

    private Boolean status;


    public OrderItem(String title, Double price, Boolean status) {
        this.title = title;
        this.price = price;
        this.status = status;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}

