package generics;

/*
 * В Java разрешается создавать обобщенные методы. Причем эти методы
 * как могут входить, так могут и не входить в обобщенный класс.
 */

public class Methods {
	static void Show()
	{
		// Для примера мы создадим числовой массив
		Integer nums[] = {1, 2, 3, 4, 5};
		
		//теперь воспользуемся методом, чтобы выяснить, находится ли число внутри
		int a = 3;
		if (GenMeth.isIn(a, nums))
			System.out.println(a + " присутствует в массиве");
		
		a = 23;
		if (!GenMeth.isIn(a, nums))
			System.out.println(a + " отсутствует в массиве");
		
		// Тоже самое мы можем проделать и с другим типом
		String strs[] = {
			"Один",
			"Два",
			"Три"
		};
		
		if (GenMeth.isIn("Один", strs))
			System.out.println("Один" + " присутствует в текстовом массиве");
		
		/*
		 * Логично, что типы должны быть совместимы, т.е. следующий вызов является
		 * ошибочным
		 */
		// if (GenMeth.isIn("Один", nums))
		//		System.out.println("Один" + " присутствует в массиве");
		
		/*
		 * Вызов обобщенного конструктора
		 * 
		 * Обратите внимание, что нам не обязательно уточнять обобщение, так
		 * как оно выводится из контекста, однако, явное уточнение не является ошибкой
		 */
		GenMeth test = new GenMeth(100);
		test.printVal();
		
		/*
		 * Ниже представлен класс, который реализует обобщенный метод
		 */
		Integer testNums[] = {3,6,-2,3,9};
		Character testChars[] = {'a','y','z','k','l'};
		
		GenIfsClass<Integer> testIfsClass_Int = new GenIfsClass<Integer>(testNums);
		GenIfsClass<Character> testIfsClass_Ch = new GenIfsClass<Character>(testChars);
		
		/*
		 * Найдем минимум и максимум для числового массива
		 */
		System.out.println("Минимум и максимум в числовом массиве");
		System.out.println(testIfsClass_Int.min());
		System.out.println(testIfsClass_Int.max());
		
		/*
		 * Найдем минимум и максимум для символьного массива
		 */
		System.out.println("Минимум и максимум в символьном массиве");
		System.out.println(testIfsClass_Ch.min());
		System.out.println(testIfsClass_Ch.max());
		
	}
} // class Methods

/*
 * Следующий класс объявляет методы, позволяющие проверить, содержится
 * ли объект в массиве.
 */

class GenMeth {
	
	/*
	 * Следующий пример демонстрирует обобщенный метод. Список обобщений
	 * всегда должен предшествовать типу, возвращаемому методом.
	 * 
	 * В этот метод мы должны передать целевой массив y и объект,
	 * совместимый с типом, хранимым в этом массиве
	 */
	static<T extends Comparable<T>, V extends T>
	boolean isIn(T x, V[] y) {
		
		for (int i = 0; i < y.length; i++)
		{
			if (x.equals(y[i]))
				return true;
		}
		
		return false;
	}
	
	/*
	 * Следующий пример демонстрирует обобщенный конструктор
	 */
	
	private double val;
	<T extends Number> GenMeth(T arg) {
		val = arg.doubleValue();
	}
	
	void printVal()
	{
		System.out.println(val);
	}
	
} // class GenMeth

/*
 * Обобщать можно также интерфейсы
 */
interface MinMax<T extends Comparable<T>> {
	T min();
	T max();
}

// Класс, реализующий обобщенный интерфейс
/*
 * Обратите внимание, что класс реализующий обобщенный интерфейс, как правило, сам
 * обобщен в той части, которая необходима для разрешения обобщения
 * интерфейса. В данном случае обобщение класса оправдано и логично, чтобы случайно не передать
 * в интерфейс типа, который он не должен поддерживать. 
 */
class GenIfsClass <T extends Comparable<T>> implements MinMax<T> {
	
	T[] vals;
	
	GenIfsClass(T[] o) {
		vals = o;
	}
	
	/*
	 * Поиск минимума в массиве
	 * 
	 */
	@Override
	public T min() {
		T temp = vals[0];
		
		for (int i = 1; i < vals.length; i++)
		{
			if (vals[i].compareTo(temp) < 0)
				temp = vals[i];
		}
		
		return temp;
	}

	/*
	 * Поиск максимума в массиве
	 * 
	 */
	@Override
	public T max() {
		T temp = vals[0];
		
		for (int i = 1; i < vals.length; i++)
		{
			if (vals[i].compareTo(temp) > 0)
				temp = vals[i];
		}
		
		return temp;
	}
	
} // class GenIfsClass