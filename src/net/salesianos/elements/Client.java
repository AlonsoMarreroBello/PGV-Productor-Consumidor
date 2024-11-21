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

				long cultivationTime = (long) (Math.random() * 5000) + 1000;
				Thread.sleep(cultivationTime);

				System.out.println("\u001B[34m \n" + this.getName() + " is trying to eat at the restaurant.\u001B[0m");
				restaurant.getCrop(this.getName());
			}
		} catch (InterruptedException e) {

			System.out.println("\u001B[31m \n[ERROR] " + getName() + " was interrupted while eating. \u001B[0m");
			Thread.currentThread().interrupt();
			return;
		}
	}

}
