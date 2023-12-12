package Task1;

import java.util.*;
import java.util.stream.Collectors;

public class OrderManager {
    private List<Order> orders;

    public OrderManager(List<Order> orders) {
        this.orders = orders;
    }

    public Product maxProduct() {
        return orders
                .stream()
                .flatMap(o -> o.getItems().stream())
                .max((OrderItem::hasMorePrice))
                .map(OrderItem::getItem)
                .orElse(null);
    }

    public HashMap<String, Integer> productTypesStatistics() {
        return orders
                .stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.toMap(
                        orderItem -> orderItem.getItem().getType(),
                        OrderItem::getAmount,
                        Integer::sum,
                        HashMap::new)
                );
    }

    public TreeSet<Order> ordersByCost() {
        return orders
                .stream()
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(
                                Comparator
                                        .comparing(Order::getCost, Comparator.reverseOrder())
                                        .thenComparing(Order::getDate))
                ));
    }
}
