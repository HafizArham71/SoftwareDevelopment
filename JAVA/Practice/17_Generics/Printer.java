public class Printer <T>{

	T num;

	public Printer(T num){

		this.num = num;

	}

	public void print(){
		
		System.out.println(num);

	}

}