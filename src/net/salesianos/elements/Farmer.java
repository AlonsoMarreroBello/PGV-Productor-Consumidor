package net.salesianos.elements;

import net.salesianos.utils.MessageColor;

public class Farmer extends Person implements Runnable {

    private final String[] CROPS = {"lettuce", "cabbage", "onion", "spinach", "potato",
                                "celery", "asparagus", "radish", "broccoli", "artichoke",
                                "tomato", "cucumber", "eggplant", "carrot", "green bean"};
    
    private int harvestCount;
    private Restaurant restaurant;

    public Farmer(String name, int harvestCount, Restaurant restaurant) {
        
        super(name);
        this.harvestCount = harvestCount;
        this.restaurant = restaurant;
    }

    @Override
    public void run() {

        for (int i = 0; i < harvestCount; i++) {
            
            try {

                String crop = CROPS[(int) (Math.random() * CROPS.length)];

                System.out.println("\n(Harvest " + (i + 1) + "/" + harvestCount + ") Farmer " 
                                    + this.getName() + " is planting " + crop + " in the field...");

                long cultivationTime = (long) (Math.random() * 5000 )+ 1000;
                Thread.sleep(cultivationTime);

                System.out.println(MessageColor.YELLOW + "\nFarmer " + this.getName() + " is trying to deliver " + crop + " to the restaurant." + MessageColor.RESET);
                restaurant.addCrop(crop);

                System.out.println(MessageColor.GREEN + "\nFarmer " + this.getName() + " has successfully delivered " + crop + " to the restaurant." + MessageColor.RESET);

            } catch (InterruptedException e) {

                System.out.println(MessageColor.RED + "\n[ERROR] Farmer " + getName() + " was interrupted while cultivating." + MessageColor.RESET);
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
