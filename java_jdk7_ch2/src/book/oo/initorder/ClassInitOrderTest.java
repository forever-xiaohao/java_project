package book.oo.initorder;

public class ClassInitOrderTest {

	public static void main(String[] args) {
		System.out.println("不new对象，访问静态方法时的输出：");
		Child.dispB();
		System.out.println();
		System.out.println("new对象，访问非静态方法时的输出：");
		new Child().display();
		//通知虚拟机进行垃圾回收
		System.gc();
	}
}
