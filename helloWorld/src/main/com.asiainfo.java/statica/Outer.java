package statica;

/**
 * @description: 测试静态内部类的加载时间
 * @author: qml
 * @create: 2019-07-07 11:43
 */
public class Outer {

	static {
		System.out.println("load outer class...");
	}

	//静态内部类  
	static class StaticInner {

		static {
			System.out.println("load static inner class...");
		}

		static void staticInnerMethod() {
			System.out.println("static inner method...");
		}
	}

	public static void main(String[] args) {
		Outer outer = new Outer();      //此刻其内部类是否也会被加载？  
		System.out.println("===========分割线===========");
		//		Outer.StaticInner.staticInnerMethod();      //调用内部类的静态方法  
	}
}