package improve.java.suggestion.chapter3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ����44���Ƽ�ʹ�����л�ʵ�ֶ���Ŀ���
 * 1.����ͨ�����л��ķ�ʽ�������������ڴ���ͨ���ֽ����Ŀ�����ʵ�֣�Ҳ���ǰ�ĸ����д��һ���ֽ����У��ڴ��ֽ����ж����� �������õ���һ���µĶ���
 * 2.����������ֻҪʵ��Serializable�����ʶ�ӿڼ��ɣ�����Ҫ�κ�ʵ�֣���ȻserialVersionUID��������Ҫ����ȥ�ġ�
 * 
 * 3.�ô˷�������������Ҫע�����㣺 a)������ڲ����Զ��ǿ����л���
 * b)ע�ⷽ�������Ե��������η�����final,static���������л����⣬ͬʱtransient������
 * 
 * 4.ʹ��Apache�µ�commons���߰��е�SerializationUtils�࣬���п�����
 * 
 * @author Administrator
 * 
 */
public class Suggestion44 {
	public static void main(String[] args) {
		Person1 f = new Person1("����");
		Person1 s1 = new Person1("�����", f);
		Person1 s2 = CloneUtils.clone(s1);
		s2.setName("С����");
		s2.getFather().setName("�ɵ�");
		
		System.out.println(s1.getName() + "�ĸ�����" + s1.getFather().getName());
		System.out.println(s2.getName() + "�ĸ�����" + s2.getFather().getName());
	}

}

class CloneUtils {
	// ����һ������
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		// ���������Ķ���
		T clonedObj = null;

		try {
			// ��ȡ�����ֽ�����
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();

			// �����ڴ�ռ䣬д��ԭʼ���������¶���
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);

			// �����µĶ��󣬲�������ת��
			clonedObj = (T) ois.readObject();
			ois.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clonedObj;
	}
}

class Person1 implements Serializable {
	private static final long serialVersionUID = -8121146428772169101L;

	// ����
	private String name;
	// ����
	private Person1 father;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person1 getFather() {
		return father;
	}

	public void setFather(Person1 father) {
		this.father = father;
	}

	public Person1(String _name) {
		name = _name;
	}

	public Person1(String _name, Person1 _parent) {
		name = _name;
		father = _parent;
	}
}
