package arrays;

public class ObjectMain {

	public ObjectMain() {
		 Person[] people = new Person[12];
		 populate(people);
		 for(Person p: people) {
				System.out.println(p);
			}
		 people[0] = new Thing("toaster oven");
	}

	private void populate(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START,
					Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START,
					Person.LAST_MIDDLE, Person.LAST_END);
			Borough home = randomBorough();
			//BIG IDEA:
			//In an object array, you can have multiple data types!
			//(This is unlike a primitive array, like int[], boolean[], etc.)
			if(Math.random()< 0.6) {
				//60% of the time
				int money = (int)(Math.random() * 20+1) *100000;
				people[i] = new Athlete(firstName, lastName, home, money);
			}else {
				//the other 40% of the time
				people[i] = new Person(firstName, lastName, home);
			}
		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[
		        (int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a) + get(b) + get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();
	}

}
