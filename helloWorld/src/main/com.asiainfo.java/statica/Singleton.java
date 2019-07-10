package statica;

/**
 * @description: 静态内部类
 * @author: qml
 * @create: 2019-07-07 11:48
 */
public class Singleton {

	private static class SingletonHolder {

		private static final Singleton INSTANCE = new Singleton();
	}

	private Singleton() {
	}

	public static final Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public static void main(String[] args) {
		Singleton singleton = new Singleton();
		getInstance();
	}
}