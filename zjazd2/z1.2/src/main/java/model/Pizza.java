package model;
import lombok.Data;

@Data
public class Pizza {
    private String name; // Nazwa pizzy
    private double price; // Cena pizzy

    public Pizza(String name, double price) {
        this.name = name; // Przypisanie nazwy pizzy
        this.price = price; // Przypisanie ceny pizzy
    }
//
//    // Gettery i settery
//    public String getName() {
//        return name;// Zwrócenie nazwy pizzy
//    }
//
//    public void setName(String name) {
//        this.name = name; // Ustawia nową nazwę pizzy
//    }
//
//    public double getPrice() {
//        return price; // Zwrócenie ceny pizzy
//    }
//
//    public void setPrice(double price) {
//        this.price = price; // Ustawia nową cenę pizzy
//    }
}
