package lambda;

/*
 * Этот пример демонстрирует возможости передачи функций по ссылкам
 */

/*
 * Пусть у нас есть следующий обобщенный функциональный интерфейс
 * 
 * Мы будем использовать сигнатуру метода этого интерфейса
 */

interface MyFunc<T> {
	boolean func(T v1, T v2);
}

interface MyFunc1<T> {
	int func(T[] vals, T v2);
}

/*
 * Этот класс выполняет элементарные операции. В данном случае он
 * предоставляет методы для сравнения температур.
 */
class TempBits {
	int hTemp;
	
	public TempBits(int ht) {
		hTemp = ht;
	}
	
	/*
	 * Метод возвращает true, если передаваемый объект имеет ту же температуру,
	 * что и этот.
	 */
	boolean sameTemp(TempBits ht2)
	{
		return hTemp == ht2.hTemp;
	}
	/*
	 * Метод возвращает true, если этот объект холоднее, чем передаваемый
	 */
	boolean lessThanTemp(TempBits ht2)
	{
		return hTemp < ht2.hTemp;
	}
	
	/*
	 * Сигнатуры обоих методов совместимы с сигнатурой функционального интерфейса. В данном
	 * случае в нем первый аргумент следует рассматривать как объект, в котором вызывается
	 * метод sameTemp или lessThanTemp, а вторым аргументом является аргумент самого метода
	 * sameTemp или lessThanTemp.
	 */
}

/*
 * Ссылаться можно и на обобщенные методы. В следующем классе представлен
 * обобщенный метод, на который мы сошлемся далее.
 */

class MyArrayOps {
	
	static <T> int countMatching(T[] vals, T v)
	{
		int count = 0;
		
		for (int i = 0; i < vals.length; i++)
		{
			if (vals[i] == v) count++;
		}
		
		return count;
	}
	
} // class MyArrayOps

public class HighTemp {
	
	/*
	 * Этот класс предоставляет счетчик, который выполняет подсчет объектов
	 * по указанному критерию.
	 * 
	 * MyFunc - функция, реализующая критерий
	 */
	
	static<T> int counter(T[] values, MyFunc<T> f, T v)
	{
		int count = 0;
		
		for (int i = 0; i < values.length; i++)
		{
			/*
			 * В условии производится вызов метода по ссылке
			 * Здесь запись следует понимать как
			 * 
			 * f.func([экземпляр, в котором f вызывается], [аргумент f])
			 */
			if (f.func(values[i], v)) count++;
		}
		
		return count;
	}
	
	/*
	 * Этот метод принимает ссылки на обобщенные методы
	 */
	static <T> int MyOp(MyFunc1<T> f, T[] vals, T what)
	{
		return f.func(vals, what);
	}
	
	public static void main(String[] args)
	{
		int count = 0;
		
		TempBits[] temps = {
			new TempBits(78), new TempBits(74),
			new TempBits(72), new TempBits(71),
			new TempBits(67), new TempBits(73),
			new TempBits(82), new TempBits(80)
		};
		
		/*
		 * Посчитаем сколько замеров равно 72
		 */
		count = counter(temps, TempBits::sameTemp, new TempBits(72));
		System.out.println(count);
		
		/*
		 * Посчитаем сколько замеров меньше 80
		 */
		count = counter(temps, TempBits::lessThanTemp, new TempBits(80));
		System.out.println(count);
		
		/*
		 * Если метод переопределен, то реализацию из суперкласса
		 * можно вызвать через
		 * 
		 * super::имя
		 */
		
		/*
		 * В следующем примере мы сошлемся на обобщенный метод
		 */
		Integer[] vals = {1,2,3,4,5,6,7,8,8,8,8,8};
		String[] strs = {"One","One","One","Two"};
		
		/*
		 * Сколько совпадений в массиве с передаваемым значением
		 */
		count = MyOp(MyArrayOps::<Integer>countMatching, vals, 8);
		System.out.println(count);
		count = MyOp(MyArrayOps::<String>countMatching, strs, "One");
		System.out.println(count);
		
		
	}

} // class HighTemp






