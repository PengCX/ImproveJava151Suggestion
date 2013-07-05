package improve.java.suggestion.chapter4;
/**
 * 建议52：推荐使用String直接量赋值
 * 
 * @author Administrator
 *
 */
public class Suggestion52 {
	public static void main(String[] args) {
		String str1 = "中国";
		String str2 = "中国";
		String str3 = new String("中国");
		String str4 = str3.intern();
		//两个直接量是否相等
		boolean b1 = (str1 == str2);
		//直接量和对象是否相等
		boolean b2 = (str1 == str3);
		//经过intern处理后的对象与直接量是否相等
		boolean b3 = (str1 == str4);
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}
}
