package javaTheHardWay;

public class Habitat extends Environment {

	private Animal[] animals;
	
	public static void main(String[] args) {
		Habitat h = new Habitat(5);
		int count = 0;
		while(count < 6) {
			Animals a = new Animal();
			h.addAnimal(a);
			count++;
		}
		System.out.println(h);
	}
	
	public Habitat(int livingCapacity) {
		super(livingCapacity);
		animals = new Animal[livingCapacity];
	}
}
