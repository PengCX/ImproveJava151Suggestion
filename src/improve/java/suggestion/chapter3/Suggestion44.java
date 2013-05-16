package improve.java.suggestion.chapter3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 建议44：推荐使用序列化实现对象的拷贝
 * 1.可以通过序列化的方式来拷贝对象，在内存中通过字节流的拷贝来实现，也就是把母对象写到一个字节流中，在从字节流中读出来 就这样得到了一个新的对象。
 * 2.被拷贝的类只要实现Serializable这个标识接口即可，不需要任何实现，当然serialVersionUID常量还是要加上去的。
 * 
 * 3.用此方法拷贝数据需要注意两点： a)对象的内部属性都是可序列化的
 * b)注意方法和属性的特殊修饰符：如final,static变量的序列化问题，同时transient变量。
 * 
 * 4.使用Apache下的commons工具包中的SerializationUtils类，进行拷贝。
 * 
 * @author Administrator
 * 
 */
public class Suggestion44 {
	public static void main(String[] args) {
		Person1 f = new Person1("父亲");
		Person1 s1 = new Person1("大儿子", f);
		Person1 s2 = CloneUtils.clone(s1);
		s2.setName("小儿子");
		s2.getFather().setName("干爹");
		
		System.out.println(s1.getName() + "的父亲是" + s1.getFather().getName());
		System.out.println(s2.getName() + "的父亲是" + s2.getFather().getName());
	}

}

class CloneUtils {
	// 拷贝一个对象
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		// 拷贝产生的对象
		T clonedObj = null;

		try {
			// 读取对象字节数据
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();

			// 分配内存空间，写入原始对象，生成新对象
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);

			// 返回新的对象，并做类型转换
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

	// 姓名
	private String name;
	// 父亲
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
