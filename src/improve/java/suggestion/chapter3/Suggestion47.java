package improve.java.suggestion.chapter3;

/**
 * ����47����equals��ʹ��getClass���������ж�
 * 
 * @author Administrator
 * 
 */
public class Suggestion47 {
	public static void main(String[] args) {
		Employee e1 = new Employee("����", 100);
		Employee e2 = new Employee("����", 1001);
		Person3 p1 = new Person3("����");

		System.out.println(p1.equals(e1));
		System.out.println(p1.equals(e2));
		System.out.println(e1.equals(e2));
	}
}

class Employee extends Person3 {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	Employee(String _name, int _id) {
		super(_name);
		id = _id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Employee e = (Employee) obj;
			return super.equals(obj) && e.getId() == id;
		}

		return false;
	}

}
