package Task1;

public class OrderItem {
    private Product item;
    private int amount;

    public OrderItem(Product item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Product getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public int hasMorePrice(OrderItem o) {
        return item.hasMorePrice(o);
    }

    @Override
    public String toString() {
        return "\n\tTask1.OrderItem{" +
                "item=" + item +
                ", amount=" + amount +
                '}';
    }
}
