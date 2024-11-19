import net.salesianos.elements.Farmer;

public class App {
    public static void main(String[] args) {

        Farmer farmer1 = new Farmer("Paco", 5);
        Farmer farmer2 = new Farmer("Lucía", 3);
        Farmer farmer3 = new Farmer("Trululú", 7);

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
