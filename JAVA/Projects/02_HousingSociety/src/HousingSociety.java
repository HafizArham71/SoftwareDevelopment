public class HousingSociety{




	// Attributes

	private Block[] blocks;
	private static int DEFAULT_NUM_BLOCKS = 5;
	private String societyName;
	private int noOfBlocks;



	
	// Constructor

	public HousingSociety(){

		this("Default Society Name");

	}

	public HousingSociety(String societyName){

		this(societyName, DEFAULT_NUM_BLOCKS);

	}

	public HousingSociety(String societyName, int noOfBlocks){

		this.societyName = societyName;
		this.noOfBlocks = noOfBlocks;

		this.blocks = new Block[this.noOfBlocks];

		
		// Initializing Blocks

		for(int i=0; i<blocks.length; i++)

			blocks[i] = new Block("Block-" + (i+1));

	}




	// Methods

	public void preloadBlocks(){


		for(int i=0; i<blocks.length; i++){

			blocks[i] = new Block("Block-" + (i+1), 5, new int[]{10, 11, 12, 13, 14}, 2, "Market-" + (i+1), 20, PlotType.COMM_SHOP, ShapeType.RECTANGLE, new Shape(10, 20));

		}
		

	}

	public void addBlock(String blockName, int noOfStreets){

		if(blockName!=null && noOfStreets>0){

			Block[] updatedBlock = new Block[blocks.length+1];


			for(int i=0; i<blocks.length; i++)

				updatedBlock[i] = blocks[i];


			updatedBlock[blocks.length] = new Block(blockName, noOfStreets);

			blocks = updatedBlock;

		}
		

	}


	public void removeBlock(String blockName){

		if(blockName!=null){

			Block[] updatedBlock = new Block[blocks.length-1];

			for(int i=0; i<blocks.length; i++){
	
				if(blocks[i].getBlockName().equals(blockName)){

					for(int j=i; j<blocks.length-1; j++){

						blocks[j] = blocks[j+1];

					}

				}

			}	

			

			for(int k=0; k<updatedBlock.length; k++)

				updatedBlock[k] = blocks[k];

			
			blocks = updatedBlock;

		}
		

	}

	public Block findBlockByName(String blockName){

		if(blockName!=null){

			for(Block b: blocks){

				if(b.getBlockName().equals(blockName)){
				
					System.out.println(b.getBlockName().toUpperCase() + "\n");
					
					return b;

				}
	
			}

		}

		return null;

	}

	public Block findBlockByIndex(int index){

		if(index >= 0 && index < blocks.length){

			System.out.println("BLOCK-" + (index+1) + "\n");

			return blocks[index];

		}

		return null;

	}

	public boolean bookPlot(String blockName, String plotId){

		Block block = findBlockByName(blockName);

		if(block!=null && block.bookPlot(plotId) && plotId!=null)

			return true;

		return false;

	}

	public boolean cancelPlot(String blockName, String plotId){

		Block block = findBlockByName(blockName);

		if(block!=null && block.cancelPlot(plotId) && plotId!=null)

			return true;

		return false;

	}

	public int totalPlots(PlotType plotType){

		int totalPlots = 0;

		for(Block b: blocks){

			totalPlots += b.totalPlots(plotType);

		}

		return totalPlots;

	}

	public int availablePlots(PlotType plotType){

		int availablePlots = 0;

		for(Block b: blocks){

			availablePlots += b.availablePlots(plotType);

		}

		return availablePlots;

	}

	public int totalPlots(){

		int totalPlots = 0;

		for(Block b: blocks){

			totalPlots += b.totalPlots();

		}

		return totalPlots;

	}

	public int availablePlots(){

		int availablePlots = 0;

		for(Block b: blocks){

			availablePlots += b.availablePlots();

		}

		return availablePlots;

	}


	public void printReport(){

		int block = 1;

		for(Block b: blocks){

			System.out.println("=== Block-" + (block++) + " ===\n");

			System.out.println("- BLOCK SUMMARY\n");

			System.out.printf("  [ Name: %s, Total Plots: %d, Available Plots: %d ]\n\n", b.getBlockName(), b.totalPlots(), b.availablePlots());

			System.out.println("- STREET LAYOUT\n");

			b.compactStreetLayout();

			System.out.println("\n");
	
			b.detailedPlotsList();

		}

	}



	@Override
	public String toString(){

		StringBuilder str = new StringBuilder();

		for(Block b: blocks){

			str.append(String.format("=== %s ===\n\n", b.getBlockName().toUpperCase()));
			str.append(b + "\n");

		}

		return str.toString();
	}
}