package improve.java.suggestion.chapter4;
/**
 * ����52���Ƽ�ʹ��Stringֱ������ֵ
 * 
 * @author Administrator
 *
 */
public class Suggestion52 {
	public static void main(String[] args) {
		String str1 = "�й�";
		String str2 = "�й�";
		String str3 = new String("�й�");
		String str4 = str3.intern();
		//����ֱ�����Ƿ����
		boolean b1 = (str1 == str2);
		//ֱ�����Ͷ����Ƿ����
		boolean b2 = (str1 == str3);
		//����intern�����Ķ�����ֱ�����Ƿ����
		boolean b3 = (str1 == str4);
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
}
