package improve.java.suggestion.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议46：equals应该考虑null值情景
 * 1.覆写equals原则：对于任何引用x和y的情形，x.equals(y)返回true,那么y.equals(x)也改返回true
 * 
 * @author Administrator
 * 
 */
public class Suggestion46 {
	public static void main(String[] args) {
		Person3 p1 = new Person3("张三");
		Person3 p2 = new Person3(null);

		List<Person3> l = new ArrayList<Person3>();
		l.add(p1);
		l.add(p2);

		System.out.println("列表中是否包含张三：" + l.contains(p1));
		System.out.println("列表中是否包含张三：" + l.contains(p2));
	}
}

class Person3 {
	private String name;

	Person3(String _name) {
		name = _name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		// 为了避免子类的钻空子，我们使用getClass方法替代instanceof判断类型
		if (obj != null && obj.getClass() == this.getClass()) {
			Person3 p = (Person3) obj;
			if (p.getName() == null || name == null) {
				return false;
			} else {
				return name.equalsIgnoreCase(p.getName());
			}
		}
		return false;
	}
}
