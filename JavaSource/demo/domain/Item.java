package demo.domain;

public class Item {

	private int speed;

	private int speedLimit;

	public Item(int speed, int speedLimit) {
		this.speed = speed;
		this.speedLimit = speedLimit;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" [Speed=%d, Speed Limit=%d]", speed, speedLimit);
	}

	public int getSpeed() {
		return speed;
	}

	public int getSpeedLimit() {
		return speedLimit;
	}

}
