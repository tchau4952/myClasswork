package arrays;

public class Hobby extends Thing {

	public Hobby(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public static Hobby randomHobby() {
		Hobby[] h = {new Hobby("Playing video games"),
				new Hobby("dancing"),
				new Hobby("going for long walks")
		};
		return h[(int)(Math.random()*h.length)];
	}

}
