interface Game{

	void start();
	void greet();
	void ends();

	// Interface cannot have methods body

	default void greetingArham(){

		System.out.println("Hello Arham");

	}

}

public class Test {
    public static void main(String[] args) {
        Game game = new Game() {

		@Override
		public void start(){

			System.out.println("Game has started");

		}

		@Override
		public void greet(){

			System.out.println("Hello!");

		}

		@Override
		public void ends(){

			System.out.println("Game has ended");

		}

	};
    }
}
