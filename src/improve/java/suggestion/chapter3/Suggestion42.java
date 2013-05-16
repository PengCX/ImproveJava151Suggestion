package improve.java.suggestion.chapter3;

/**
 * 建议42：让工具类不可实例化
 * 1.Java項目中使用的工具类很多，比如Java.lang.Math、Java.util.Collections等，工具类的方法和属性
 * 都是静态的，不需要生成实例即可访问，而且JDK也做了很好的处理，设置构造函数为private访问权限。
 * 
 * @author Administrator
 * 
 */
public class Suggestion42 {

}

class UitlsClass {
	private UitlsClass() {
		// 为了避免使用反射机制来修改访问权限，达到构造私有构造方法实例，我们抛出异常。
		throw new Error("不要实例化我！");
	}
}