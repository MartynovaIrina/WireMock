package UserInfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Address {
    public Address() {
    }
    public String country;
    public String city;
    public String street;
    public int building;
    public int floor;
    public int apartment;

    @Override
    public String toString() {
        return "Address.Address{" +
                "country=" + country +
                ", city=" + city +
                ", street=" + street +
                ", building=" + building +
                ", floor=" + floor +
                ", apartment='" + apartment + '\'' +
                '}';
    }

    public Address(String country, String city, String street, int building, int floor, int apartment) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.floor = floor;
        this.apartment = apartment;
    }
}
