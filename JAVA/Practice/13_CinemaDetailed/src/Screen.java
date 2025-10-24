public class Screen{


	// Attributes

	public static final int PRICE_REGULAR = 500;
	public static final int PRICE_PREMIUM = 750;
	public static final int PRICE_VIP = 1000;
	public static final int PRICE_RECLINER = 1200;
	public static final int DEFAULT_NUM_ROWS = 5;

	private String screenName;
	private Seat[][] seats;

	
	// Constructor

	public Screen(){
	
		this("Screen");
	
	}

	public Screen(String screenName){
	
		this(screenName, buildDefaultRowLength(DEFAULT_NUM_ROWS));
	
	}

	public Screen(String screenName, int[] rowLength){
	
		this.screenName = screenName;
		seats = new Seat[rowLength.length][];

		
		// Defining the length of 2d array

		for(int i=0; i<seats.length; i++){
	
			seats[i] = new Seat[rowLength[i]];
				
		}	


		// Initialize 2d array

			materializeGrid();
	
	}


	
	// Method

	public void displayLayout(){

		System.out.printf("====  %s | Layout ====\n\n", screenName);

		for(int i=0; i<seats.length; i++){

			StringBuilder line = new StringBuilder();
	
			for(int j=0; j<seats[i].length; j++){
			
				line.append(String.format("[%s : %c] ", seats[i][j].getId(), seats[i][j].isAvailable()? 'A': 'X'));	

			}

			System.out.println(line.toString());

		}

		System.out.printf("Total: %d, Available: %d\n\n", getTotalSeatsCount(), getAvailableSeatCount());

	}

	public Seat[] listAvailable(SeatType seatType){

		int availSeatsCount = 0;

		for(Seat[] row: seats){

			for(Seat col: row){

				if(col.isAvailable() && col.getSeatType() == seatType)
						
					availSeatsCount++;
			}

		}

		Seat listAvailArr[] = new Seat[availSeatsCount];
		int index = 0;


		for(int i=0; i<seats.length; i++){

			for(int j=0; j<seats[i].length; j++){

				if(seats[i][j]!=null && seats[i][j].isAvailable() && seats[i][j].getSeatType() == seatType)
					
					listAvailArr[index++] = seats[i][j];	
			}

		}

		return listAvailArr;
		
	
	}

	public int getRowCount(){

		return seats.length;
	}

	public double priceFor(SeatType seatType){

		switch(seatType){

			case REGULAR:
				return PRICE_REGULAR;
			case PREMIUM:
				return PRICE_PREMIUM;
			case VIP:
				return PRICE_VIP;
			default:
				return PRICE_RECLINER;

		}

	}

	public SeatType seatTypeFor(int row, int col){

		checkBounds(row, col);

		return seats[row][col].getSeatType();

	}

	public int getRowLength(int row){

		checkRow(row);

		return seats[row].length;

	}

	public boolean cancel(String id){

		for(Seat[] row: seats){

			for(Seat col: row){

				if(col.getId().equals(id) && !col.isAvailable()){
					col.setAvailable(true);
					return true;	
				}	

			}

		}

		return false;
	
	}

	public Seat findFirstAvailableSeat(SeatType seatType){

		for(Seat[] row: seats){

			for(Seat col: row){
				
				if(col.getSeatType() == seatType && col.isAvailable())
					return col;
			
			}

		}
	
		return null;

	}

	private static int[] buildDefaultRowLength(int size){

		int[] rowLengths = new int[size];

		// Defining the length of 2d array

		for(int i=0; i<rowLengths.length; i++){
	
			rowLengths[i] = 10 + i;
				
		}	

		return rowLengths;

	}

	public void materializeGrid(){

		int frontRows, middleRows, penultimateRows, lastRow;

		if(seats.length%2==0){
			
			frontRows = (seats.length/2)+1;  // less than
			middleRows = frontRows+1;  // less than
			lastRow = seats.length;  // Equal to
			penultimateRows = lastRow;  // less than

	
		}else{

			frontRows = (seats.length+1)/2;  // less than
			middleRows = frontRows+1;  // less than
			lastRow = seats.length;  // Equal to
			penultimateRows = lastRow;  // less than
		}


		for(int i=0; i<seats.length; i++){

			for(int j=0; j<seats[i].length; j++){

				if((i+1)<frontRows)
					seats[i][j] = new Seat(i+1, j+1, SeatType.REGULAR, 500);
				else if((i+1)<middleRows)
					seats[i][j] = new Seat(i+1, j+1, SeatType.PREMIUM, 750);
				else if((i+1)<penultimateRows)
					seats[i][j] = new Seat(i+1, j+1, SeatType.VIP, 1000);
				else
					seats[i][j] = new Seat(i+1, j+1, SeatType.RECLINER, 1200);
			}
		}	
	}

	public boolean cancel(int row, int col){

		if(seats[row][col].isAvailable())
			return false;
		seats[row][col].setAvailable(true);
		return true;
	
	}

	public boolean book(String id){

		for(int i=0; i<seats.length; i++){
			for(int j=0; j<seats[i].length; j++){

				if(seats[i][j].getId().equals(id) && seats[i][j].isAvailable() == true){
					seats[i][j].setAvailable(false);
					return true;
				}
			}
		}

		return false;

	}

	public void checkRow(int row){

		if(row < 0 || row >= seats.length)
			throw new IndexOutOfBoundsException("Invalid Row Index: " + row);
	
	}


	public String getScreenName(){

		return screenName;

	}

	
	public Seat getSeat(String id){

		for(int i=0; i<seats.length; i++){

			for(int j=0; j<seats[i].length; j++){

				if(seats[i][j].getId().equals(id)){
					return seats[i][j];
				}
				
			}

		}

		return null;
	
	}

		
	public int getAvailableSeatCount(){

		int availableSeats = 0;
	
		for(int i=0; i<seats.length; i++){

			for(int j=0; j<seats[i].length; j++){

				if(seats[i][j].isAvailable()){
					availableSeats++;
				}
				
			}

		}

	
		return availableSeats;
	
	}


	public void setRowType(int rowNum, SeatType seatType, double price){

		for(int i=0; i<seats[rowNum].length; i++){
			
			seats[rowNum][i].setSeatType(seatType);
			seats[rowNum][i].setPrice(price);

		}
	
	}

	
	public void checkBounds(int row, int col){

		checkRow(row);
		if(col < 0 || col >= seats[row].length)
			throw new IndexOutOfBoundsException("Invalid column index: " + col);
	}


	public Seat getSeat(int row, int col){

		return seats[row][col];
	
	}

	
	public boolean book(int row, int col){

		checkBounds(row, col);

		if(!seats[row][col].isAvailable())
			return false;
		seats[row][col].setAvailable(false);
		return true;

	}

	public int getTotalSeatsCount(){

		int totalSeats = 0;

		for(Seat[] row: seats){

			for(Seat element: row){
				totalSeats++;
			}
		}


		return totalSeats;
	
	}

	public void displayVerbose(){

		System.out.printf("=== %s | Detailed Seats ===\n\n", screenName);
	
		for(int i=0; i<seats.length; i++){

			for(int j=0; j<seats[i].length; j++){

				System.out.print(seats[i][j] + " ");
			}
	
			System.out.println();
		}

	}



	@Override
	public String toString(){

		StringBuilder line = new StringBuilder();

		line.append(String.format("====  %s | Layout ====\n", screenName));

		for(int i=0; i<seats.length; i++){
	
			for(int j=0; j<seats[i].length; j++){
			
				line.append(String.format("[%s : %c] ", seats[i][j].getId(), seats[i][j].isAvailable()? 'A': 'X'));	

			}

			line.append("\n");

		}

		line.append(String.format("Total: %d, Available: %d\n", getTotalSeatsCount(), getAvailableSeatCount()));

		return line.toString();

	}

}