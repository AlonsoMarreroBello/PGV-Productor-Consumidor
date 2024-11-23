package net.salesianos.elements;

public class Farmer extends Person implements Runnable {

    private static int cropCounter = 0;
    
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
                String cropId = "C" + (++cropCounter);

                System.out.println("\n[Farmer: " + getName() + "] 🌱 Planting \"" + crop + "\" (ID: " + cropId + ")");
                long cultivationTime = (long) (Math.random() * 5000) + 1000;
                Thread.sleep(cultivationTime);

                System.out.println("\n[Farmer: " + getName() + "] ✅ Delivering \"" + crop + "\" (ID: " + cropId + ") to the restaurant...");
                restaurant.addCrop(cropId + ": " + crop);

            } catch (InterruptedException e) {

                System.out.println("\n[Farmer: " + getName() + "] ❌ Error: Interrupted while cultivating.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
