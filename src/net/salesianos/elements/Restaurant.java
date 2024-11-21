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

                System.out.println("\nRestaurant is full, waiting to add " + crop + "...");
                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        freshProduceStock.add(crop);
        System.out.println("\nAdded " + crop + " to restaurant's stock.");

        notifyAll();
    }

    public synchronized void getCrop(String clientName) {

        while (freshProduceStock.size() <= 0) {

            try {
                System.out.println("\u001B[31m \nRestaurant is empty, " + clientName + " is waiting to eat \u001B[0m");
                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        String crop = freshProduceStock.pop();
        System.out.println("\u001B[32m \n" + crop + " was eaten at the restaurant by a customer called " + clientName
                + "\u001B[0m");

        notifyAll();
    }
}
