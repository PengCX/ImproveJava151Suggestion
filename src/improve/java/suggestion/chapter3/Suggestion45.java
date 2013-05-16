package improve.java.suggestion.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 建议45：覆写equals方法时不要识别不出自己
 *  1.我们在写JavaBean时，通常会覆写equals方法,根据业务规则判断两个对象是否相等。
 *	2.equals方法的自反原则：对于任何非空应用x,x.equals(x)应该返回true. 
 * @author Administrator
 * 
 */
public class Suggestion45 {
	public static void main(String[] args) {
		Person2 p1 = new Person2("张三");
		Person2 p2 = new Person2("张三 ");
		
		List<Person2> l = new ArrayList<Person2>();
		l.add(p1);
		l.add(p2);
		
		//List类检查是否包含元素时，是通过调用对象的equals方法来判断的，会依次执行p2.equals(p1),p2.equals(p1)。
		System.out.println("列表中是否包含张三：" + l.contains(p1));
		System.out.println("列表中是否包含张三：" + l.contains(p2));
	}
}

class Person2 {
	private String name;

	Person2(String _name) {
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
		if (obj instanceof Person2) {
			Person2 p = (Person2) obj;
			return name.equalsIgnoreCase(p.getName());
		}
		return false;
	}
}
