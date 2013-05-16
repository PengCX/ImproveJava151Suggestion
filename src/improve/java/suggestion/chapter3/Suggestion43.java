package improve.java.suggestion.chapter3;


/**
 * ����43����������ǳ���� 1.ʵ����Cloneable�ӿڣ��ͱ�ʾ���߱��˱�����������������ڸ�д��clone()�������ͻ���ȫ�߱��������ܣ�
 * 2.�������ڴ��н��У��������ܷ����ֱ��ͨ��new���ɶ���Ҫ��Ķ࣬�ر��Ǵ����������ϣ���������������
 * 3.���󿽱�Ҳ��һ���Ƚ����׺��Ե����⣺ǳ������Shadow Clone��Ҳ����Ӱ�ӿ��������ڶ������Կ��������׵����⡣
 * 
 * 
 * 4.super.clone�������ṩ����ǳ�����������������£�
 * 		a)�������ͣ�������ֵ��
 * 		b)�������������һ��ʵ�������򿽱���ַ���á������ܷ���Ȩ�޵����ơ�
 * 		c)String�ַ�����������Ҳ��һ����ַ�����ַ����������������µ��ַ�����ԭ���ַ������ֲ��䡣
 * @author Administrator
 * 
 */
public class Suggestion43 {
	public static void main(String[] args) {
		// ���常��
		Person f = new Person("����");
		// ��������
		Person s1 = new Person("�����", f);
		// С���ӵ���Ϣ��ͨ������ӿ���������
		Person s2 = s1.clone();
		s2.setName("С����");

		// �ϸɵ�
		s1.getFather().setName("�ɵ�");

		System.out.println(s1.getName() + "�ĸ�����" + s1.getFather().getName());
		System.out.println(s2.getName() + "�ĸ�����" + s2.getFather().getName());
	}
}

class Person implements Cloneable {
	// ����
	private String name;
	// ����
	private Person father;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person(String _name) {
		name = _name;
	}

	public Person(String _name, Person _parent) {
		name = _name;
		father = _parent;
	}

	@Override
	protected Person clone() {
		Person p = null;

		try {
			p = (Person) super.clone();
			p.setFather(new Person(p.getFather().getName()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return p;
	}
}
