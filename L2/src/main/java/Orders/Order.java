package Orders;

import UserInfo.Address;
import Products.Product;

import java.util.List;
public class Order{
    public static int idTotal;

    public int id;
    public List<Product> productList;
    public Address address;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" + id + ", "+
                "productList=" + productList + ", " + address +
                '}';
    }
    public Order(List<Product> productList, Address address, int id) {
        idTotal++;
        this.id = id;
        this.productList = productList;
        this.address = address;
    }
    }
