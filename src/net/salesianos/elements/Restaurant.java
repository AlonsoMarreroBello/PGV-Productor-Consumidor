package net.salesianos.elements;

import java.util.LinkedList;

public class Restaurant {
    
    private int storageLimit;
    private LinkedList<String> freshProduceStock;

    public Restaurant(int storageLimit) {

        this.storageLimit = storageLimit;
        this.freshProduceStock = new LinkedList<>();
    }

    public synchronized void addCrop(String crop) {

        while (freshProduceStock.size() >= storageLimit) {

            try {

                System.out.println("Restaurant is full, waiting to add " + crop + "...");
                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }
        
        freshProduceStock.add(crop);
        System.out.println("Added " + crop + " to restaurant's stock.");
    }

    public synchronized void getCrop(String crop) {
        
        // All yours, mi pana xoxo <3
    }
}
