package buildingNim;

import helperMethods.MyMath;

import java.util.ArrayList;  

public class GrundyFinder {
	private StateDictionary dict;
	public GrundyFinder()
	{
		dict = new StateDictionary();
	}
	//No. of Stones in each pile, remaining Stones, total number of piles
	public int findGrundyOf(Integer[] stone,int remainingStones, int piles)
	{
		//check if computed
		Integer[] newstone = new Integer[stone.length];
		for (int k = 0; k<piles; k++)
		{
			newstone[k]=new Integer(stone[k].intValue());
		}
		
		newstone = MyMath.insertSortArray(newstone);
		
//		if (newstone[0].intValue() == 1 && newstone[0].intValue() == newstone[1].intValue() && newstone[2].intValue() == 2)
//		{
//			for (int k = 0;k<dict.states.size();k++){
//				for(int j = 0;j<piles;j++)
//				{
//					System.out.print(dict.states.get(k)[j].intValue());System.out.print(" ");					
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		int value = dict.valueOf(newstone);
		if (value != -1)
		{
			return value;
		}
		
		else{
			//if all stones placed
			if (remainingStones == 0)
			{
				int nimSum = MyMath.nimSum(newstone);				
				dict.push(newstone, nimSum);
				return nimSum;
			}
			else
			{
				ArrayList<Integer> grundPrev = new ArrayList<Integer>();
				//iteration
				
				newstone[0] = newstone[0] +1 ;
				Integer add = new Integer(findGrundyOf(newstone,remainingStones-1,piles));
				grundPrev.add(add);
				for (int k = 1; k<piles; k++)
				{
					newstone[k-1] = newstone[k-1] -1;
					newstone[k] = newstone[k] + 1;
					add = new Integer(findGrundyOf(newstone,remainingStones-1,piles));
					grundPrev.add(add);
				}
				newstone[piles-1] = newstone[piles-1]-1;

				int output = MyMath.mex(grundPrev.toArray(new Integer[0]), 1);
				dict.push(newstone, output);
				return output;
			}

		}
	}
	public int findGrundyOfSimple(Integer[] stone,int remainingStones, int piles)
	{
		//check if computed
		Integer[] newstone = new Integer[stone.length];
		for (int k = 0; k<piles; k++)
		{
			newstone[k]=new Integer(stone[k].intValue());
		}
		
		newstone = MyMath.insertSortArray(newstone);
			//if all stones placed
			if (remainingStones == 0)
			{
				int nimSum = MyMath.nimSum(newstone);
				return nimSum;
			}
			else
			{
				ArrayList<Integer> grundPrev = new ArrayList<Integer>();
				//iteration
				
				newstone[0] = newstone[0] +1 ;
				Integer add = new Integer(findGrundyOf(newstone,remainingStones-1,piles));
				grundPrev.add(add);
				for (int k = 1; k<piles; k++)
				{
					newstone[k-1] = newstone[k-1] -1;
					newstone[k] = newstone[k] + 1;
					add = new Integer(findGrundyOf(newstone,remainingStones-1,piles));
					grundPrev.add(add);
				}
				newstone[piles-1] = newstone[piles-1]-1;

				int output = MyMath.mex(grundPrev.toArray(new Integer[0]), 1);
				
				return output;
			}

		
	}

}

//dictionary of state
class StateDictionary{
	public ArrayList<Integer[]> states;
	public ArrayList<Integer> grundyNumber;
	public StateDictionary(){
		states = new ArrayList<Integer[]>();
		grundyNumber = new ArrayList<Integer>();

	}
	
	//push in a[]:stones of each pile and b:grundyNumber
	public void push(Integer[] a,int b){
		int sum = MyMath.sum(a);
		if (b!=0 && sum % 2 == 1){
			for (int k = 0;k<a.length;k++){
				System.out.print(a[k].intValue());System.out.print(" ");
			}
			System.out.println();
//			System.out.println(b);
//			System.out.println();
		}
		int pos = MyMath.posOfNew(states,a);
		
		Integer[] newa = new Integer[a.length];
		for (int i=0;i<a.length;i++){
			newa[i]=new Integer(a[i].intValue());
		}
		Integer newb = new Integer(b);
		states.add(pos,newa);
		grundyNumber.add(pos, newb);

	}
	
	//find a in the key and return value, return value of -1 indicates not in dictionary
	public int valueOf(Integer[] stone){
		int index = 0 ;
		if (states.size() == 0) return -1;
		int t = MyMath.compareTo(states.get(index), stone);
		index++;
		while(index < states.size() && t==1)
		{
			t = MyMath.compareTo(states.get(index), stone);
			index++;
		}
		index--;
		if(index >= states.size())
		{

			return -1;
		}
		else if (t == 0)
		{
			return grundyNumber.get(index);
		}
		else 
		{
			return -1;
		}
	}

	
}
