public class Car{

	private String name;
	private int year;
	private Engine engine;

	public Car(String name, int year, String engineType){
		this.name = name;
		this.year = year;
		this.engine = new Engine(engineType);
		
		this.engine.start();
	}

	@Override
	public String toString(){
		return String.format("%s having model %d is running with %s Engine", name, year, engine.type);
	}

	public void drive(){
		System.out.println("Car is Driving!");
	}
}