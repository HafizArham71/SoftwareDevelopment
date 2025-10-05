public class MyArrays{

	public MyArrays(){

		String[][] myArr; // Declarartion
		myArr = new String[3][3]; // 3 Rows and 3 Columns

		// String[][] myArr1 = new String[3][3]; Or directly this method

		// Method_01
		myArr[0][0] = "Arham";
		myArr[0][1] = "Ahmad";
		myArr[0][2] = "Hamza";

		myArr[1][0] = "Hanzla";
		myArr[1][1] = "Ali";
		myArr[1][2] = "Abdullah";

		myArr[2][0] = "Hammad";
		myArr[2][1] = "Dawood";
		myArr[2][2] = "Zulfaqar";

		// Method_02
		String[][] myArr1 = new String[][] {
			{"Arham", "Ahmad", "Hamza"},
			{"Hanzla", "Ali", "Abdullah"},
			{"Hammad", "Dawood", "Zulfaqar"}
		};

		System.out.println(myArr1.length + "\n" + myArr[0].length);

		for(int i=0; i<myArr.length; i++){
			for(int j=0; j<myArr[i].length; j++){
				System.out.print(myArr[i][j] + ", ");
			}
			System.out.println();
		}
	}
}