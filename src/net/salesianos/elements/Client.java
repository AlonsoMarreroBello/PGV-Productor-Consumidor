package net.salesianos.elements;
public class Client extends Person implements Runnable {

	private int vegetablesToEat;
	private Restaurant restaurant;

	public Client(String name, int vegetablesToEat, Restaurant restaurant) {
		super(name);
		this.vegetablesToEat = vegetablesToEat;
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < vegetablesToEat; i++) {
				
				System.out.println("\n[Client: " + getName() + "] 🍴 Trying to consume a vegetable...");
                
				long eatingTime = (long) (Math.random() * 5000) + 1000;
				Thread.sleep(eatingTime);

				restaurant.getCrop(this.getName());
			}
		} catch (InterruptedException e) {

			System.out.println("\n[Client: " + getName() + "] ❌ Error: Interrupted while eating.");
            Thread.currentThread().interrupt();
			return;
		}
	}

}
