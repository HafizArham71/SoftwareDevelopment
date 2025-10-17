public class Screen{

	
	// Attributes
	
	private static final double PRICE_REGULAR = 500;
	private static final double PRICE_PREMIUM = 750;
	private static final double PRICE_VIP = 1000;
	private static final double PRICE_RECLINER = 1200;
	private static final int DEFAULT_NUM_ROWS = 5;

	private Seat[][] seats = new Seat[DEFAULT_NUM_ROWS][];
	private String screenName;


	// Constructors

	public Screen(){

		this("Untitled");
	}

	public Screen(String screenName){

		this(screenName, defaultRowLength(DEFAULT_NUM_ROWS));
	}

	public Screen(String screenName, int[] rowLength){
		this.screenName = screenName;

		for(int i=0; i<seats.length; i++)
			seats[i] = new Seat[rowLength[i]];

		for(int i=0; i<seats.length; i++){
			for(int j=0; j<seats[i].length; j++){
				materializeGrid(i, j, seats.length);
			}
		}
	}



	// Method

	public static int[] defaultRowLength(int arrayLength){
		int[] rowArr = new int[arrayLength];

		for(int i=0; i<arrayLength; i++){
			rowArr[i] = 10+i;
		}

		return rowArr;
	}

	public void materializeGrid(int i, int j, int length){
		if((i+1)<(length*0.40))
			seats[i][j] = new Seat(i, j, SeatType.REGULAR, PRICE_REGULAR);
		else if((i+1)<(length*0.30))
			seats[i][j] = new Seat(i, j, SeatType.PREMIUM, PRICE_PREMIUM);
		else if((i+1)<(length*0.2))
			seats[i][j] = new Seat(i, j, SeatType.VIP, PRICE_VIP);
		else
			seats[i][j] = new Seat(i, j, SeatType.RECLINER, PRICE_RECLINER);
	}

	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(screenName + "\n");

		for(int i=0; i<seats.length; i++){
			for(int j=0; j<seats[i].length; j++){
				str.append(seats[i][j]);
			}
	
			str.append("\n");
		}
	
		return str.toString();
	}
	
}