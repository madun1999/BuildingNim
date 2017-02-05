package buildingNim;
import helperMethods.MyMath;
import java.util.HashMap;  
import java.util.ArrayList;
public class GrundyCountDown {

		private HashMap<Integer,Integer> dict;
		public GrundyCountDown()
		{
			dict = new HashMap<Integer,Integer>();
			dict.put(2, 1);
		}
		//No. of Stones in each pile, remaining Stones, total number of piles
		public int findGrundyOf(Integer in)
		{
			//check if computed
			
			if(dict.containsKey(in))
			{
				return dict.get(in);
			}
			ArrayList<Integer> grundPrev = new ArrayList<Integer>();
					//iteration
			grundPrev.add(findGrundyOf(in-1));
			for (int i = 2; i<=in/2; i++)
			{
				if (in % i ==0)
				{
					grundPrev.add(findGrundyOf(i));
				}
			}
			int output = MyMath.mex(grundPrev.toArray(new Integer[0]), 1);
			dict.put(in, output);
			return output;
		}
	
		


}
