package Task1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Product p1 = new Product("Sach Giao Khoa", "Sach", 20000, new Date(1995, Calendar.JULY, 23));
        Product p2 = new Product("Toi tai gioi, ban tai xiu", "Tap chi", 25000, new Date(2020, Calendar.AUGUST, 23));
        Product p3 = new Product("Hoc cach lam nguoi", "Sach", 10000, new Date(2021, Calendar.OCTOBER, 23));
        Product p4 = new Product("Dark nhan tam", "Tap chi", 30000, new Date(2022, Calendar.FEBRUARY, 23));
        Product p5 = new Product("Sach thuong", "Sach", 10000, new Date(1978, Calendar.MARCH, 23));

        OrderItem orderItem1 = new OrderItem(p1, 1);
        OrderItem orderItem2 = new OrderItem(p2, 3);
        OrderItem orderItem3 = new OrderItem(p3, 5);
        OrderItem orderItem4 = new OrderItem(p4, 6);
        OrderItem orderItem5 = new OrderItem(p5, 2);
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);
        orderItems.add(orderItem3);
        orderItems.add(orderItem4);
        orderItems.add(orderItem5);
        Order order1 = new Order("O1", "Flo1", "Kali1", new Date(2023, Calendar.APRIL, 25), randomOrderItems(orderItems));
        Order order2 = new Order("O2", "Flo2", "Kali2", new Date(2023, Calendar.JUNE, 25), randomOrderItems(orderItems));
        Order order3 = new Order("O3", "Flo3", "Kali3", new Date(2023, Calendar.JULY, 25), randomOrderItems(orderItems));
        Order order4 = new Order("O4", "Flo4", "Kali4", new Date(2023, Calendar.AUGUST, 25), randomOrderItems(orderItems));
        Order order5 = new Order("O5", "Flo5", "Kali5", new Date(2023, Calendar.SEPTEMBER, 25), randomOrderItems(orderItems));

        List<Order> order = new ArrayList<>();
        order.add(order1);
        order.add(order2);
        order.add(order3);
        order.add(order4);
        order.add(order5);

        OrderManager orderManager = new OrderManager(order);
        System.out.println(orderManager.maxProduct());
        System.out.println(orderManager.productTypesStatistics());
        System.out.println(orderManager.ordersByCost());
    }

    public static List<OrderItem> randomOrderItems(List<OrderItem> orderItems) {
        List<OrderItem> res = new ArrayList<>();
        Collections.shuffle(orderItems);
        int random = new Random().nextInt(1,orderItems.size());
        for (int i = 0; i < random; i++) {
            res.add(orderItems.get(i));
        }
        return res;
    }
}
