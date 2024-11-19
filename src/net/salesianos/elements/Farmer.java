package net.salesianos.elements;

public class Farmer extends Person implements Runnable {

    private final String[] CROPS = {"lettuce", "cabbage", "onion", "spinach", "potato",
                                "celery", "asparagus", "radish", "broccoli", "artichoke",
                                "tomato", "cucumber", "eggplant", "carrot", "green bean"};
    
    private int harvestCount;

    public Farmer(String name, int harvestCount) {
        
        super(name);
        this.harvestCount = harvestCount;
    }

    @Override
    public void run() {

        for (int i = 0; i < harvestCount; i++) {
            
            try {

                String crop = CROPS[(int) (Math.random() * CROPS.length)];

                System.out.println("\n(Harvest " + (i + 1) + "/" + harvestCount + ") " 
                                    + this.getName() + " is planting " + crop + " in the field...");

                long cultivationTime = (long) (Math.random() * 5000 )+ 1000;
                Thread.sleep(cultivationTime);


                System.out.println("\n" + this.getName() + " has successfully delivered " + crop + " to the restaurant.");

            } catch (InterruptedException e) {
                
                System.out.println("\n[ERROR] " + getName() + " was interrupted while cultivating.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
