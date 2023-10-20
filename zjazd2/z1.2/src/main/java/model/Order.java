package model;
import lombok.Data;

@Data
public class Order {
    private int orderNumber; // Numer zamówienia
    private Pizza pizza; // Pizza
    private double price; // Cena zamówienia

    public Order(int orderNumber, Pizza pizza, double price) {
        this.orderNumber = orderNumber; // Inicjalizacja numeru zamówienia
        this.pizza = pizza; //Inicjalizacja zamówionej pizzy
        this.price = price; // Inicjalizacja ceny zamówienia

    }

//    // Gettery i settery
//
//
//    public int getOrderNumber() {
//        return orderNumber; // Zwrócenie numeru zamówienia
//    }
//
//    public void setOrderNumber(int orderNumber) {
//        this.orderNumber = orderNumber; // Ustawienie nowego numeru zamówienia
//    }
//
//    public Pizza getPizza() {
//        return pizza; // Zwrócenie zamówionej pizzy
//    }
//
//    public void setPizza(Pizza pizza) {
//        this.pizza = pizza; //  Ustawienie nowej pizzy
//    }
//
//    public double getPrice() {
//        return price; // Zwrócenie ceny zamówienia
//    }
//
//    public void setPrice(double price) {
//        this.price = price;// Ustawienie nowej ceny zamówienia
//    }
}
