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
	}

}
