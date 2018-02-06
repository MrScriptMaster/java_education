package generics;

/*
 * Обобщением в Java называется параметризованный класс. Шаблоны в языке С++ являются
 * в некотором роде обобщениями, если переходить на терминологию языка Java. Однако, в С++
 * шаблоны несколько ограничены и менее понятны, чем в Java, и их похожесть лежит только
 * на поверхности, но не в реализации.
 * 
 * Обобщения в Java используются в первую очередь для создания типовой безопасности, чтобы
 * исключить возможность обращения к объектам разнородных классов через их
 * суперкласс. Кроме того, обобщения позволяют усилить абстрагирование уже на уровне объявления классов.
 */

/*
 * Чтобы создать обобщение, следует использовать следующий синтаксис
 * 
 * class<[обощаемые типы]> {}
 * 
 * В следующем примере мы определили один обобщаемый тип - Т. Везде, внутри класса, где
 * встречается имя Т, будет происходить замена на конкретный тип, когда мы порождаем
 * экземпляр обобщенного класса.
 * 
 * В отличие от языка С++ обобщения не порождают разные классы, а используя один класс, удаляют все сведения
 * об обобщенном типе внутри и используют неявные преобразования типов, когда он указывается при объявлении
 * конкретного экземпляра.
 * 
 */
public class Generic<T> {
	T value;
	
	void showType()
	{
		System.out.println("Тип обобщения: " + value.getClass().getTypeName());
	}
	
	/*
	 * На основе обобщенного типа пишутся обобщенные методы
	 */
	T getValue()
	{
		return value;
	}
	
	public Generic(T val)
	{
		value = val;
	}
} // class Generic

/*
 * Обобщить можно несколько типов, если перечислить их через запятую
 */

class GenericWithTwo<T,V> {
	T ob1;
	V ob2;
	
	public void showTypes()
	{
		System.out.println("Тип обобщения 1: " + ob1.getClass().getTypeName());
		System.out.println("Тип обобщения 2: " + ob2.getClass().getTypeName());
	}
	
	T getValue1()
	{
		return ob1;
	}
	
	V getValue2()
	{
		return ob2;
	}
	GenericWithTwo(T val1, V val2)
	{
		ob1 = val1;
		ob2 = val2;
	}
} // class GenericWithTwo

/*
 * Иногда нужно сообщить, какие типы можно обобщать при объявлении экземпляра, а какие нельзя.
 * Например, не имеет смысла обобщать текстовые строки, если класс и все его методы могут работать
 * только с числами.
 * 
 * Такие обобщения называются "ограниченными". В следующем примере, мы ограничили обобщение только числами.
 * Чтобы показать ограниченность, используется ключевое слово extends.
 */
class CalcAverage<T extends Number> {
	private T[] nums;
	
	public CalcAverage(T[] numbers) {
		nums = numbers;
	}
	
	public double average()
	{
		double sum = 0.0;
		
		for (int i = 0; i < nums.length; i++)
		{
			sum += nums[i].doubleValue();
		}
		
		return sum / nums.length;
	}
/*
 * Иногда возникают ситуации, когда в метод класса с обобщением требуется передавать объекты
 * класса с обобщением. Взникает вопрос при объявлении метода, обобщение какого типа нужно
 * использовать в передаваемом объекте? Ведь это еще объявление и это не очевидно.
 * 
 * В таких ситуациях используются метасимвольные аргументы для обобщения.
 * 
 * Метасимвольный аргумент говорит, что мы можем передавать любой экземпляр класса CalcAverage, независимо
 * от того, какой тип обобщен в параметре класса.
 */	
	
	boolean sameAvg(CalcAverage<?> ob)
	{
		if (average() == ob.average())	return true;
		
		return false;
	}
	
} // class CalcAverage

/*
 * Метасимвольный аргумент также может быть ограничен сверху и/или снизу, чтобы пресекать попытки
 * передачи несовместимых обобщений.
 * 
 * В этом примере у нас есть 3 класса, которые реализуют точку в пространствах разной размерности.
 * У нас также есть класс, способный выводить эти точки.
 * 
 */

class Point<T extends Number> {
	T x,y;
	
	Point(T coord_x, T coord_y)
	{
		x = coord_x;
		y = coord_y;
	}
	
	public String show()
	{
		String new_str = new String(x + " " + y);
		return new_str;
	}
} // class Point

class Point_3d extends Point {

	Number z;
	Point_3d(Number coord_x, Number coord_y, Number coord_z) {
		super(coord_x, coord_y);
		z = coord_z;
	}
	
	public String show()
	{
		String new_str = super.show();
		new_str += " " + z;
		
		return new_str;
	}
} // class Point_3d

class Point_4d extends Point_3d {

	Number z1;
	Point_4d(Number coord_x, Number coord_y, Number coord_z, Number coord_z1) {
		super(coord_x, coord_y, coord_z);
		z1 = coord_z1;
	}
	
	public String show()
	{
		String new_str = super.show();
		new_str += " " + z1;
		
		return new_str;
	}
} // class Point_4d

/*
 * Следующий класс работает с абстракцией точки (включая все подклассы).
 */
class Coords<V extends Point<?>> {
	
	V[] point_mass;
	
	Coords(V[] o)
	{
		point_mass = o;
	}
}

/*
 * Следующий класс предоставляет методы, которые выводят координаты.
 */
class CoordShow {
	
	/*
	 * Этот метод выводит координаты x и y каждой точки в массиве.
	 */
	public static void showXY(Coords<?> c)
	{
		System.out.println("Координаты X и Y:");
		for (int i = 0; i < c.point_mass.length; i++)
		{
			System.out.println(c.point_mass[i].x + " " + c.point_mass[i].y);
		}
		System.out.println();
	}
	
	/*
	 * Этот метод нарочно огранчивается приемом только точек с тремя координатами.
	 */
	public static void showXYZ(Coords<? extends Point_3d> c)
	{
		System.out.println("Координаты X, Y, Z:");
		for (int i = 0; i < c.point_mass.length; i++)
		{
			System.out.println(c.point_mass[i].x + " " + c.point_mass[i].y + " " + c.point_mass[i].z);
		}
		System.out.println();
	}
	
	/*
	 * Этот метод нарочно ограничивается только приемом точек с четырьмя координатами.
	 */
	public static void show4D(Coords<? extends Point_4d> c)
	{
		System.out.println("Координаты X, Y, Z и Z1:");
		for (int i = 0; i < c.point_mass.length; i++)
		{
			System.out.println(c.point_mass[i].x + " " + c.point_mass[i].y + " " + c.point_mass[i].z + " " + c.point_mass[i].z1);
		}
		System.out.println();
	}
	/*
	 * Этот метод нарочно ограничивается только приемом точек с двумя координатами, но немного необычно.
	 * Он ограничивает себя по нижней границе.
	 * 
	 * Так как класс Coord ограничивает себя только подклассами Point, включая его самого, то мы можем
	 * ограничиться по нижней границе ледующим образом: ключевое слово super означает, что принимать можно
	 * только суперклассы данного класса (в нашем примере это Point_3d). При этом сам Point_3d тоже будет исключаться.
	 */
	public static void show2D(Coords<? super Point_3d> c)
	{
		System.out.println("Координаты X, Y:");
		for (int i = 0; i < c.point_mass.length; i++)
		{
			System.out.println(c.point_mass[i].x + " " + c.point_mass[i].y);
		}
		System.out.println();
	}
}

