package book.oo.sort;

public class SortTest {
	/**
	 * 打印数组
	 * @param intArray 待打印的数组
	 * */
	public static void printIntArray(int[] intArray){
		if(intArray == null){
			return ;
		}
		for(int i = 0; i < intArray.length;i++){
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] intArray = new int[]{6,3,4,2,7,2,-3,3};
		
		System.out.print("排序前的数组：");
		printIntArray(intArray);
		ISortNumber test = new SelectionSort();
		System.out.print("选择排序算法的排序结果：");
		printIntArray(test.sortASC(intArray));
		
		System.out.print("排序前的数组：");
		printIntArray(intArray);
		System.out.print("冒泡排序法排序结果：");
		printIntArray(test.sortASC(intArray));

	}

}
