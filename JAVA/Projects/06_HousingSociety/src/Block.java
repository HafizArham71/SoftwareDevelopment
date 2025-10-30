public class Block{



	// Attributes

	private static final int DEFAULT_NUM_STREETS = 5;
	private static final int DEFAULT_NUM_PARKS = 2;
	private CommercialMarket commercialMarket;

	private Plot[][] plots;
	private Park[] parks;
	private String blockName;
	private ShapeType shapeType;
	



	// Constructors

	public Block(){

		this("Default Block");

	}

	public Block(String blockName){

		this(blockName, DEFAULT_NUM_STREETS);

	}

	public Block(String blockName, int noOfStreets){

		this(blockName, noOfStreets, defaultRowLength());

	}

	public Block(String blockName, int noOfStreets, int[] rowLengths){

		this(blockName, noOfStreets, rowLengths, DEFAULT_NUM_PARKS);

	}

	// String marketName, int noOfShops, PlotType plotType, ShapeType shapeType, Shape shape

	public Block(String blockName, int noOfStreets, int[] rowLengths, int noOfParks){

		this(blockName, noOfStreets, rowLengths, noOfParks, "MarketName");

	}

	public Block(String blockName, int noOfStreets, int[] rowLengths, int noOfParks, String marketName){

		this(blockName, noOfStreets, rowLengths, noOfParks, marketName, 18);

	}

	public Block(String blockName, int noOfStreets, int[] rowLengths, int noOfParks, String marketName, int noOfShops){

		this(blockName, noOfStreets, rowLengths, noOfParks, marketName, noOfShops, PlotType.COMM_SHOP);

	}

	public Block(String blockName, int noOfStreets, int[] rowLengths, int noOfParks, String marketName, int noOfShops, PlotType plotType){

		this(blockName, noOfStreets, rowLengths, noOfParks, marketName, noOfShops, plotType, ShapeType.RECTANGLE);

	}

	public Block(String blockName, int noOfStreets, int[] rowLengths, int noOfParks, String marketName, int noOfShops, PlotType plotType, ShapeType shapeType){

		this(blockName, noOfStreets, rowLengths, noOfParks, marketName, noOfShops, plotType, shapeType, new Shape(10, 20));

	}

	public Block(String blockName, int noOfStreets, int[] rowLengths, int noOfParks, String marketName, int noOfShops, PlotType plotType, ShapeType shapeType, Shape shape){

		this.blockName = blockName;
		this.plots = new Plot[noOfStreets][];
		this.parks = new Park[noOfParks];

		
		// Defining 2d Array for block plots
	
		for(int i=0; i<noOfStreets; i++){

			plots[i] = new Plot[rowLengths[i]];
		}


		// Initialize & Materialize Plots

		materializePlots(marketName, noOfShops, plotType, shapeType, shape);

	}


	// Methods

	public static int[] defaultRowLength(){

		int arr[] = new int[DEFAULT_NUM_STREETS];

		for(int i=0; i<arr.length; i++)

			arr[i] = 10+i;

		return arr;

	}

	public void materializePlots(String marketName, int noOfShops, PlotType plotType, ShapeType shapeType, Shape shape){

		for(int i=0; i<plots.length; i++){

			for(int j=0; j<plots[i].length; j++){

				switch((i+1)%5){

					case 1:

						if((j+1)%5 == 0)
							
							plots[i][j] = new Plot(i+1, j+1, PlotType.PARKING, ShapeType.RECTANGLE, new Shape(10, 20), true);

						else if((j+1)%4 == 0)

							plots[i][j] = new CornerPlot(i+1, j+1, PlotType.RES_5_MARLA, ShapeType.L_SHAPE, new Shape(10, 20), true, 50);

						else

							plots[i][j] = new Plot(i+1, j+1, PlotType.RES_5_MARLA, ShapeType.RECTANGLE, new Shape(10, 20), true);

						break;

					case 2:

						if((j+1)%4 == 0)

							plots[i][j] = new CornerPlot(i+1, j+1, PlotType.RES_10_MARLA, ShapeType.L_SHAPE, new Shape(10, 20), true, 50);

						else
	
							plots[i][j] = new Plot(i+1, j+1, PlotType.RES_10_MARLA, ShapeType.RECTANGLE, new Shape(10, 20), true);

						break;

					case 3:

						if((j+1)%4 == 0)

							plots[i][j] = new CornerPlot(i+1, j+1, PlotType.RES_1_KANAL, ShapeType.L_SHAPE, new Shape(10, 20), true, 50);

						else

							plots[i][j] = new Plot(i+1, j+1, PlotType.RES_1_KANAL, ShapeType.TRAPEZOID, new Shape(10, 20, 30), true);

						break;

					case 4:

						plots[i][j] = new Plot(i+1, j+1, PlotType.COMM_SHOP, ShapeType.RECTANGLE, new Shape(10, 20), true);

						break;

					case 0:

						plots[i][j] = new Plot(i+1, j+1, PlotType.COMM_OFFICE, ShapeType.RECTANGLE, new Shape(10, 20), true);

						break;


				}

			}

		}


		for(int i=0; i<parks.length; i++)
		
			parks[i] = new Park(i+1, "Park-" + (i+1), ShapeType.RECTANGLE, new Shape(10, 20), PlotType.PARKING);

		commercialMarket = new CommercialMarket(marketName, noOfShops, plotType, shapeType, shape);

	}

	public String getBlockName(){

		return blockName;

	}

	public boolean bookPlot(String id){

		for(Plot[] row: plots){

			for(Plot col: row){

				if(col.getId().equals(id) && col.bookPlot()){

					return true;

				}

			}

		}

		return false;

	}

	public boolean cancelPlot(String id){

		for(Plot[] row: plots){

			for(Plot col: row){

				if(col.getId().equals(id) && col.cancelPlotBooking()){

					return true;

				}

			}

		}

		return false;

	}

	public int totalPlots(PlotType plotType){

		int totalPlots = 0;

		for(Plot[] row: plots){

			for(Plot col: row){

				if(col.getPlotType().equals(plotType))
					
					totalPlots++;

			}

		}

		return totalPlots;

	}

	public int availablePlots(PlotType plotType){

		int availablePlots = 0;

		for(Plot[] row: plots){

			for(Plot col: row){

				if(col.getPlotType().equals(plotType) && col.isAvailable())
					
					availablePlots++;

			}

		}

		return availablePlots;

	}

	public int totalPlots(){

		int totalPlots = 0;

		for(Plot[] row: plots){

			for(Plot col: row){
		
				totalPlots++;

			}

		}

		return totalPlots;

	}

	public int availablePlots(){

		int availablePlots = 0;

		for(Plot[] row: plots){

			for(Plot col: row){

				if(col.isAvailable())
					
					availablePlots++;

			}

		}

		return availablePlots;

	}

	public void compactStreetLayout(){

		for(Plot[] row: plots){

			for(Plot col: row){

				System.out.print(String.format("  [%s, '%c'],", col.getId(), col.isAvailable()? 'A': 'X'));

			}

			System.out.println();

		}

	}

	public void detailedPlotsList(){

		// Plots


		int index = 1;

		for(Plot[] row: plots){

			System.out.println(" > STREET-" + (index++));

			for(Plot col: row){

				System.out.println("   " + col);

			}

			System.out.println();

		}

		
		// Anemities

		System.out.println("- ANEMITIES");
		
		
		// Parks

		System.out.println("\n > PARKS");

		for(Park p: parks)

			System.out.println("   " + p);

		// Commercial Market

		System.out.println("\n > MARKET");

		System.out.println(commercialMarket);
	}



	@Override
	public String toString(){

		int index = 1;

		StringBuilder str = new StringBuilder();

		str.append("- STREETS LAYOUT \n\n");

		for(Plot[] row: plots){

			str.append(String.format(" > Street-%d\n", index++));

			for(Plot col: row){

				str.append("   " + col + "\n");

			}

			str.append("\n"); 

		}

		index = 1;

		str.append(String.format("- ANEMITIES \n\n"));

		str.append(" > Parks \n");

		for(Park p: parks)

			str.append("   " + p + "\n");

		
		str.append(commercialMarket);
		

		return str.toString();


	}	

}


