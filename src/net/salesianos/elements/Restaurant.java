package net.salesianos.elements;

import java.util.LinkedList;

import net.salesianos.utils.MessageColor;

public class Restaurant {

    private int storageLimit;
    private LinkedList<String> freshProduceStock;

    public Restaurant(int storageLimit) {

        this.storageLimit = storageLimit;
        this.freshProduceStock = new LinkedList<>();
    }

    public String getFreshProduceStock() {
        if (freshProduceStock.size() != 0) {
            return "The actual Products in the restaurant are : " + freshProduceStock;
        }
        return "There are no products";
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
        System.out.println(MessageColor.GREEN + "\nAdded " + crop + " to restaurant's stock." + MessageColor.RESET);

        notifyAll();
    }

    public synchronized void getCrop(String clientName) {

        while (freshProduceStock.size() <= 0) {

            try {
                System.out.println(MessageColor.YELLOW + "\nRestaurant is empty, " + clientName + " is waiting to eat..." + MessageColor.RESET);
                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }

        String crop = freshProduceStock.pop();
        System.out.println(MessageColor.GREEN + "\n" + crop + " was eaten at the restaurant by a customer called " + clientName
                + MessageColor.RESET);

        notifyAll();
    }
}
