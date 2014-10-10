package si.multistar444.rubiksCube.core;

/**
 * A simple Rubik's cube simulator.
 * 
 * @author multistar444
 * 
 */
public final class RubiksCube
{
	/**
	 * This is the front side of the Rubik's cube
	 */
	private int[][] F_side; // 1
	
	/**
	 * This is the back side of the Rubik's cube
	 */
	private int[][] B_side; // 2
	
	/**
	 * This is the left side of the Rubik's cube
	 */
	private int[][] L_side; // 3
	
	/**
	 * This is the right side of the Rubik's cube
	 */
	private int[][] R_side; // 4
	
	/**
	 * This is the up side of the Rubik's cube
	 */
	private int[][] U_side; // 5
	
	/**
	 * This is the down side of the Rubik's cube
	 */
	private int[][] D_side; // 6
	
	/**
	 * Constructor
	 */
	public RubiksCube()
	{
		F_side = colorSide(Color.WHITE);
		B_side = colorSide(Color.YELLOW);
		R_side = colorSide(Color.GREEN);
		L_side = colorSide(Color.BLUE);
		U_side = colorSide(Color.RED);
		D_side = colorSide(Color.ORANGE);
	}
	
	/**
	 * Rotates the cube clockwise on the X axis.
	 */
	public void rotatex()
	{
		int[][] tmp = U_side;
		U_side = F_side;
		F_side = D_side;
		D_side = B_side;
		B_side = tmp;
		spin(4);
		spin_(3);
	}
	
	/**
	 * Rotates the cube counter-clockwise on the X axis.
	 */
	public void rotatex_()
	{
		int[][] tmp = U_side;
		U_side = B_side;
		B_side = D_side;
		D_side = F_side;
		F_side = tmp;
		spin_(4);
		spin(3);
	}
	
	/**
	 * Rotates the cube clockwise on the Y axis.
	 */
	public void rotatey()
	{
		int[][] tmp = F_side;
		F_side = R_side;
		R_side = B_side;
		B_side = L_side;
		L_side = tmp;
		spin(5);
		spin_(6);
	}
	
	/**
	 * Rotates the cube counter-clockwise on the Y axis.
	 */
	public void rotatey_()
	{
		int[][] tmp = F_side;
		F_side = L_side;
		L_side = B_side;
		B_side = R_side;
		R_side = tmp;
		spin_(5);
		spin(6);
	}
	
	/**
	 * Rotates the cube clockwise on the Z axis.
	 */
	public void rotatez()
	{
		int[][] tmp = U_side;
		U_side = L_side;
		L_side = D_side;
		D_side = R_side;
		R_side = tmp;
		spin(1);
		spin_(2);
	}
	
	/**
	 * Rotates the cube counter-clockwise on the Z axis.
	 */
	public void rotatez_()
	{
		int[][] tmp = U_side;
		U_side = R_side;
		R_side = D_side;
		D_side = L_side;
		L_side = tmp;
		spin_(1);
		spin(2);
	}
	
	/**
	 * @return the front side of the cube.
	 */
	public int[][] getFrontSide()
	{
		return F_side;
	}
	
	/**
	 * Shuffles the cube.
	 */
	public void shuffle()
	{
		//TODO implement shuffle function
	}
	
	/**
	 * Spins the specified side clockwise.
	 * @param sideID ID of the side.
	 */
	private void spin(int sideID)
	{
		int[][] side = getSideByID(sideID);
		
		int tmp = side[0][0];
		side[0][0] = side[2][0];
		side[2][0] = side[2][2];
		side[2][2] = side[0][2];
		side[0][2] = tmp;
		
		tmp = side[0][1];
		side[0][1] = side[1][0];
		side[1][0] = side[2][1];
		side[2][1] = side[1][2];
		side[1][2] = tmp;
	}
	
	/**
	 * Spins the specified side counter-clockwise.
	 * @param sideID ID of the side.
	 */
	private void spin_(int sideID)
	{
		int[][] side = getSideByID(sideID);
		
		int tmp = side[0][0];
		side[0][0] = side[0][2];
		side[0][2] = side[2][2];
		side[2][2] = side[2][0];
		side[2][0] = tmp;
		
		tmp = side[0][1];
		side[0][1] = side[1][2];
		side[1][2] = side[2][1];
		side[2][1] = side[1][0];
		side[1][0] = tmp;
	}
	
	/**
	 * @param sideID ID of the side.
	 * @return the side with specified ID.
	 */
	private int[][] getSideByID(int sideID)
	{
		switch (sideID)
		{
			case 1 :
				return F_side;
			case 2 :
				return B_side;
			case 3 :
				return L_side;
			case 4 :
				return R_side;
			case 5 :
				return U_side;
			case 6 :
				return D_side;
		}
		return null;
	}
	
	/**
	 * @param color The color to be used.
	 * @return colored side.
	 */
	private int[][] colorSide(Color color)
	{
		int[][] newSide = new int[3][3];
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				newSide[x][y] = color.getColorCode();
			}
		}
		return newSide;
	}
	
//	Static stuff begins here
	
	/**
	 * @return Shuffled Rubik's cube.
	 */
	public static RubiksCube getShuffledCube()
	{
		RubiksCube rubiksCube = new RubiksCube();
		rubiksCube.shuffle();
		return rubiksCube;
	}
	
	/**
	 * Used to enumerate colors of the cube.
	 * 
	 * @author multistar444
	 *
	 */
	public static enum Color
	{
		/**
		 * White color
		 */
		WHITE(1),
		
		/**
		 * Yellow color
		 */
		YELLOW(2),
		
		/**
		 * Green color
		 */
		GREEN(3),
		
		/**
		 * Blue color
		 */
		BLUE(4),
		
		/**
		 * Red color
		 */
		RED(5),
		
		/**
		 * Orange color
		 */
		ORANGE(6);
		
		/**
		 * ID of the color.
		 */
		private int id;
		
		/**
		 * Constructor
		 * @param id ID to be used
		 */
		Color(int id)
		{
			this.id = id;
		}
		
		/**
		 * @return Returns the id of the color.
		 */
		public int getColorCode()
		{
			return id;
		}
		
		/**
		 * Used for CLI mode
		 * @return Returns the character that represents the color
		 */
		public char getColorChar()
		{
			switch (id)
			{
				case 1 :
					return 'W';
				case 2 :
					return 'Y';
				case 3 :
					return 'G';
				case 4 :
					return 'B';
				case 5 :
					return 'R';
				case 6 :
					return 'O';
			}
			return ' ';
		}
		
		/**
		 * @param id Color id
		 * @return The actual color
		 */
		public static Color getColorByID(int id)
		{
			if(WHITE.id == id) return WHITE;
			if(YELLOW.id == id) return YELLOW;
			if(GREEN.id == id) return GREEN;
			if(BLUE.id == id) return BLUE;
			if(RED.id == id) return RED;
			if(ORANGE.id == id) return ORANGE;
			return null;
		}
	}
}
