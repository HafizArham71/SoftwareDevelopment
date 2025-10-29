public class Block{



	// Attributes

	private static int DEFAULT_NUM_STREETS = 5;
	private Plot[][] plots;
	private String blockName;
	



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

		this.blockName = blockName;
		this.plots = new Plot[noOfStreets][];

		
		// Defining 2d Array
	
		for(int i=0; i<plots.length; i++){

			plots[i] = new Plot[rowLengths[i]];
		}


		// Initialize & Materialize Plots

		materializePlots();

	}



	// Methods

	public static int[] defaultRowLength(){

		int arr[] = new int[DEFAULT_NUM_STREETS];

		for(int i=0; i<arr.length; i++)

			arr[i] = 10+i;

		return arr;

	}

	public void materializePlots(){

		for(int i=0; i<plots.length; i++){

			for(int j=0; j<plots[i].length; j++){

				switch(i+1){

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

					case 5:

						plots[i][j] = new Plot(i+1, j+1, PlotType.COMM_OFFICE, ShapeType.RECTANGLE, new Shape(10, 20), true);

						break;


				}

			}

		}

	}



	@Override
	public String toString(){

		int index = 1;

		StringBuilder str = new StringBuilder();

		str.append("=== " + blockName + " Layout ===\n");

		for(Plot[] row: plots){

			str.append(String.format("Street-%d\n", index++));

			for(Plot col: row){

				str.append(col + " ");

			}

			str.append("\n\n");

		}

		return str.toString();

	}	

}


/*

A Block ( “Block A”) is backed by a jagged two-dimensional array of plots. Use a default of five streets whose lengths increase as 10, 11, 12, 13, 14 to ensure your code handles jagged rows. Materialize the entire grid at construction time. Assign plot types by street index so validation is easy: Street 1 → RES_5_MARLA (RECTANGLE), Street 2 → RES_10_MARLA (RECTANGLE), Street 3 → RES_1_KANAL (TRAPEZOID to vary shapes), Street 4 → COMM_SHOP (RECTANGLE near the market frontage), Street 5 → COMM_OFFICE (RECTANGLE). Sprinkle variety by marking every fifth plot on any street as PARKING. Within the residential streets (1–3), mark every fourth plot as a CornerPlot and compute area using the dual-frontage logic; the price automatically reflects the corner premium. Each plot’s ID must be synthesized from coordinates (1-based street index and a 3-digit plot number).

Every block must also include amenities separate from the plot grid: create one or two Parks and one Commercial Market. Model parks with a simple shape (usually RECTANGLE) and dimensions so their area can be printed in reports; store them in a Park[] with a logical size. Model the market as a single CommercialMarket object that internally manages a plain Shop[] ( 12–20 shops), each shop being a small rentable unit of type COMM_SHOP with its own ID and price. These amenities are not part of the plot grid and should not inflate residential/commercial plot counts; they are listed under the block’s amenity section in reports.

*/