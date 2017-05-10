package procedural.iteration;

import java.util.Arrays;

public class ReverseArrayApp {

	public static void main(String[] args) {
		// написать реверс массива 
		
		int[] array = {0,1,2,3,4,5,6,7,8};
		

	
		for(int i=0; i< array.length; i++){
			System.out.print(" " + array[i]);
		}
		
		System.out.println("");
		System.out.println("-------------------------");
		
		int N = array.length/2;
		
		System.out.println("Длинна массива = " + array.length);
		System.out.println("N="+N);
		
		int iForward = 0;
		int iReverse = array.length -1; 
		
		while(iForward <= N){
			int nForward = array[iForward];
			int nReverse = array[iReverse];
			
			array[iForward] = nReverse;
			array[iReverse] = nForward;
			
			iForward++;
			iReverse--;
		}
		
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("Реверсированный массив...");
		
		System.out.println(array);
		
		System.out.println(Arrays.toString(array));
		

/*		for(int i=0; i< array.length; i++){
			System.out.print(" " + array[i]);
		}
*/
				


	}

}
