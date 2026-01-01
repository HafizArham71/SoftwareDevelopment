public class UniversalPrinter<T, V extends Shape> {

	T value;
	V value1;

	public UniversalPrinter(T value, V value1) {

		this.value = value;
		this.value1 = value1;

	}

	public void show() {
		value.area();
		System.out.println(value);
		//value1.area();
		System.out.println(value1);


	}

	

}