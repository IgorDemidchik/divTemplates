package iteration; 

public class LoopApp {

	public static void main(String[] args) {
		
		
		for(int k=0;k<10;k++){
			//System.out.print(k);
			System.out.print(" " + k);
		}
		
		int kk = 0; 
		while (kk<10){
			System.out.println(" kk=" + kk);
			kk+=2;
		}
		
		System.out.println("�������� ������...");
		//������ ������� �������������
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		for(int i=0; i < array.length; i++){
			System.out.println("arr[" + i + "]=" + array[i]);
		}
		//�������� ������ � �������� ������� 
		
		System.out.println("� �������� �������...");
		for(int i = array.length - 1; i >= 0; i--){
			System.out.println("arr[" + i + "]=" + array[i]);
		}
		
		//for (int k = 2; k < 1000000; k*=k){
			//System.out.print(" " + k);
		//}
		
		//������������� ������ 
	
		
	}

}
