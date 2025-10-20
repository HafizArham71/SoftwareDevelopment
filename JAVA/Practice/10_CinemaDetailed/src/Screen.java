public class Screen{

	
	// Attributes
	
	private static final double PRICE_REGULAR = 500;
	private static final double PRICE_PREMIUM = 750;
	private static final double PRICE_VIP = 1000;
	private static final double PRICE_RECLINER = 1200;
	private static final int DEFAULT_NUM_ROWS = 5;

	private Seat[][] seats;
	private String screenName;



	// Constructors

	public Screen(){

		this("Untitled");
	}

	public Screen(String screenName){

		this(screenName, buildDefaultRowLength(DEFAULT_NUM_ROWS));
	}

	public Screen(String screenName, int[] rowLength){
		this.screenName = screenName;

		seats = new Seat[DEFAULT_NUM_ROWS][];

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
		
		Seat s = getSeat(row, column);

		return s!=null && s.cancelBooking();
	}

	public boolean cancel(String id){
		
		Seat s = getSeat(id);

		return s!=null && s.cancelBooking();
	}

	public boolean book(String id){ // 3
		Seat s = getSeat(id);		
		
		if(s!=null && s.isAvailable()!=false){
			s.setAvailable(false);
			return true;
		}
	
		
		return false;
	}

	public boolean book(int row, int col){ // 3
		Seat s = getSeat(row, col);		
		
		if(s!=null && s.isAvailable()!=false){
			s.setAvailable(false);
			return true;
		}
	
		
		return false;
	}

	private void checkRow(int row){ // 2

		if(row < 0 || row >= seats.length)
			throw new IndexOutOfBoundsException("Row not found");
	}

	public String getScreenName(){ // 1
		return screenName;
	}

	public Seat getSeat(String id){
		
		if(id == null)	return null;
	
		for(int i=0; i<seats.length; i++){
			Seat[] row = seats[i];
			for(int j=0; j<seats[i].length; j++){
				Seat col = row[j];

				if(col.getId().equals(id))
					return col;
			}
		}
		
		return null;
	}

	public Seat getSeat(int row, int col){
		
		checkBounds(row, col);		
		return seats[row][col];
	}

	private void checkBounds(int row, int col){
		checkRow(row);
		if(col<0 || col >=seats[row].length)
			throw new IndexOutOfBoundsException("Col is out of bound");
	}


	public int getAvailableSeatCount(){

		int count = 0;

		for(int i=0; i<seats.length; i++){
			Seat[] row = seats[i];	
			for(int j=0; j<row.length; j++){
				Seat col = row[j];

				if(col.isAvailable())
					count++;
			}
		}

		return count;
	}

	public void setRowType(int row, SeatType type, double price){
		
		checkRow(row);

		if(type == null)
			throw new IllegalArgumentException("SeatType cannot be null");

		for(int j=0; j<seats[row].length; j++){
			Seat colArr = seats[row][j];
			if(price!=0.0 && type!=null){
				colArr.setSeatType(type);
				colArr.setPrice(price);
			}
		}
	}

	public int getTotalSeatCount(){

		int countSeats = 0;

		for(int i=0; i<seats.length; i++){
			Seat[] row = seats[i];	
			for(int j=0; j<row.length; j++){
				Seat col = row[j];
					countSeats++;
			}
		}

		return countSeats;
	}

	public void displayVerbose(){
		
		System.out.println("=== " + screenName + " | Detailed Seats ===");

		for(int i=0; i<seats.length; i++){
			Seat[] row = seats[i];
			for(int j=0; j<row.length; j++){
				Seat col = row[j];

				System.out.print(col);
			}
			System.out.println();
		}

		System.out.println();
	}

	

	private static int[] buildDefaultRowLength(int arrayLength){
		int[] rowArr = new int[arrayLength];

		for(int i=0; i<arrayLength; i++){
			rowArr[i] = 10+i;
		}

		return rowArr;
	}

	public int getAvailableSeatCount(SeatType type){
		int counterr = 0;
		for(int i=0; i<seats.length; i++){
			Seat[] row = seats[i];
			for(int j=0; j<row.length; j++){
				Seat col = row[j];

				if(type == col.getSeatType() && type != null){
					counterr++;
				}
			}
		}

		return counterr;
	}

	public Seat getFirstAvailable(SeatType type){
		if(type == null){
			throw new IllegalArgumentException("Type Cannot be null.");
		}

		for(int i=0; i<seats.length; i++){
			Seat[] row = seats[i];
			for(int j=0; j<row.length; j++){
				Seat col = row[j];
	
				if(col.getSeatType() == type && col.isAvailable()){
					return col;
				}
					
			}
		}

		return null;
	}

	public int getRowLength(int row){
		checkRow(row);

		return seats[row].length;
	}

	private SeatType seatTypeFor(int row, int col){

		checkBounds(row, col);
		
		Seat s = getSeat(row, col);
		return s.getSeatType();
	}

	private double priceFor(SeatType type){
		switch(type){
			case REGULAR:
				return PRICE_REGULAR;
			case PREMIUM:
				return PRICE_PREMIUM;
			case VIP:
				return PRICE_VIP;
			case RECLINER:
				return PRICE_RECLINER;
			default :
				throw new IllegalArgumentException("Invalid Type");
				
		}
	}

	public int getRowCount(){
		return seats.length;
	}

	public Seat[] listAvailable(SeatType type){

		int total = 0;

		for(int i=0; i<seats.length; i++){
			Seat[] row = seats[i];

			for(int j=0; j<row.length; j++){
				Seat col = row[j];

				if(type!=null && type == col.getSeatType() && col.isAvailable()){
					total++;
				}
			}
		}

		int index = 0;
		
		Seat[] listOfAvailables = new Seat[total];

		for(int k=0; k<seats.length; k++){
			Seat[] rowArr = seats[k];

			for(int l=0; l<rowArr.length; l++){
				Seat colArr = rowArr[l];

				if(type!=null && type == colArr.getSeatType() && colArr.isAvailable()){
					listOfAvailables[index++] = colArr;
				}
			}
		}

		return listOfAvailables; 
	}

	public void materializeGrid(int i, int j, int length){
		
		int front_rows, middle_rows, penultimate_rows, last_rows;
		
		if(length%2==0){ // 10
			front_rows = length/2; // less than 3
			middle_rows = front_rows+1; // less than or equals to 4
			penultimate_rows = length - 1; // less than or equals to
			last_rows = length; // last row 
		}
		else{ // 11
			front_rows = (length+1)/2; // less than 6
			middle_rows = front_rows; // less than or equals to 6
			penultimate_rows = length-1; // less than or equals to 10
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

	public void displayLayout(){
		System.out.println("=== " + screenName + " | Layout ===");

		for(int r=0; r<seats.length; r++){
			StringBuilder line = new StringBuilder();

			for(int c=0; c<seats[r].length; c++){
				Seat s = seats[r][c];
				char mark = s.isAvailable()? 'A': 'X';
				line.append(String.format("[%s:%c] ", s.getId(), mark));
			}
			System.out.print(line.toString());
		}
			
		System.out.printf("Total: %d, Available: %d%n", getTotalSeatCount(), getAvailableSeatCount());
		System.out.println();
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