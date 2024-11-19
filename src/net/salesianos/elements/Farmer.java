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


    }
}
