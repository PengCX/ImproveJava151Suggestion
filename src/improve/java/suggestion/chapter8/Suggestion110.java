package improve.java.suggestion.chapter8;

/**
 * ����110���ᳫ�쳣��װ
 * 1.Java API�ṩ���쳣���ǱȽϵͼ��ģ�ֻ�п�����Ա���ܿ��������������ն��û���˵����Щ�쳣�����������顣
 * 2.�쳣�ķ�װ�����ºô���
 * 		a)���ϵͳ���Ѻ���
 * 		b)���ϵͳ�Ŀ�ά����
 * 		c)���Java�쳣���Ƶ�����ȱ��
 * @author Administrator
 * 
 */	
public class Suggestion110 {
	//a)�ṩϵͳ���Ѻ���
	//doStuff�������Ѻ��Լ�������쳣ʱ�������ļ������ڣ����÷�����ֱ�Ӱ�FileNotFoundException�쳣�׳�
	//�ϲ�Ӧ���У��������ն��û��������ϲ�Ӧ�ã����û���Ҫô�Լ�����Ҫô�����ף����յĽ�������û�����š����顱ʽ������
	//�������û���֪����ʲô���⡣
//	public static void doStuff() throws Exception{
//		InputStream is = new FileInputStream("��Ч�ļ�.txt");
//		/*�ļ�����*/
//	}
	//����취�ͷ�װ�쳣�����쳣���Ķ��߷�Ϊ���ࣺ������Ա���û���������Ա��Ҫ��ӡ����ջ��Ϣ�����û�����Ҫ�˽�����ҵ��ԭ��
//	public static void doStuff2() throws MyBussinessException{
//		try {
//			InputStream is = new FileInputStream("��Ч�ļ�.txt");
//		} catch (FileNotFoundException e) {
//			//Ϊ�˷��㿪����Ա��ά����Ա�����õ��쳣��Ϣ
//			e.printStackTrace();
//			//�׳�ҵ���쳣
//			throw new MyBussinessException(e);
//		}	
//	}
	
	//b)���ϵͳ�Ŀ�ά����
	//���Ǻܶ����Ա���׷��Ĵ��󣬷��ദ����鷳������һ��catch�������������쳣�ɡ�
	//JVM���ӡ��ջ�еĴ�����Ϣ����Ȼ��û�����Ǹ���Ϣֻ�п�����Ա�Լ����ܿ��Ķ���ά����Ա������� �쳣��Ϣʱ�������޷�����
//	public void doStuff3(){
//		try {
//			//do something
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	//��ȷ�Ĵ���ʽ�Ƕ��쳣���з��ദ�������з�װ���.��˰�װ��ά����Ա�����������쳣��Ϣ�������˳������жϣ����߼�����ã�
	//���߳�ʼ������������Ҫֱ�ӵ�����㼶ȥ������
//	public void doStuff4(){
//		try {
//			//do something
//		} catch (FileNotFoundException e) {
//			log.info("�ļ�δ�ҵ���ʹ��Ĭ�������ļ�......");
//		}catch (SecurityException e) {
//			log.info("��Ȩ���ʣ�����ԭ����......");
//			e.printStackTrace();
//		}
//	}
	
	//c)���Java�쳣���Ƶ�����ȱ�ݣ�Java�е��쳣һ��ֻ���׳�һ����������doStuff�����������߼�����Ƭ�Σ�����ڵ�һ���߼�
	//Ƭ�����׳��쳣����ڶ����߼�Ƭ�ξͲ���ִ���ˣ�Ҳ���޷��׳��ڶ����쳣��
	//����취,ʹ�����з�װ���쳣
//	class MyException extends Exception{
//		//���������쳣
//		private List<Throwable> causes = new ArrayList<Throwable>();
//		
//		//���캯��������һ���쳣�б�
//		public MyException(List<? extends Throwable> _causes){
//			causes.addAll(_causes);
//		}
//		
//		//��ȡ�����쳣
//		public List<Throwable> getExceptions(){
//			return causes;
//		}
//	}
	
//	public static void doStuff() throws MyException{
//		List<Throwable> list = new ArrayList<Throwable>();
//		
//		//��һ���߼�Ƭ��
//		try {
//			//Do Something
//		} catch (Exception e) {
//			list.add(e);
//		}
//		
//		//�ڶ����߼�Ƭ��
//		try {
//			//Do Something
//		} catch (Exception e) {
//			list.add(e);
//		}
//		
//		//����Ƿ��б�Ҫ�׳� �쳣
//		if (list.size() > 0) {
//			throw new MyException(list);
//		}
//	}
	//Ӧ�����û�ע�ᣬ�ڵ�һ���ύ��ʱ�򣬾���ʾ�����쳣���û����ظ���������������6λ��
	
}
