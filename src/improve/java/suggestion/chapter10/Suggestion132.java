package improve.java.suggestion.chapter10;

import org.omg.CORBA.PUBLIC_MEMBER;


/**
 * 建议132：提升Java性能的基本方法
 * 1.不要在循环中做计算
 * 2.尽可能把变量、方法声明为final static类型
 * 3.缩小变量的作用范围
 * 4.频繁的字符串操作使用StringBuilder或StringBuffer
 * 5.使用费线性检索
 * 6.覆写Exception的fillInStackTrace方法
 * 7.不建立冗余对象
 * @author Administrator
 *
 */
public class Suggestion132 {
	public static void main(String[] args) {
		//1.不要在循环条件中计算
		//每次循环都需要计算
		//while (i < count*2) {
		//	Do Something
		//} 
		//修改：只需要计算一遍
		//int total = count * 2;
		//while(i < total){
		//  DoSomething
		//}
		
		
		//2.尽可能把变量、方法声明为final static类型
		//public String toChineseNum(){
		//  String[] cns ={"零","壹"....};
		//	return cns[num]
		//}
		//修改：
		//每次方法调用的时候，不在重新生成数组对象
		//final static String[] cns ={"零","壹"....};
		//public String toChineseNum(){
		//	return cns[num]
		//}
		
		
		//3.缩小变量的作用范围
		//关于变量，能定义在方法内的就定义在方法内，能定义在一个循环体内的就定义在循环体内，
		//能放置在一个try...catch块内的就放在改块内。其目的是加快GC的回收
			
		//4.频繁字符串操作使用StringBuffer或StringBuffer
		//虽然String的联接操作（“+”号）已经做了很多优化，但是大量的追加操作上StringBuffer或StringBuffer
		//还是比"+"号的性能好很多。
		//String str = "Log file is ready。。。。。。";
		//for (int i = 0; i < max; i++) {
		//	//此处生成了三个对象
		//	str += "log" + i;
		//}
		//修改：
		//StringBuilder sb = new StringBuilder(20000);
		//for(int i = 0;i < max;i++){
		//	sb.append("log" + i);
		//}
		//String log = sb.toString();
		
		//5.使用非线性检索
		//如果在ArrayList中存储了大量的数据，使用indexOf查找元素会比java.utils.Collections.binarySe
		//arch效率低很多，因为binarySearch使用二分查找，indexOf使用逐个元素查找。
		//注意！使用binarySearch搜索的时候必须先进行排序。
		
		//6.覆写Exception的fillInStackTrace方法
		//fillInStackTrace方法时用来记录异常时的栈信息，这是非常耗时的动作，如果我们在开发时不需要关注栈信息，则可覆盖。
		//如果覆盖fillInStackTrace的自定义异常会使性能提升10倍以上
		//class MyException extends Exception{
		//	@Override
		//	public synchronized Throwable fillInStackTrace() {
		//		return this;
		//	}
		//}
		
		//7.不建立冗余对象
		//exceptionMsg消息只有在有异常的时候，才会有用武之地。不要为了一个不经常出现的场景就每次多定义一个字符串变量
		//public void doSomething(){
		////异常信息
		//String exceptionMsg = "我出现异常了，快来救我！";		
		//try{
		//		Thread.sleep(10);
		//	 } catch (Exception e) {
		//		//转换为自定义运行期异常
		//		throw new MyException(e,exceptionMsg);
		//	 }			
		//}
	}
}
