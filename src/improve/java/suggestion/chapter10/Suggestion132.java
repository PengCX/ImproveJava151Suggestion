package improve.java.suggestion.chapter10;

import org.omg.CORBA.PUBLIC_MEMBER;


/**
 * ����132������Java���ܵĻ�������
 * 1.��Ҫ��ѭ����������
 * 2.�����ܰѱ�������������Ϊfinal static����
 * 3.��С���������÷�Χ
 * 4.Ƶ�����ַ�������ʹ��StringBuilder��StringBuffer
 * 5.ʹ�÷����Լ���
 * 6.��дException��fillInStackTrace����
 * 7.�������������
 * @author Administrator
 *
 */
public class Suggestion132 {
	public static void main(String[] args) {
		//1.��Ҫ��ѭ�������м���
		//ÿ��ѭ������Ҫ����
		//while (i < count*2) {
		//	Do Something
		//} 
		//�޸ģ�ֻ��Ҫ����һ��
		//int total = count * 2;
		//while(i < total){
		//  DoSomething
		//}
		
		
		//2.�����ܰѱ�������������Ϊfinal static����
		//public String toChineseNum(){
		//  String[] cns ={"��","Ҽ"....};
		//	return cns[num]
		//}
		//�޸ģ�
		//ÿ�η������õ�ʱ�򣬲������������������
		//final static String[] cns ={"��","Ҽ"....};
		//public String toChineseNum(){
		//	return cns[num]
		//}
		
		
		//3.��С���������÷�Χ
		//���ڱ������ܶ����ڷ����ڵľͶ����ڷ����ڣ��ܶ�����һ��ѭ�����ڵľͶ�����ѭ�����ڣ�
		//�ܷ�����һ��try...catch���ڵľͷ��ڸĿ��ڡ���Ŀ���Ǽӿ�GC�Ļ���
			
		//4.Ƶ���ַ�������ʹ��StringBuffer��StringBuffer
		//��ȻString�����Ӳ�������+���ţ��Ѿ����˺ܶ��Ż������Ǵ�����׷�Ӳ�����StringBuffer��StringBuffer
		//���Ǳ�"+"�ŵ����ܺúܶࡣ
		//String str = "Log file is ready������������";
		//for (int i = 0; i < max; i++) {
		//	//�˴���������������
		//	str += "log" + i;
		//}
		//�޸ģ�
		//StringBuilder sb = new StringBuilder(20000);
		//for(int i = 0;i < max;i++){
		//	sb.append("log" + i);
		//}
		//String log = sb.toString();
		
		//5.ʹ�÷����Լ���
		//�����ArrayList�д洢�˴��������ݣ�ʹ��indexOf����Ԫ�ػ��java.utils.Collections.binarySe
		//archЧ�ʵͺܶ࣬��ΪbinarySearchʹ�ö��ֲ��ң�indexOfʹ�����Ԫ�ز��ҡ�
		//ע�⣡ʹ��binarySearch������ʱ������Ƚ�������
		
		//6.��дException��fillInStackTrace����
		//fillInStackTrace����ʱ������¼�쳣ʱ��ջ��Ϣ�����Ƿǳ���ʱ�Ķ�������������ڿ���ʱ����Ҫ��עջ��Ϣ����ɸ��ǡ�
		//�������fillInStackTrace���Զ����쳣��ʹ��������10������
		//class MyException extends Exception{
		//	@Override
		//	public synchronized Throwable fillInStackTrace() {
		//		return this;
		//	}
		//}
		
		//7.�������������
		//exceptionMsg��Ϣֻ�������쳣��ʱ�򣬲Ż�������֮�ء���ҪΪ��һ�����������ֵĳ�����ÿ�ζඨ��һ���ַ�������
		//public void doSomething(){
		////�쳣��Ϣ
		//String exceptionMsg = "�ҳ����쳣�ˣ��������ң�";		
		//try{
		//		Thread.sleep(10);
		//	 } catch (Exception e) {
		//		//ת��Ϊ�Զ����������쳣
		//		throw new MyException(e,exceptionMsg);
		//	 }			
		//}
	}
}
