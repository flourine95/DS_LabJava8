package Task1;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private String customer;
    private String employee;
    private Date date;
    private List<OrderItem> items;

    public Order(String id, String customer, String employee, Date date, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.date = date;
        this.items = items;
    }

    public Date getDate() {
        return date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public int getCost() {
        return items.stream().mapToInt(OrderItem::getCost).sum();
    }

    @Override
    public String toString() {
        return "\nOrder{" +
                "id='" + id + '\'' +
                ", customer='" + customer + '\'' +
                ", employee='" + employee + '\'' +
                ", date=" + date.getDay() + "/" + date.getMonth() + "/" + date.getYear() +
                ", items=" + items +
                "\n\tTocal cost = " + getCost() +
                '}';
    }
}