/*

A Block ( “Block A”) is backed by a jagged two-dimensional array of plots. Use a default of five streets whose lengths increase as 10, 11, 12, 13, 14 to ensure your code handles jagged rows. Materialize the entire grid at construction time. Assign plot types by street index so validation is easy: Street 1 → RES_5_MARLA (RECTANGLE), Street 2 → RES_10_MARLA (RECTANGLE), Street 3 → RES_1_KANAL (TRAPEZOID to vary shapes), Street 4 → COMM_SHOP (RECTANGLE near the market frontage), Street 5 → COMM_OFFICE (RECTANGLE). Sprinkle variety by marking every fifth plot on any street as PARKING. Within the residential streets (1–3), mark every fourth plot as a CornerPlot and compute area using the dual-frontage logic; the price automatically reflects the corner premium. Each plot’s ID must be synthesized from coordinates (1-based street index and a 3-digit plot number).

Every block must also include amenities separate from the plot grid: create one or two Parks and one Commercial Market. Model parks with a simple shape (usually RECTANGLE) and dimensions so their area can be printed in reports; store them in a Park[] with a logical size. Model the market as a single CommercialMarket object that internally manages a plain Shop[] ( 12–20 shops), each shop being a small rentable unit of type COMM_SHOP with its own ID and price. These amenities are not part of the plot grid and should not inflate residential/commercial plot counts; they are listed under the block’s amenity section in reports.

*/