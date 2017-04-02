package book.oo.coverhide;
/**
 * 在Java中，方法和变量再继承时的覆盖与隐藏规则如下：
 * 1、父类的实例变量和类变量能被子类的同名变量隐藏。
 * 2、父类的静态方法能被子类的同名静态方法隐藏。
 * 3、父类的实例方法能被子类的同名实例方法覆盖。
 * 4、不能用子类的静态方法隐藏隐藏父类中同样标识的实例方法，否则编译器会报错。
 * 5、不能用子类的实例方法覆盖父类中同样标识的静态方法，否则编译器会报错。
 * 6、最终方法（带关键字final的方法）不能被覆盖
 * 7、变量只会被隐藏，不会被覆盖，无论它是实例变量还是静态变量。而且，子类的静态变量可以隐藏父类的实例变量，子类的实例变量可以隐藏父类的静态变量
 * */
public class CoverHideTest {

	public static void main(String[] args) {
		//先测试继承时变量的覆盖于隐藏问题
		Child child = new Child();
		//此时得到的都是child类的变量值
		System.out.println("Child name: " +child.name+ "; age : " + child.age + "; kind: " + child.kind);
		//将child类型转换成Parent对象
		Parent parent = child;
		//此时得到的都是Parent类的变量值
		System.out.println("转换成Parent后name： " + parent.name + " ; age: " + parent.age +
				"; kind: " + parent.kind);
		System.out.println();
		System.out.println("子类访问父类被隐藏的实例变量 name："
				+ child.getParentName());
		System.out.println("子类访问父类被隐藏的静态变量 kind:"
				+ Child.getParentKind());
		
		//再测试继承时方法的覆盖与隐藏问题
		System.out.println();
		child.getName();//实例方法
		child.getKind();//静态方法
		parent.getName();//实例方法
		parent.getKind();//静态方法

	}

}
