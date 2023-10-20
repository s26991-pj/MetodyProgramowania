package pizza;

import model.Order;
import model.Pizza;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




@Data
public class PizzaService {
    private List<Pizza> availablePizzas = new ArrayList<>(); // Lista dostępnych pizz

    private static final Logger logger = LogManager.getLogger(PizzaService.class);

    private int orderCounter = 1; // Licznik zamówień

    public PizzaService() {
        // Dodanie kilku pizz do listy dostępnych pizz
        availablePizzas.add(new Pizza("Margarita", 22.50));
        availablePizzas.add(new Pizza("Hawajska", 24.00));
        availablePizzas.add(new Pizza("Pepperoni", 26.00));

        // Logowanie informacji
        logger.info("PizzaService został zainicjowany.");

    }

    public Order makeOrder(Pizza pizza) {
        // Logowanie informacji o zamówieniu
        logger.info("Zamówienie na pizzę: " + pizza.getName());

        //Sprawdzenie czy pizza jest dostępna
        boolean isPizzaAvailable = availablePizzas.stream().anyMatch(p -> p.getName().equals(pizza.getName()));// Sprawdzenie czy pizza jest dostępna

        if (!isPizzaAvailable){
            logger.error("Nie ma takiej pizzy w menu: " + pizza.getName());
            throw new PizzaNotFoundException("Nie ma takiej pizzy w menu: " + pizza.getName()); // Rzucenie wyjątku

        }

        int orderNumber = orderCounter++; //Generowanie numeru zamówienia
        double price = pizza.getPrice(); // Pobranie ceny pizzy
        return new Order(orderNumber, pizza, price); // Utworzenie i zwracanie nowego zamówienia
    }

    public List<Pizza> getAvailablePizzas(){
        return availablePizzas; // Zwrócenie listy dostępnych pizz
    }

}
