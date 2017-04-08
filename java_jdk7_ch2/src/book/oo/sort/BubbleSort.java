package book.oo.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * 采用冒泡法对整型数组进行排序
 * */
public class BubbleSort implements ISortNumber {
	
	public BubbleSort() {
		
	}
	/**
	 * 冒泡排序法
	 * */
	@Override
	public int[] sortASC(int[] intArray) {
		if(intArray == null){
			return null;
		}
		//因为Java的参数传递是采用引用传值得方式，在排序过程中需要改变数组
		//所以，为了保证输入参数的值不变，这里采用了数组的clone方法，直接克隆一个数组
		int[] srcDatas = (int[]) intArray.clone();
		boolean changePosition = true;//标识是否交换了数组中元素的位置
		int comparedTimes = 0;//标识比较的次数
		int maxComparedTimes = srcDatas.length -1;//标识排序过程中可能交换的最大次数
		
		//如果已经发生的比较次数还没有达到最大次数，而且此前交换过元素位置，则继续
		while((comparedTimes < maxComparedTimes) && (changePosition)){
			for(int i = 0 ; i < (maxComparedTimes - comparedTimes) ; i++){
				changePosition = false;
				if(srcDatas[i] > srcDatas[i + 1]){
					swap(srcDatas,i,i+1);
					changePosition = true;
				}
			}
			comparedTimes++;
		}
		return srcDatas;
	}
	
	/**
	 * 交换数组中下标为src和dest的值
	 * @param data 数组
	 * @param src 源下标
	 * @param dest 目标下标
	 * */
	private void swap(int[] data,int src,int dest){
		int temp = data[src];
		data[src] = data[dest];
		data[dest] = temp;
	}

}
