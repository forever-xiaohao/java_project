package book.oo.sort;

public class SelectionSort implements ISortNumber{
	/**
	 * 使用选择排序法对整型数组进行排序
	 * */
	public SelectionSort() {
		
	}
	/**排序算法*/
	@Override
	public int[] sortASC(int[] intArray) {
		if(intArray == null){
			return null;
		}
		/*
		 * 因为Java的参数传递是采用传值的方式，在排序过程中需要改变数组
		 * 所以，为了保证输入参数的值不变，这里采用了数组的clone方法，直接克隆一个数组
		 * */
		int[] srcDatas = (int[])intArray.clone();
		int size = srcDatas.length;
		//从头遍历数组元素
		for(int i = 0;i < size; i++){
			//遍历下标为i之后的元素
			for(int j = i; j < size; j++){
				//如果数组前面的值比后面的值大，则交换位置
				if(srcDatas[i] > srcDatas[j]){
					swap(srcDatas,i,j);
				}
			}
		}
		return srcDatas;
	}
	
	/**
	 * 交换数组中下标为src和dest的值
	 * @param data 数组
	 * @param src 源下标
	 * @param dest 目标下标
	 * */
	private void swap(int[] data, int src, int dest){
		int temp = data[src];
		data[src] = data[dest];
		data[dest] = temp;
	}
}
