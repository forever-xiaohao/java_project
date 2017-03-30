package java_jdk7_ch2;
/**
 * 首先看Object类的equals,hashCode和clone方法的用途
 * equals方法：比较两个对象是否相等，结果为boolean类型
 * hashCode方法：获得对象的hash码，结果为int类型。
 * clone方法：克隆当前对象，结果为Object类型。
 * */
public class ComplexNumber implements Cloneable{
	private double realPart;//复数的实部
	private double imaginaryPart;//复数的虚部
	
	
	/**
	 * 根据现有对象克隆一个新对象，新对象和现有的对象的值是一样的
	 * */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		try {
			//克隆一个对象时，应该先调用父类的clone方法
			ComplexNumber newObject = (ComplexNumber)super.clone();
			//将现有对象的值赋值给新对象
			newObject.setRealPart(this.realPart);
			newObject.setImaginaryPart(this.imaginaryPart);
			return newObject;
		} catch (CloneNotSupportedException e) {
			//如果没有实现Cloneable接口，则抛出异常
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 比较一个对象的值是否和这个复数对象的值相等
	 * */
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		//首先判断a是不是一个复数对象，instanceof 关键字是用来判断对象的类型的
		if(obj instanceof ComplexNumber){
			//如果a是复数对象，则将它强制类型转换成复数对象，以调用复数类提供的方法
			ComplexNumber b = (ComplexNumber)obj;
			if((this.realPart == b.getRealPart()) && (this.imaginaryPart == b.getImaginaryPart())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	/**
	 * 获取该复数对象的hash码
	 * */
	@Override
	public int hashCode() {
		//如果两个复数对象的值是相等的，那么他们的hash码对象必须相同
		//两个值相等的复数对象通过toString()方法得到的输出字符串是一样的
		//于是，可以把得到的字符串的hash码当做复数对象的hash码
		return this.toString().hashCode();
	}
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
	
	public static void main(String[] args) throws CloneNotSupportedException {
		ComplexNumber a = new ComplexNumber(2, 4);
		ComplexNumber b = new ComplexNumber(2, 4);
		System.out.println("ComplexNumber a：" + a.toString());
		System.out.println("ComplexNumber b:" + b.toString());
		System.out.println("(a + b) = " + a.add(b).toString());
		System.out.println("(a - b) = " + a.decrease(b).toString());
		System.out.println("(a * b) = " + a.add(b).toString());
		System.out.println("(a / b) = " + a.decrease(b).toString());
		//用自定义的equals方法比较两个对象是否相等
		System.out.println("a.equals(b) =" + a.equals(b));
		//用自定义的hashCode方法获取对象的hash码
		System.out.println("a.hashCode(b) =" + a.hashCode() + "b.hashCode()" + b.hashCode());
		//使用自定义的clone对象克隆对象
		System.out.println("a.clone = " + a.clone().toString());
	}

}
