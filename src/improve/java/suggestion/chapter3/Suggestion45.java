package improve.java.suggestion.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * ����45����дequals����ʱ��Ҫʶ�𲻳��Լ�
 *  1.������дJavaBeanʱ��ͨ���Ḳдequals����,����ҵ������ж����������Ƿ���ȡ�
 *	2.equals�������Է�ԭ�򣺶����κηǿ�Ӧ��x,x.equals(x)Ӧ�÷���true. 
 * @author Administrator
 * 
 */
public class Suggestion45 {
	public static void main(String[] args) {
		Person2 p1 = new Person2("����");
		Person2 p2 = new Person2("���� ");
		
		List<Person2> l = new ArrayList<Person2>();
		l.add(p1);
		l.add(p2);
		
		//List�����Ƿ����Ԫ��ʱ����ͨ�����ö����equals�������жϵģ�������ִ��p2.equals(p1),p2.equals(p1)��
		System.out.println("�б����Ƿ����������" + l.contains(p1));
		System.out.println("�б����Ƿ����������" + l.contains(p2));
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
