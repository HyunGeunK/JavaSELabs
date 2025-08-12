package workshop.animal.entity;

public class Spider extends Animal {

	protected Spider(String name) {
		super(8);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		System.out.println("거미는 벌레를 먹어요");

	}

}
