package exam.client.common.enumeration;

public enum Status implements AbstractEnum {

	ACTIVE(0), PASSIVE(1);

	private Status(int id) {
		this.id = id;
	}

	private int id;

	@Override
	public int getId() {
		return id;
	}

}
