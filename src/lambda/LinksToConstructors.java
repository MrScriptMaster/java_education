package lambda;

/*
 * Точно также мы можем передавать ссылки на конструкторы, обобщенных и
 * необобщенных классов.
 * 
 * Разница состоит в том, что при ссылке на конструктор, метод, на основе которого
 * делается ссцлка, должен возвращать объект того, класса, на чей конструктор мы указываем,
 * и совпадать по сигнатуре.
 * 
 * Чтобы сослаться на конструктор, используется запись
 * 
 * ИмяКласса::new
 * 
 * При этом конструктор может быть выбран автоматически компилятором на основе сигнатуры.
 */

interface MyFuncClass {
	MyClass func(int n);
}

interface MyFuncClass_1<T> {
	MyClass_1<T> func(T val);
}

/*
 * На конструктор этого класса мы сошлемся
 */

class MyClass {
	private int val;
	
	MyClass(int v)
	{
		val = v;
	}
	
	MyClass()
	{
		val = 0;
	}
	
	int getVal()
	{
		return val;
	}
}

/*
 * Обобщенный класс
 */
class MyClass_1<T> {
	private T val;
	
	MyClass_1(T v)
	{
		val = v;
	}
	
	T getVal()
	{
		return val;
	}
	
}

public class LinksToConstructors {

	public static void main(String[] args) {
		
		/*
		 * Несмотря на то, что у класса два конструктора, компилятору будет
		 * понятно по сигнатуре на какой мы указываем.
		 */
		MyFuncClass myCl = MyClass::new;
		
		/*
		 * Пользуясь одной ссылкой, мы можем построить экземпляр класса
		 */
		MyClass mc = myCl.func(23);
		System.out.println(mc.getVal());
		
		/*
		 * Аналогично мы можем ссылать на конструкторы обобщенных классов. 
		 */
		MyFuncClass_1<String> myCl_1 = MyClass_1<String>::new;
		
		MyClass_1<String> mc_1 = myCl_1.func("Привет");
		System.out.println(mc_1.getVal());
	}

}
