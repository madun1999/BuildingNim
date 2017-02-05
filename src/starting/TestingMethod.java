package starting;
import buildingNim.GrundyCountDown;
import buildingNim.GrundyFinder;

import java.util.Scanner;
import starting.TestingMethod;
public class TestingMethod {

	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		input = new Scanner(System.in);
		GrundyCountDown finder = new GrundyCountDown();
		System.out.println("Enter the number. Must be greater than 1.");
		int m = input.nextInt();
		for (int i = 2; i<=m;i++)
		{
			int out = finder.findGrundyOf(i);
			if (out == 0)
			{
			System.out.print("Number:");
			System.out.print(i);
			System.out.print("\t GrundyNumber:");
			System.out.println(out);
			}
		}
		System.out.println("Type number greater than 1 to continue, Type 0 to exit");
		m = input.nextInt();
		while (m>1)
		{
			int out = finder.findGrundyOf(m);
			System.out.print("Number:");
			System.out.print(m);
			System.out.print("\t GrundyNumber:");
			System.out.print(out);
			System.out.print("\t\tPlayer ");System.out.print( out==0 ?"2 ":"1 ");System.out.println("wins.");
			System.out.println("Type number greater than 1 to continue, Type 0 to exit");
			m = input.nextInt();
		}
	}
//		System.out.println("Enter the number of stones. Must be positive.");
//		int m=input.nextInt();//输入一个整数
//		System.out.println("Enter the number of piles. Must be positive");
//		int n = input.nextInt();
////		Integer[] stones = {Integer.valueOf(0), Integer.valueOf(1)};
////		System.out.println(MyMath.mex(stones, 0));
//		Integer[] stone = new Integer[n];	
//		for (int i = 0; i<=n-1; i++)
//		{
//			stone[i] = new Integer(0);
//		}
////		for (int i = 2; i<=m;i++)
////		{
//			finder = new GrundyFinder();
//			System.out.println("States that player 1 should avoid giving to player 2:");
//			int out = finder.findGrundyOf(stone, m, n);
////			System.out.println();
//			System.out.print("Grundy number:");
//			System.out.println(out);
//			System.out.print("Player ");System.out.print( out==0 ?"2 ":"1 ");System.out.println("wins.");
////		}
		
	}

