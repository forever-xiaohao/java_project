package java_jdk7_ch2;

public class PassParamter {
	
	/**
	 * 构造函数
	 * */
	public PassParamter(){
		
	}
	public void methodA(ComplexNumber comNum){
		comNum = new ComplexNumber(1, 2);//这个引用只向了一个新对象
	}
	public void methodB(ComplexNumber comNum){
		//comNum这个引用指向的还是同一个对象，但是，这里修改该对象的值
		comNum.setRealPart(1);
		comNum.setImaginaryPart(2);
	}
	public void methodC(int num){
		num++; //num的值加1
	}
	public static void main(String[] args) {
		PassParamter test = new PassParamter();
		ComplexNumber comNum = new ComplexNumber(5,5);
		
		/*
		 * main指向引用的原件
		 * */
		System.out.println("调用methodA方法之前，comNum: " + comNum.toString());
		test.methodA(comNum);//引用原件和引用复件指向的是不同的对象，main指向的是引用原件，所以值不变
		System.out.println("调用methodA方法之后，comNum: " + comNum.toString());
		System.out.println("调用methodB方法之前，comNum: " + comNum.toString());
		test.methodB(comNum);//methodB方法只是改变了引用复件的值，而引用原件和引用复件指向的是用一个对象，所以值改变
		System.out.println("调用methodB方法之后，comNum: " + comNum.toString());
		int num = 0;
		System.out.println("调用methodC方法之前，num: " + num);
		test.methodC(num);//复件的值+1，而回到main方法时，仍然是原件，值保持不变
		System.out.println("调用methodC方法之后，num: " + num);


	}

}
