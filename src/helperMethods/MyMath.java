package helperMethods;

import java.util.ArrayList;

public class MyMath {
	
	
	//isPrime function for both  long and int
	public static boolean isPrime(long num)
	{
		if (num <= 1){return false;}
		else if(num <= 3){return true;}
		else if((num & 1) == 0){return false;}
		else if(num % 3 == 0){return false;}
		else if(num <= 19){return true;}
		else
		{
			int t = 5;
			int max = (int) Math.sqrt(num);
			while (t<=max)
			{
				if (num % t == 0 || num % (t+2) == 0){return false;} 
				t+=6;
			}
		}
		return true;
	}
	public static boolean isPrime(int num)
	{
		if (num <= 1){return false;}
		else if(num <= 3){return true;}
		else if((num & 1) == 0){return false;}
		else if(num % 3 == 0){return false;}
		else if(num <= 19){return true;}
		else
		{
			int t = 5;
			int max = (int) Math.floor(Math.sqrt(num));
			while (t<=max)
			{
				if (num % t == 0 || num % (t+2) == 0){return false;} 
				t+=6;
			}
		}
		return true;
	}
	
	//find index of maximum or minimum of an array of ints or doubles
	public static int maximum(int[] num)
	{
		int max = 0;
		for (int i = 1 ; i < num.length ; i++)
		{
			if (num[i]>num[max]) {max = i;}
		}
		return max;
	}
	public static double maximum(double[] num)
	{
		int max = 0;
		for (int i = 1 ; i < num.length ; i++)
		{
			if (num[i]>num[max]) {max = i;}
		}
		return max;
	}
	public static int minimum(int[] num)
	{
		int min = 0;
		for (int i = 1 ; i < num.length ; i++)
		{
			if (num[i]<num[min]) {min = i;}
		}
		return min;
	}
	public static double minimum(double[] num)
	{
		int min = 0;
		for (int i = 1 ; i < num.length ; i++)
		{
			if (num[i]<num[min]) {min = i;}
		}
		return min;
	}
	
	//find sum of an array of ints or doubles
	public static int sum(int[] num){
		int sum = 0;
		for(int a :num)
		{
			sum+=a;
		}
		return sum;
	}
	public static double sum(double[] num){
		double sum = 0;
		for(double a :num)
		{
			sum+=a;
		}
		return sum;
	}

	//find sum of an column of a 2D array
	public static int sumOfColumn(int[][] num, int index){
		int sum = 0;
		for (int a = 0; a<num.length;a++)
		{
			sum+=num[a][index];
		}
		return sum;
	}
	public static double sumOfColumn(double[][] num, int index){
		double sum = 0;
		for (int a = 0; a<num.length;a++)
		{
			sum+=num[a][index];
		}
		return sum;
	}
	
	//find the smallest natural number not in the array
	public static int mex(Integer[] num, int sortMethod){  // sortMethod 0:sorted, 1: Insert sort 
		if (sortMethod == 1){
			num = insertSortArrayb(num);
		}
		int k=0;//try mex value
		int q=0;//index in array
		while (k>=num[q]){
			if (k == num[q])
			{
				k++;
			}
			else
			{
				q++;
			}
			if (q>=num.length)
			{
				return k;
			}
		}
		return k;
	}
	
	//Sort Method 1: insertSort
	public static Integer[] insertSortArray(Integer[] num) 
	{ 
		int n=num.length;
		for(int i=1;i<n;i++)//循环从第二个数组元素开始，因为arr[0]作为最初已排序部分 
		{ 
		    int temp=num[i];//temp标记为未排序第一个元素 
		    int j=i-1; 
			while (j>=0 && num[j]<temp)/*将temp与已排序元素从小到大比较，寻找temp应插入的位置*/ 
			{ 
			    num[j+1]=num[j]; 
			    j--; 
			} 
			num[j+1]=temp; 
		} 
		return num;
	} 
	public static Integer[] insertSortArrayb(Integer[] num) 
	{ 
		int n=num.length;
		for(int i=1;i<n;i++)//循环从第二个数组元素开始，因为arr[0]作为最初已排序部分 
		{ 
		    int temp=num[i];//temp标记为未排序第一个元素 
		    int j=i-1; 
			while (j>=0 && num[j]>temp)/*将temp与已排序元素从小到大比较，寻找temp应插入的位置*/ 
			{ 
			    num[j+1]=num[j]; 
			    j--; 
			} 
			num[j+1]=temp; 
		} 
		return num;
	}
	public static int sum(Integer[] num)
	{
		int sum = 0;
		for (int i : num)
		{
			sum+=i;
		}
		return sum;
	}
	//find the position of a array in a arraylist of arrays
	public static int posOfNew(ArrayList<Integer[]> states, Integer[] targ){
		int index=0;
		while (index < states.size() && compareTo(states.get(index), targ)==1)
		{
			index++;
		}
		return index;
	}
	
	//compare int arrays 0:arr1=arr2,1:arr1>arr2,2:arr1<arr2,longer=larger,first large= large
	//ex. [1,2,3]<=[3,2,1] , [1,2,3] > [1,2]
	public static int compareTo(Integer[] integers, Integer[] stone){
		int index=0;
		while(index < integers.length && index < stone.length && integers[index].intValue() == stone[index].intValue())
		{
			index++;
		}

		if (index >= integers.length)
		{
			if (index >= stone.length)
			{
				
				return 0;
			}
			else
			{
				return 2;
			}
			
		}
		else if (index >= stone.length)
		{
			return 1;
		}
		else 
		{
			return (integers[index]>stone[index]?1:2);
		}
	}

	public static int nimSum(Integer[] stone){
		int nimS = 0;
		for (int k = 0; k < stone.length; k++)
		{
			nimS = nimS^stone[k];
		}
		return nimS;
	}
}