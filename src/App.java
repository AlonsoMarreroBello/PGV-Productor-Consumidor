import net.salesianos.elements.Farmer;
import net.salesianos.elements.Restaurant;

public class App {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(10);

        Farmer farmer1 = new Farmer("Paco", 5, restaurant);
        Farmer farmer2 = new Farmer("Lucía", 3, restaurant);
        Farmer farmer3 = new Farmer("Trululú", 7, restaurant);

        Thread farmerThread1 = new Thread(farmer1);
        farmerThread1.start();

        Thread farmerThread2 = new Thread(farmer2);
        farmerThread2.start();

        Thread farmerThread3 = new Thread(farmer3);
        farmerThread3.start();

        try {

            farmerThread1.join();
            farmerThread2.join();
            farmerThread3.join();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
