package si.multistar444.rubiksCube.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import si.multistar444.rubiksCube.core.RubiksCube;
import si.multistar444.rubiksCube.core.RubiksCube.Color;

public class CliRubiksCube
{
	/**
	 * The main method
	 * @param args arguments from the command line.
	 * @throws IOException In case alliens invade earth.
	 */
	public static void main(String[] args) throws IOException
	{
		RubiksCube cube = new RubiksCube();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int in;
		while((in = input.read()) != -1)
		{
			String str = new String(new char[] {(char)in});
			
			if(str.equalsIgnoreCase("w")) cube.rotatex_();
			if(str.equalsIgnoreCase("s")) cube.rotatex();
			if(str.equalsIgnoreCase("a")) cube.rotatey_();
			if(str.equalsIgnoreCase("d")) cube.rotatey();
			
			int[][] s = cube.getFrontSide();
			Runtime.getRuntime().exec("cls");
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					System.out.print(Color.getColorByID(s[i][j]).getColorChar());
				}
				System.out.println();
			}
		}
	}

}
