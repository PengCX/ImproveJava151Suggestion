package improve.java.suggestion.chapter8;

/**
 * 建议110：提倡异常封装
 * 1.Java API提供的异常都是比较低级的，只有开发人员才能看到看懂。对于终端用户来说，这些异常基本上是天书。
 * 2.异常的封装有以下好处：
 * 		a)提高系统的友好性
 * 		b)提高系统的可维护行
 * 		c)解决Java异常机制的自身缺陷
 * @author Administrator
 * 
 */	
public class Suggestion110 {
	//a)提供系统的友好性
	//doStuff方法的友好性极差：出现异常时（比如文件不存在），该方法会直接把FileNotFoundException异常抛出
	//上层应用中（或者是终端用户），而上层应用（或用户）要么自己处理，要么接着抛，最终的结果是让用户面对着“天书”式的文字
	//发呆，用户不知道是什么问题。
//	public static void doStuff() throws Exception{
//		InputStream is = new FileInputStream("无效文件.txt");
//		/*文件操作*/
//	}
	//解决办法就封装异常：把异常的阅读者分为两类：开发人员和用户。开发人员需要打印出堆栈信息，而用户则需要了解具体的业务原因。
//	public static void doStuff2() throws MyBussinessException{
//		try {
//			InputStream is = new FileInputStream("无效文件.txt");
//		} catch (FileNotFoundException e) {
//			//为了方便开发人员和维护人员而设置的异常信息
//			e.printStackTrace();
//			//抛出业务异常
//			throw new MyBussinessException(e);
//		}	
//	}
	
	//b)提高系统的可维护性
	//这是很多程序员容易犯的错误，分类处理多麻烦，就用一个catch块来处理所有异常吧。
	//JVM会打印出栈中的错误信息，虽然这没错，但是该信息只有开发人员自己才能看的懂，维护人员看到这段 异常信息时基本上无法处理。
//	public void doStuff3(){
//		try {
//			//do something
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	//正确的处理方式是对异常进行分类处理，并进行封装输出.如此包装后，维护人员看到这样的异常信息，就有了初步的判断，或者检查配置，
	//或者初始化环境，不需要直接到代码层级去分析了
//	public void doStuff4(){
//		try {
//			//do something
//		} catch (FileNotFoundException e) {
//			log.info("文件未找到，使用默认配置文件......");
//		}catch (SecurityException e) {
//			log.info("无权访问，可能原因是......");
//			e.printStackTrace();
//		}
//	}
	
	//c)解决Java异常机制的自身缺陷：Java中的异常一次只能抛出一个，比如在doStuff方法有两个逻辑代码片段，如果在第一个逻辑
	//片段中抛出异常，则第二个逻辑片段就不在执行了，也就无法抛出第二个异常了
	//解决办法,使用自行封装的异常
//	class MyException extends Exception{
//		//容纳所有异常
//		private List<Throwable> causes = new ArrayList<Throwable>();
//		
//		//构造函数，传递一个异常列表
//		public MyException(List<? extends Throwable> _causes){
//			causes.addAll(_causes);
//		}
//		
//		//读取所有异常
//		public List<Throwable> getExceptions(){
//			return causes;
//		}
//	}
	
//	public static void doStuff() throws MyException{
//		List<Throwable> list = new ArrayList<Throwable>();
//		
//		//第一个逻辑片段
//		try {
//			//Do Something
//		} catch (Exception e) {
//			list.add(e);
//		}
//		
//		//第二个逻辑片段
//		try {
//			//Do Something
//		} catch (Exception e) {
//			list.add(e);
//		}
//		
//		//检查是否有必要抛出 异常
//		if (list.size() > 0) {
//			throw new MyException(list);
//		}
//	}
	//应用如用户注册，在第一次提交的时候，就提示所有异常“用户名重复“，”密码少于6位“
	
}
