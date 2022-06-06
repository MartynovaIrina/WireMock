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

public class Task3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        int numberOfOrders = 100;
        List<Order> listOfOrders = new ArrayList<>();
        String[] countries = new String[]{"Australia" , "Micronesia" , "Canada"};
        String[] cities = new String[]{"Gold Coast" , "Palikir" , "Toronto"};
        String[] streets = new String[]{"Surfers Paradise" , "National Government" , "Saint Patrick"};

        int priceApple;
        int weightApple;
        int priceOrange;
        int weightOrange;
        boolean withBones;
        int building;
        int floor;
        int apartment;
        int random;
        for (int i = 1; i <= numberOfOrders; i++) {
            List<Product> products = new ArrayList<>();
            priceApple = (int)(Math.random() * 600 + 1);
            weightApple = (int)(Math.random() * 200 + 1);
            Apple apple = new Apple(priceApple, "apple", weightApple, "red");
            if (i % 2 == 0) {
                products.add(apple);
            }
            else {
                priceOrange = (int)(Math.random() * 600 + 1);
                weightOrange = (int)(Math.random() * 200 + 1);
                withBones = (Math.random() < 0.5);
                Orange orange = new Orange(priceOrange, "orange", weightOrange, withBones);
                products.add(apple);
                products.add(orange);
            }
            building = (int)(Math.random() * 20 + 1);
            floor = (int)(Math.random() * 15 + 1);
            apartment = (int)(Math.random() * 200 + 1);
            random = (int)(Math.random() * streets.length);
            Address address = new Address(countries[random],
                    cities[random], streets[random], building, floor, apartment);
            Order orderCurr = new Order(products, address, i);
            listOfOrders.add(orderCurr);
        }

        FileWriter fileWriter = new FileWriter("src/orders.json");
        mapper.writeValue(fileWriter, listOfOrders);

        FileReader fileReader = new FileReader("src/orders.json");
        listOfOrders = mapper.readValue(fileReader, listOfOrders.getClass());
        System.out.println(listOfOrders.toString());

    }
}
