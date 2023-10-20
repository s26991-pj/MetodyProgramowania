import model.Order;
import model.Pizza;
import pizza.PizzaService;
import pizza.PizzaNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        PizzaService pizzaService = new PizzaService(); // Utworzenie instancji klasy PizzaService

        logger.info("Dostępne pizze:");


        // Wyświetlenie dostępnych pizz
        System.out.println("Dostępne pizze:");
        pizzaService.getAvailablePizzas().forEach(pizza -> System.out.println(pizza.getName()));

        //Tworzenie zamówienia

        try{
            Order order1 = pizzaService.makeOrder(new Pizza("Margarita", 22.50));
            Order order2 = pizzaService.makeOrder(new Pizza("Hawajska", 24.00));
            Order order3 = pizzaService.makeOrder(new Pizza("Nieobecna", 26.00)); //takiej pizzy nie ma

        } catch (PizzaNotFoundException e){
            logger.error("Błąd zamówienia: " + e.getMessage(), e);

//            System.err.println("Pizzy nie znaleziono" + e.getMessage());
        }

    }
}
