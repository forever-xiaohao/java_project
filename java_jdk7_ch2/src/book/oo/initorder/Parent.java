package book.oo.initorder;
/**
 * 本实例的关键技术如下：
 * 1、Java虚拟机先加载父类，再加载子类
 * 2、在加载类时，会对静态初始化块、静态成员变量（类变量）、静态方法进行一次初始化
 * 3、只有在调用new方法时才会创建类的对象。
 * 4、创建对象的过程是，按照父子继承关系进行初始化，首先执行父类的初始化块部分，然后是父类的构造方法，
 * 再执行子类的初始化块，最后是子类的构造方法。
 * 5、销毁对象的过程是，首先销毁子类部分，再销毁父类部分
 * */
public class Parent {
	private int ix = 50;
	private static int iz = getNext(30);
	{
		System.out.println("parent的初始化块");
		int x = 100;
		int y = getNext(100);
	}
	static{
		System.out.println("Parent的静态初始化块");
		int sx = 100;
		int sy = getNext(100);
	}
	public Parent(){
		System.out.println("Parent的构造方法被调用");
	}
	public void display(){
		System.out.println("Parent的display()方法被调用");
		System.out.print("ix=" + this.ix);
		System.out.println("; iz = " + iz);
		dispA();
	}
	public static void dispA(){
		System.out.println("Parent的dispA()被调用");
	}
	private static int getNext(int base) {
		System.out.println("Parent的getNext(int base)被调用");
		return ++base;
	}
	/**当Java进行垃圾回收时，会调用对象的finalize方法*/
	protected void finalize(){
		System.out.println("Parent的销毁方法被调用");
	}
}
