package java_jdk7_ch2;

public class ComplexNumber {
	private double realPart;//复数的实部
	private double imaginaryPart;//复数的虚部
	
	/*默认构造函数*/
	public ComplexNumber(){
		this.realPart = 0.0;
		this.imaginaryPart = 0.0;
	}
	/**
	 * 构造函数
	 * @param a 实部
	 * @param b 虚部
	 * */
	public ComplexNumber(double a,double b){
		this.realPart = a;
		this.imaginaryPart = b;
	}
	
	
	
	public double getRealPart() {
		return realPart;
	}
	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}
	public double getImaginaryPart() {
		return imaginaryPart;
	}
	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}
	/**
	 * 复数的加法运算
	 * c = a + b的运算法则是
	 * c.实部 = a.实部 + b.实部；c.虚部 = a.虚部 + b.虚部
	 * @param aComNum 加数
	 * @return 加法运算的结果，为一个复数对
	 * */
	public ComplexNumber add(ComplexNumber aComNum){
		if(aComNum == null){
			System.err.println("对象不能够为null！");
			return new ComplexNumber();
		}
		return new ComplexNumber(this.realPart + aComNum.getRealPart(),this.imaginaryPart + 
				aComNum.getImaginaryPart());
	}
	/**
	 * 复数的减法运算
	 * c = a + b的运算法则是
	 * c.实部 = a.实部 - b.实部；c.虚部 = a.虚部 - b.虚部
	 * @param aComNum减数
	 * @return 减法运算的结果，为一个复数对象
	 * */
	public ComplexNumber decrease(ComplexNumber aComNUm){
		if(aComNUm == null){
			System.err.println("对象不能为null！");
			return new ComplexNumber();
		}
		return new ComplexNumber(this.realPart - aComNUm.getRealPart(),
				this.imaginaryPart - aComNUm.getImaginaryPart());
	}
	
	/**
	 * 复数乘法运算
	 * c.实部 = a.实部 * b.实部 - a.虚部 * b.虚部
	 * c.虚部 = a.虚部 * b.实部 + a.实部 * b.虚部
	 * @param aComNum乘数
	 * @return 乘法运算的结果，为一个复数对象
	 * */
	public ComplexNumber multiply(ComplexNumber aComNum){
		if(aComNum == null){
			System.err.println("对象不能为null！");
			return new ComplexNumber();
		}
		double newreal = this.realPart * aComNum.getRealPart() - this.imaginaryPart * aComNum.getImaginaryPart();
		double newImaginary = this.realPart * aComNum.imaginaryPart + this.imaginaryPart * aComNum.getRealPart();
		ComplexNumber result = new ComplexNumber(newreal,newImaginary);
		return result;
	}
	/**
	 * 复数除法运算
	 * c = a/b的运算法则是
	 * c.实部 = (a.实部 * b.实部 + a.虚部 * b.虚部) / (b.实部*b.实部 + b.虚部*b.虚部)
	 * @param aComNum除数
	 * @return 除法运算的结果，为一个复数对象
	 * */
	public ComplexNumber divide(ComplexNumber aComNum){
		if(aComNum == null){
			System.err.println("对象不能为null!");
			return new ComplexNumber();
		}
		if((aComNum.getRealPart() == 0) && (aComNum.getImaginaryPart() == 0)){
			System.err.println("除数不能为0");
			return new ComplexNumber();
		}
		double temp = aComNum.getRealPart() * aComNum.getRealPart() + aComNum.getImaginaryPart() * aComNum.getImaginaryPart();
		double crealpart = (this.realPart * aComNum.getRealPart() + this.imaginaryPart * aComNum.getImaginaryPart()) / temp;
		double cimaginaryPart = (this.imaginaryPart * aComNum.getRealPart() - this.realPart * aComNum.getImaginaryPart()) / temp;
		return new ComplexNumber(crealpart, cimaginaryPart);
	}
	/*将一个复数显示为字符串*/
	public String toString(){
		return this.realPart + "+" + this.imaginaryPart + "i";
	}
	
	public static void main(String[] args) {
		ComplexNumber a = new ComplexNumber(2, 4);
		ComplexNumber b = new ComplexNumber(1, 2);
		System.out.println("ComplexNumber a：" + a.toString());
		System.out.println("ComplexNumber b:" + b.toString());
		System.out.println("(a + b) = " + a.add(b).toString());
		System.out.println("(a - b) = " + a.decrease(b).toString());
		System.out.println("(a * b) = " + a.add(b).toString());
		System.out.println("(a / b) = " + a.decrease(b).toString());
	}

}
