package net.salesianos.elements;

import net.salesianos.utils.MessageColor;
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


				System.out.println(MessageColor.BLUE + "\nCustomer " + this.getName() + " is trying to eat at the restaurant." + MessageColor.RESET);

				long eatingTime = (long) (Math.random() * 5000) + 1000;
				Thread.sleep(eatingTime);

				restaurant.getCrop(this.getName());
			}
		} catch (InterruptedException e) {

			System.out.println(MessageColor.RED + "\n[ERROR] Customer " + getName() + " was interrupted while eating." + MessageColor.RESET);
			Thread.currentThread().interrupt();
			return;
		}
	}

}
