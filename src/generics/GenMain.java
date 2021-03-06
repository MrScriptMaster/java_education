package generics;

public class GenMain {

	public static void main(String[] args) {
		/*
		 * Создадим экземпляр обощенного класса
		 */
		Generic<Integer> Iob = new Generic<Integer>(88);
		System.out.println("Значение в обобщенном  классе: " + Iob.getValue());
		Iob.showType();
		
		// Мы можем пользоваться также автораспаковкой
		int i = Iob.getValue();
		System.out.println("Значение в обобщенном  классе: " + i);
		/*
		 * Наше обобщение может хранить не только числа
		 */
		Generic<String> Str = new Generic<String>("Привет");
		System.out.println("Значение в обобщенном  классе: " + Str.getValue());
		Str.showType();
		/*
		 * В отличие от языка С++, обобщать примитивные типы в Java нельзя
		 * 
		 * Generic<int> Iob; // ЭТО ОШИБКА
		 * 
		 * Обобщать можно только ссылочные типы данных. Поэтому для обобщения
		 * примитивных типов следует использовать их оболочки.
		 * 
		 * Ссылки на экземпляры с разными обобщенными типами НЕСОВМЕСТИМЫ, например,
		 * следующее присваивание ошибочно
		 * 
		 * Iob = Str; // ЭТО ОШИБКА
		 */
		
		/*
		 * Создадим экземпляр обобщенного класса с большим числом обобщенных типов
		 */
		GenericWithTwo<Integer,String> gen2 = new GenericWithTwo<Integer,String>(12,"Привет");
		gen2.showTypes();
		
		/*
		 * Создадим экземпляр ограниченного обобщенного метода.
		 */
		Integer nums[] = {1, 2, 3, 4, 5};
		CalcAverage<Integer> av = new CalcAverage<Integer>(nums);
		System.out.println("Среднее значение: " + av.average());
		/*
		 * При этом мы не можем обобщить никакой тип, который не является потомком
		 * Number.
		 * 
		 * ЭТО ОШИБКА
		 */
		//CalcAverage<String> av1;
		
		/*
		 * Следующие примеры посвящены обобщениям с ограничениями.
		 */
		// Создаем точки с двумя координатами
		Point[] td = {
			new Point(0,0),
			new Point(12,3),
			new Point(6,-4),
			new Point(13.25,11)
		};
		// Создаем точки с четырьмя координатами
		Point_4d[] fd = {
			new Point_4d(1, 2, 3, 4),
			new Point_4d(5, 6, 7, 8),
			new Point_4d(9, 10, 11, 12),
			new Point_4d(13, 14, 15, 16)
		};
		// Создаем класс, который хранит координаты
		Coords<Point> two_dim = new Coords<Point>(td);
		Coords<Point_4d> four_dim = new Coords<Point_4d>(fd);
		
		/*
		 * Теперь рассмотрим, какие методы класса CoordShow применимы, а какие нет
		 */
		System.out.println("Вывод двумерных координат:");
		CoordShow.showXY(two_dim);		// Можно
		CoordShow.show2D(two_dim);		// Можно
		//CoordShow.showXYZ(two_dim);	// Нельзя, потому что мы ограничены классом Point_3d сверху
		//CoordShow.show4D(two_dim); 	// Нельзя, потому что мы ограничены классом Point_4d сверху
		System.out.println();
		
		System.out.println("Вывод четырехмерных координат:");
		CoordShow.showXY(four_dim);		// Можно
		//CoordShow.show2D(four_dim);	// Нельзя, потому что мы ограничены снизу по классу Point_3d
		CoordShow.showXYZ(four_dim);	// Можно
		CoordShow.show4D(four_dim);		// Можно
		System.out.println("------ конец секции обобщения с ограничениями ------");
		
		/*
		 * Обобщенные методы
		 */
		Methods.Show();
		
		/*
		 * Обобщенные иерархии наследования
		 */
		Inheritanse.Show();
		
		/*
		 * Ограничения, связанные с обобщениями:
		 * 
		 * 1. Получить экземпляр по параметру типа нельзя
		 * 
		 * class Gen<T> {
		 * 	  T ob;
		 * 
		 *    Gen() {
		 *    	ob = new T();		// НЕЛЬЗЯ
		 *    }
		 * }
		 * 
		 * 2. Параметр типа всего класса нельзя использовать в статических переменных и в статических
		 * методах, за исключением правил создания обобщения для отдельного метода.
		 * 
		 * class Gen<T> {
		 * 		static T ob;	// НЕЛЬЗЯ
		 * 
		 * 		// НЕЛЬЗЯ
		 * 		static T getob()
		 * 		{
		 * 			return ob;
		 * 		}
		 * }
		 * 
		 * 3. Нельзя создать массив по обобщаемому типу, если тип неизвестен.
		 * 
		 * class Gen<T> {
		 * 		T [] vals;
		 * 
		 * 		Gen()
		 * 		{
		 * 			vals = new T[10];	// НЕЛЬЗЯ
		 * 		}
		 * }
		 * 
		 * 4. Нельзя создать массив специфических для типа обобщенных ссылок
		 * 
		 * 	 Gen<Integer> gens[] = new Gen<Integer>[10];	// НЕЛЬЗЯ
		 * 	 
		 * 	 // но вот так, можно
		 *   Gen<?> gens[] = new Gen<?>[10];
		 *   
		 * 5. Обобщать любые подклассы Throwable нельзя.
		 */
		
		
	}

}
