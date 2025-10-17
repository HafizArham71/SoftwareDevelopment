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

	public boolean cancel(int row, int column){
		if(seats[row][column].isAvailable())
			return false;
		seats[row][column].setAvailable(true);
		return true;
	}

	public static int[] defaultRowLength(int arrayLength){
		int[] rowArr = new int[arrayLength];

		for(int i=0; i<arrayLength; i++){
			rowArr[i] = 10+i;
		}

		return rowArr;
	}

	public void materializeGrid(int i, int j, int length){
		
		int front_rows, middle_rows, penultimate_rows, last_rows;
		
		if(length%2==0){ // 10
			front_rows = length/2; // less than 3
			middle_rows = front_rows+1; // less than or equals to 4
			penultimate_rows = middle_rows + (length - middle_rows - 1); // less than or equals to
			last_rows = length; // last row 
		}
		else{ // 11
			front_rows = (length+1)/2; // less than 6
			middle_rows = front_rows; // less than or equals to 6
			penultimate_rows = middle_rows + (length - middle_rows - 1); // less than or equals to 10
			last_rows = length; // last row 11
		}

		if((i+1)<front_rows)
			seats[i][j] = new Seat(i, j, SeatType.REGULAR, PRICE_REGULAR);
		else if((i+1)<=middle_rows)
			seats[i][j] = new Seat(i, j, SeatType.PREMIUM, PRICE_PREMIUM);	
		else if((i+1)<=penultimate_rows)
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