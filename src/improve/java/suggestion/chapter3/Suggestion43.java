package improve.java.suggestion.chapter3;


/**
 * 建议43：避免对象的浅拷贝 1.实现了Cloneable接口，就表示它具备了被拷贝的能力，如果在覆写了clone()方法，就会完全具备拷贝功能，
 * 2.拷贝在内存中进行，所以性能方面比直接通过new生成对象要快的多，特别是大对象的生成上，性能提升显著。
 * 3.对象拷贝也有一个比较容易忽略的问题：浅拷贝（Shadow Clone，也叫做影子拷贝）存在对象属性拷贝不彻底的问题。
 * 
 * 
 * 4.super.clone方法，提供的是浅拷贝，拷贝规则如下：
 * 		a)基本类型：拷贝其值。
 * 		b)对象：如果变量是一个实例对象，则拷贝地址引用。并不受访问权限的限制。
 * 		c)String字符串：拷贝的也是一个地址，从字符串池中重新生成新的字符串，原有字符串保持不变。
 * @author Administrator
 * 
 */
public class Suggestion43 {
	public static void main(String[] args) {
		// 定义父亲
		Person f = new Person("父亲");
		// 定义大儿子
		Person s1 = new Person("大儿子", f);
		// 小儿子的信息是通过大儿子拷贝过来的
		Person s2 = s1.clone();
		s2.setName("小儿子");

		// 认干爹
		s1.getFather().setName("干爹");

		System.out.println(s1.getName() + "的父亲是" + s1.getFather().getName());
		System.out.println(s2.getName() + "的父亲是" + s2.getFather().getName());
	}
}

class Person implements Cloneable {
	// 姓名
	private String name;
	// 父亲
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
