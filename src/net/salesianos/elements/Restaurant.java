package net.salesianos.elements;

import java.util.LinkedList;

public class Restaurant {

    private int storageLimit;
    private LinkedList<String> freshProduceStock;

    public Restaurant(int storageLimit) {

        this.storageLimit = storageLimit;
        this.freshProduceStock = new LinkedList<>();
    }

    public String getFreshProduceStock() {

        return freshProduceStock.toString();
    }

    public synchronized void addCrop(String crop) {

        while (freshProduceStock.size() >= storageLimit) {

            try {

                System.out.println("\n[Restaurant]❗Full capacity. Waiting to add \"" + crop + "\"...");                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        freshProduceStock.add(crop);
        System.out.println("\n[Restaurant] ✅ Added \"" + crop + "\" to stock.");
        System.out.println("\n[Restaurant] 🏬 Current Stock: " + freshProduceStock);

        notifyAll();
    }

    public synchronized void getCrop(String clientName) {

        while (freshProduceStock.isEmpty()) {

            try {
                System.out.println("\n[Client: " + clientName + "]❗Restaurant is empty. Waiting...");                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        String crop = freshProduceStock.pop();
        System.out.println("\n[Client: " + clientName + "] ✅ Consumed \"" + crop + "\" from the restaurant.");
        System.out.println("\n[Restaurant] 🏬 Current Stock: " + freshProduceStock);

        notifyAll();
    }
}
