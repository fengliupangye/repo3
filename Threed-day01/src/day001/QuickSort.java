package day001;

public class QuickSort {
	public static void main(String[] args) {
		int[] a={32,89,28,48,6};
		show(a);
		quick(a,0,a.length-1);
		show(a);
	}
	
	//快速排序算法
	public static void quick(int[] array,int left,int right){
		if(left<right){
			int temp=array[left];
			int i=left;
			int j=right;
			while(i<j){
				while(i<j && array[j]>temp){
					j--;
				}
				if(i<j){
					array[i]=array[j];
					i++;
				}
				while(i<j && array[i]<temp){
					i++;
				}
				if(i < j ){
					array[j]=array[i];
					j--;
				}
			}
			array[i]=temp;
			quick(array,left,i-1);//左边进行排序
			quick(array,i+1,right);//右边进行排序
		}
	}
	
	public static void show(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println();
		
	}
}
