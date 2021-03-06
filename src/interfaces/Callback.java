package interfaces;

/*
 * В этом файле приведен пример интерфейса. Интерфейсы похожи на классы, но
 * в отличие от классов они не оговаривают реализацию, а только диктуют
 * что в ней должно быть.
 * 
 * Класс, который реализует интерфейст, должен определить все методы, которые он
 * продиктовал.
 * 
 * До версии Java 8 интерфейсы вообще не могли иметь никакой реализации.
 * В Java 8 существует возмжность частично задавать реализацию по умолчанию.
 * 
 * Интерфейсы могут хранить переменные, которые объявляются как final и static,
 * т.е. должны быть проинициализированы.
 * 
 * Один исходный файл пакета может иметь только один публичный интерфейс, т.е.
 * правила для интерфейсов подобны правилам для классов.
 */

public interface Callback {
	void callback(int param);
}

/*
 * Один интерфейс может быть вложен в другой интерфейс или класс. Вложенный интерфейс может быть
 * объявлен как public, private, protected.
 * 
 */

/*
 * Один интерфейс может расширить другой интерфейс. При этом класс, который
 * наследует расширенный интерфейс, должен реализовать методы как и интерфейса-
 * родителя, так и интрефейса, расширевшего исходный.
 */

interface MoreThanCallback extends Callback {
	void callback_new(int param);
	
	/*
	 * Интерфейсы могут иметь константы, которые могут наследоваться классами.
	 * На практике эта методика считается сомнительной, однако, так делать
	 * можно.
	 */
	int NO = 0;
	int YES = 1;
	
	/*
	 * В Java 8 можно в интерфейсе объявлять методы по умолчанию. Это главным
	 * образом используется, чтобы заглушить некоторые методы в интерфейсе,
	 * если их реализация в классе не нужна.
	 */
	
	default int def_method()
	{
		return 0;
	}
	
	/*
	 * В Java невозможно реализовать множественное наследование, но возможно
	 * сделать нечто похожее через интерфейсы.
	 * 
	 * Если класс реализует метод интерфейса, для которого имеется реализация
	 * по умолчанию, то предпочтение отдается реализации класса.
	 * 
	 * Если в классе реализуется два интерфейса с методом по умолчанию, но
	 * при это метод не переопределяется в классе, то возникнет ошибка 
	 * компиляции.
	 * 
	 * Если один метод наследует другой и в обоих из них определяется общий
	 * метод по умолчанию, предпочтение отдается методу из наследующего
	 * интерфейса. Впрочем, реализацию из базового интерфейса можно
	 * вызвать, если реализовать синтаксис
	 * 
	 * Базовый_интерфейс.super.общий_метод()
	 */
}