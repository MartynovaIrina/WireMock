package Tasks;

import Orders.Order;
import Products.Apple;
import Products.Orange;
import Products.Product;
import UserInfo.Address;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Apple apple = new Apple(300, "apple", 100, "red");
        Orange orange = new Orange(500, "orange", 100, false);
        List<Product> products = new ArrayList<>();
        Address address = new Address("Russia", "Moscow", "Tverskaya", 1, 1, 2);
        products.add(apple);
        products.add(orange);
        Order order = new Order(products, address, 1);
        FileWriter fileWriter = new FileWriter("src/order.json");
        mapper.writeValue(fileWriter, order);
        FileReader fileReader = new FileReader("src/order.json");
        order = mapper.readValue(fileReader, Order.class);
        System.out.println(order.toString());
    }
}
