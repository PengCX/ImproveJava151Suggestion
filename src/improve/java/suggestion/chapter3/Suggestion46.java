package improve.java.suggestion.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * ����46��equalsӦ�ÿ���nullֵ�龰
 * 1.��дequalsԭ�򣺶����κ�����x��y�����Σ�x.equals(y)����true,��ôy.equals(x)Ҳ�ķ���true
 * 
 * @author Administrator
 * 
 */
public class Suggestion46 {
	public static void main(String[] args) {
		Person3 p1 = new Person3("����");
		Person3 p2 = new Person3(null);

		List<Person3> l = new ArrayList<Person3>();
		l.add(p1);
		l.add(p2);

		System.out.println("�б����Ƿ����������" + l.contains(p1));
		System.out.println("�б����Ƿ����������" + l.contains(p2));
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
		// Ϊ�˱������������ӣ�����ʹ��getClass�������instanceof�ж�����
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
