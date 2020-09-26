package day001;

public class xuanze {
	public void sort(int[] n) {
		// 第一个for循环表示第几次循环
		for (int i = 0; i < n.length-1; i++) {
			// 第二个for循环表示该次循环进行几次比较
			for (int j = i+1; j < n.length; j++) {
				// 判断比较是否进行换位
				if (n[i] > n[j ]) {
					int temp = n[i];
					n[i] = n[j];
					n[j ] = temp;
				}
			}
			print(n);
		}
	}

	public void print(int[] n) {
		for (int i = 0; i < n.length; i++)
			// 输出排完序的数组
			System.out.print(n[i] + "\t");
		System.out.println();
	}

	public static void main(String[] args) {
		xuanze s = new xuanze();
		// 此处为需要排序的数组
		int[] n = { 100, 60, 80, 90, 75, 38 };
		s.sort(n);
		s.print(n);
	}
}
