import net.salesianos.elements.Client;
import net.salesianos.elements.Farmer;
import net.salesianos.elements.Restaurant;

public class App {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(10);

        Farmer farmer1 = new Farmer("Paco", 5, restaurant);
        Farmer farmer2 = new Farmer("Lucía", 3, restaurant);
        Farmer farmer3 = new Farmer("Trululú", 7, restaurant);

        Client client1 = new Client("Manolo", 5, restaurant);
        Client client2 = new Client("Ernesto", 3, restaurant);
        Client client3 = new Client("Sir Persibal Wilfredo", 7, restaurant);

        Thread farmerThread1 = new Thread(farmer1);
        farmerThread1.start();

        Thread farmerThread2 = new Thread(farmer2);
        farmerThread2.start();

        Thread farmerThread3 = new Thread(farmer3);
        farmerThread3.start();

        Thread clientThread1 = new Thread(client1);
        clientThread1.start();

        Thread clientThread2 = new Thread(client2);
        clientThread2.start();

        Thread clientThread3 = new Thread(client3);
        clientThread3.start();

        try {

            farmerThread1.join();
            farmerThread2.join();
            farmerThread3.join();
            clientThread1.join();
            clientThread2.join();
            clientThread3.join();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println(restaurant.getFreshProduceStock().toString());

    }
}
