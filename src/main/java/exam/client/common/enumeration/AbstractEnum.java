package exam.client.common.enumeration;

import java.util.stream.Stream;

public interface AbstractEnum {

	public int getId();

	public static <E extends Enum<E> & AbstractEnum> E fromId(Class<E> cls, int id) {
		return Stream.of(cls.getEnumConstants())
				.filter(e -> e.getId() == id)
				.findFirst()
				.orElseThrow(() -> new UnsupportedOperationException("The id '" + id + "' is not supported!"));
	}

}
