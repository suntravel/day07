package com.train.wrapper;

public class carWrapper implements Car {
	
	private Car car;

	public carWrapper(Car car) {
		
		this.car = car;
		
	}

	@Override
	public void run() {

		System.out.println("Add Energe");
		System.out.println("accelerating...");

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		car.stop();

	}

}
