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

		this("Default Screen");

	}

	public Screen(String screenName){

		this(screenName, defaultRowLengthArr());

	}

	public Screen(String screenName, int[] rowsLength){

		this.screenName = screenName;

		
		// Defining length of array

		seats = new Seat[rowsLength.length][];

		for(int i=0; i<seats.length; i++){

			seats[i] = new Seat[rowsLength[i]];
			
		}

		
		// Initializing Array

		for(int i=0; i<seats.length; i++){

			for(int j=0; j<seats[i].length; j++)
				
				seats[i][j] = new Seat(i, j);

		}
		
		materializeGrid();

	}



	
	// Method

	public void displayLayout(){

		System.out.println("\n=== " + screenName + " Layout ===");

		for(int i=0; i<seats.length; i++){

			for(int j=0; j<seats[i].length; j++){

				System.out.printf("[%s : %c] ", seats[i][j].getId(), seats[i][j].isAvailable()? 'A': 'X');
				
			}

			System.out.println();

		}

		System.out.println("Total: " + getTotalSeatCount() + ", Available: " + getAvailableSeatCount());

	}

	public Seat[] listAvailable(SeatType seatType){

		Seat[] listAvailable;

		int index = 0;

		for(Seat[] row: seats){

			for(Seat col: row){

				if(col.getSeatType().equals(seatType) && col.isAvailable())

					index++;

			}

		}

		listAvailable = new Seat[index];

		int counter = 0;

		for(int i=0; i<seats.length; i++){

			for(int j=0; j<seats[i].length; j++){

				if(seats[i][j].getSeatType().equals(seatType) && seats[i][j].isAvailable())

					listAvailable[counter++] = seats[i][j];

			}

		}

		return listAvailable;
		

	}

	public int getRowCount(){

		return seats.length;

	}

	private double priceFor(SeatType seatType){

		if(seatType.equals(SeatType.REGULAR))
			
			return PRICE_REGULAR;

		else if(seatType.equals(SeatType.PREMIUM))
			
			return PRICE_PREMIUM;

		else if(seatType.equals(SeatType.VIP))
			
			return PRICE_VIP;

		else
			
			return PRICE_RECLINER;

	}

	private SeatType seatTypeFor(int row, int col){

		checkBounds(row, col);

		return seats[row][col].getSeatType();

	}

	public int getRowLength(int row){

		checkRow(row);

		return seats[row].length;

	}

	public boolean cancel(String seatId){

		if(seatId!=null){

			for(Seat[] row: seats){

				for(Seat col: row){

					if(col.getId().equals(seatId) && col.cancelBooking())
						
						return true;

				}

			}

		}

		return false;

	}

	public Seat findFirstAvailable(SeatType seatType){

		for(Seat[] row: seats){

			for(Seat col: row){

				if(col.isAvailable() && col.getSeatType().equals(seatType))
					
					return col;

			}

		}

		return null;

	}

	public int getAvailableSeatCount(SeatType seatType){

		int availableSeatCount = 0;

		for(Seat[] row: seats){

			for(Seat col: row){

				if(col.getSeatType().equals(seatType) && col.isAvailable())

					availableSeatCount++;

			}

		}

		return availableSeatCount;

	}


	public int getTotalSeatCount(SeatType seatType){

		int totalSeatCount = 0;

		for(Seat[] row: seats){

			for(Seat col: row){

				if(col.getSeatType().equals(seatType))

					totalSeatCount++;

			}

		}

		return totalSeatCount;

	}


	public void materializeGrid(){

		int front_rows, middle_rows, penultimate_rows, last_rows;

		penultimate_rows = seats.length;	// less than
		last_rows = seats.length + 1;		// less than

		if(seats.length%2 == 0){

			front_rows = (seats.length/2)+1;	// less than
			middle_rows = front_rows + 1;		// less than
		}

		else{
		
			front_rows = (seats.length+1)/2;	// less than
			middle_rows = front_rows + 1;		// less than

		}

		for(int i=0; i<seats.length; i++){
		
			for(int j=0; j<seats[i].length; j++){

				if((i+1)<front_rows)
	
					seats[i][j] = new Seat(i+1, j+1, SeatType.REGULAR, PRICE_REGULAR);
				else if((i+1)<middle_rows)

					seats[i][j] = new Seat(i+1, j+1, SeatType.PREMIUM, PRICE_PREMIUM);
				else if((i+1)<penultimate_rows)

					seats[i][j] = new Seat(i+1, j+1, SeatType.VIP, PRICE_VIP);
				else

					seats[i][j] = new Seat(i+1, j+1, SeatType.RECLINER, PRICE_RECLINER);
	
			}
				
		}

	}

	public void displayVerbose(){

		System.out.println("=== " + screenName + " Detailed Seats ===\n");

		for(Seat[] row: seats){

			for(Seat col: row){

				System.out.print(col);

			}
		
			System.out.println();

		}

		System.out.println();

	}

	public int getTotalSeatCount(){

		int totalSeats = 0;

		for(Seat[] row: seats){

			for(Seat col: row)
				
				totalSeats++;

		}

		return totalSeats;

	}

	public boolean book(int row, int col){

		checkBounds(row, col);

		if(!seats[row][col].bookSeat())
			return false;

		seats[row][col].setAvailable(false);
		return true;

	}

	public Seat getSeat(int row, int col){

		checkBounds(row, col);

		return seats[row][col];
	
	}

	
	public void setRowType(int row, SeatType seatType, double price){

		checkRow(row);

		for(int col=0; col<seats[row].length; col++){

			seats[row][col].setSeatType(seatType);
			seats[row][col].setPrice(price);

		}

	}

	public int getAvailableSeatCount(){

		int availableSeatsCount = 0;

		for(Seat[] row: seats){

			for(Seat col: row){

				if(col.isAvailable())
					
					availableSeatsCount++;

			}

		}

		return availableSeatsCount;

	}

	public Seat getSeat(String seatId){

		if(seatId!=null){

			for(Seat[] row: seats){

				for(Seat col: row){

					if(col.getId().equals(seatId))
						
						return col;

				}
	
			}

			return null;

		} 

		return null;
			

	}

	public String getScreenName(){

		return screenName;

	}

	private void checkRow(int row){

		if(row < 0 || row >= seats.length)
			throw new IndexOutOfBoundsException("Row index out of bounds for row: " + row);

	}

	public boolean cancel(int row, int col){

		checkBounds(row, col);

		if(seats[row][col].isAvailable())
			return false;
		
		seats[row][col].setAvailable(true);
		return true;

	}

	public boolean book(String id){

		if(id!=null){

			for(Seat[] row: seats){

				for(Seat col: row){

					if(col.getId().equals(id) && col.isAvailable()){
		
						col.setAvailable(false);
						return true;

					}
						

				}
			}

		}

		return false;

	}

	
	private void checkBounds(int row, int col){

		if(row < 0 || row >= seats.length)
			throw new IndexOutOfBoundsException("Row index out of bounds for row: " + row);

		if(col < 0 || col >= seats[row].length)
			throw new IndexOutOfBoundsException("Column index out of bounds for column: " + col);

	}

	private static int[] defaultRowLengthArr(){

		int[] rowsLength = new int[DEFAULT_NUM_ROWS];

		for(int i=0; i<DEFAULT_NUM_ROWS; i++){

			rowsLength[i] = 10+i;

		}

		return rowsLength;

	}


	@Override
	public String toString(){

		StringBuilder str = new StringBuilder();

		String line = String.format("=== %s Layout ===\n", screenName);

		str.append(line);

		for(Seat[] row: seats){

			for(Seat col: row){

				str.append(col + " ");
	
			}

			str.append("\n");

		}

		str.append(String.format("Total: %d, Available: %d", getTotalSeatCount(), getAvailableSeatCount()));


		return str.toString();

	}

}