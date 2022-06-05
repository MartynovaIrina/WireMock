package Tasks;

import Products.Apple;
import Products.Orange;
import Products.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Task1 {
    public static void main(String[] args) throws IOException {
        HashMap<String, FileWriter> writers = new HashMap<>();
        HashMap<String, FileReader> readers = new HashMap<>();
        String prefixPath = "src/";
        String[] fileName = {"product", "apple", "orange"};
        String[] pathArray = new String[fileName.length];
        String extensionOfFile = ".json";
        StringBuffer buffer = new StringBuffer();
        ObjectMapper mapper = new ObjectMapper();
        FileWriter fileWriter;
        FileReader fileReader;
        for(int i = 0; i < 3; i++) {
            buffer.append(prefixPath);
            buffer.append(fileName[i]);
            buffer.append(extensionOfFile);
            pathArray[i] = buffer.toString();
            buffer.delete(0, buffer.length());
        }
        for (int i = 0; i < pathArray.length; i++) {
            fileWriter = new FileWriter(pathArray[i]);
            writers.put(fileName[i], fileWriter);
        }
        for (int i = 0; i < pathArray.length; i++) {
            fileReader = new FileReader(pathArray[i]);
            readers.put(fileName[i], fileReader);
        }
        Product product = new Product(100, "product",100);
        mapper.writeValue(writers.get("product"), product);
        Apple apple = new Apple(300, "apple", 100, "red");
        mapper.writeValue(writers.get("apple"), apple);
        Orange orange = new Orange(500, "orange", 100, false);
        mapper.writeValue(writers.get("orange"), orange);
        product = mapper.readValue(readers.get("product"), Product.class);
        System.out.println(product.toString());
        apple = mapper.readValue(readers.get("apple"), Apple.class);
        System.out.println(apple.toString());
        orange = mapper.readValue(readers.get("orange"), Orange.class);
        System.out.println(orange.toString());
    }
}
