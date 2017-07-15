package lambda;

/*
 * Лямбда-выражение - это анонимный метод, который объявлен и действует в другом
 * методе.
 * 
 * Лямбда-выражение может быть использовано в контексте присваивания функциональным
 * интерфейсам, т.е. таким, которые объявляют один метод.
 */

interface IfsNumber {
	double getNumber();
}

/*
 * Для лямбда-выражения с одним аргументом
 */
interface IfsIsEven {
	boolean isEven(int n);
}

interface IfsFunc {
	int func(int n);
}

/*
 * Обобщенный функциональный интерфейс.
 */
interface SomeFunc<T> {
	T func(T param);
}

interface StringFunc {
	String func(String str);
}

class ExampleExcept extends Exception {
	
	public ExampleExcept() {
		super("Example Exception");
	}
}

interface IfsWithExc {
	void throwExc() throws ExampleExcept;
}

public class Lambda {
	
	public static void main(String[] args)
	{
		// Создаем ссылку на функциональный интерфейс.
		IfsNumber num;
		
		// присваиваем ссылке лямбда-выражение
		num = () -> 888;
		/*
		 * Здесь лямбда выражение находится справа от равно. В скобках
		 * указываются параметры, а после оператора -> устанавливается блок
		 * из действий. В данном случае одно действие эквивалентно инструкции
		 * return 888;
		 * 
		 * Когда мы присваиваем ссылке функциональный интерфейс, то
		 * автоматически создается объект и реализация метода getNumber().
		 * 
		 * Чтобы это было возможно, количество и типы аргументов должны
		 * совпадать с аргументами в скобках лямбда-выражения.
		 */
		
		/*
		 * Теперь мы можем вызвать наш метод.
		 */
		
		System.out.println(num.getNumber());
		
		/*
		 * Следующее лямбда-выражение имеет один аргумент.
		 * 
		 * Вы можете не указывать тип аргументов, так как тип выводится
		 * из контекста. Тем не менее, его можно показать явно и это не
		 * будет ошибкой.
		 */
		// IfsIsEven NumTester = (int n) -> (n % 2) == 0;
		IfsIsEven NumTester = (n) -> (n % 2) == 0;
		
		if (NumTester.isEven(10))
			System.out.println("Число четное");
		
		if (!NumTester.isEven(11))
			System.out.println("Число нечетное");
		
		/*
		 * Лямбда-выражение может состоять из нескольких инструкций, если
		 * их заключить в блок фигурных скобок. Такой блок обязательно
		 * должен содержать инструкцию return
		 */
		IfsFunc factorial = (n) ->
		{
			int result = 1;
			for (int i = 1; i <= n; i++)
			{
				result *= i;
			}
			return result;	
		};
		
		System.out.println(factorial.func(5));
		
		/*
		 * Обобщить лямбда-выражение напрямую нельзя, но вы можете
		 * обобщить функцийональный интерфейс, на основе котрого оно строится.
		 */
		SomeFunc<String> reverse = (str) ->
		{
			String result = "";
			for (int i  = str.length()-1; i >= 0; i--)
			{
				result += str.charAt(i);
			}
			
			return result;
		};
		
		SomeFunc<Integer> factor = (n) ->
		{
			int result = 1;
			for (int i = 1; i <= n; i++)
			{
				result *= i;
			}
			return result;
		};
		
		System.out.println(reverse.func("Прямо"));
		System.out.println(factor.func(4));
		
		/*
		 * Лямбда выражение может быть передано в качестве аргумента.
		 * Для этого метод должен уметь принимать ссылки на функциональный
		 * интерфейс, на основе которого это выражение строится.
		 * 
		 * В языке С++ такой подход реализуют так называемые функторы.
		 */
		String targetString = "Строка для тестирования лямбда-выражений";
		String outStr = "";
		
		// Это лямбда-выражение преобразует все символы строки в верхний регистр
		outStr = StringOp((str) -> str.toUpperCase(), targetString);
		System.out.println(outStr);
		
		// Это лямбда-выражение удаляет пробелы в строке
		outStr = StringOp((str) -> 
						  {
							  String  res = "";
							  int i;
							  for (i = 0; i < str.length(); i++)
								  if (str.charAt(i) != ' ')
									  res += str.charAt(i);
							  return res;
						  }, targetString);
		System.out.println(outStr);
		
		// Это лямбда выражение объявлено отдельно и позже будет передано в аргументе
		StringFunc rev = (str) ->
		{
			String result = "";
			for (int i  = str.length()-1; i >= 0; i--)
			{
				result += str.charAt(i);
			}
			
			return result;
		};
		
		System.out.println(StringOp(rev,targetString));
		
		/*
		 * Лямбда выражения могут возвращать исключения, при этом
		 * в throws функционального метода нужно обязательно их указывать.
		 */
		
		try
		{
			IfsWithExc ex = () -> 
			{
				throw new ExampleExcept();
			};
			
			ex.throwExc();
		}
		catch (ExampleExcept e)
		{
			System.out.println(e);
		}
	}
	
	/*
	 * Для демонстрации передачи лямбда-функции методу.
	 */
	static String StringOp(StringFunc lam, String str)
	{
		return lam.func(str);
	}
}
