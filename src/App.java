import net.salesianos.elements.Client;
import net.salesianos.elements.Farmer;
import net.salesianos.elements.Restaurant;

public class App {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(10);

        final String[] FARMERS_NAMES = { "Paco", "Lucía", "Trululú" };
        final int[] FARMERS_HARVESTS = { 5, 3, 7 };
        final String[] CLIENTS_NAMES = { "Manolo", "Ernesto", "Sir Persibal Wilfredo" };
        final int[] CLIENTS_VEGETABLES = { 5, 3, 7 };

        Thread[] farmerThreads = new Thread[FARMERS_NAMES.length];
        Thread[] clientThreads = new Thread[CLIENTS_NAMES.length];

        for (int i = 0; i < FARMERS_NAMES.length; i++) {

            Farmer farmer = new Farmer(FARMERS_NAMES[i], FARMERS_HARVESTS[i], restaurant);
            farmerThreads[i] = new Thread(farmer);
            farmerThreads[i].setPriority(Thread.MAX_PRIORITY);
            farmerThreads[i].start();
        }

        for (int i = 0; i < CLIENTS_NAMES.length; i++) {

            Client client = new Client(CLIENTS_NAMES[i], CLIENTS_VEGETABLES[i], restaurant);
            clientThreads[i] = new Thread(client);
            clientThreads[i].start();
        }

        try {

            for (Thread farmerThread : farmerThreads) {
                farmerThread.join();
            }

            for (Thread clientThread : clientThreads) {
                clientThread.join();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
