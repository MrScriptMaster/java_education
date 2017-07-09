package threads;

/*
 * Для создания пользовательского потока необходимо реализовать интерфейс Runnable. Этот интерфейс
 * вводит один метод run(), который запускает поток на исполнение.
 * 
 * Далее поток запускается с помощью класса Thread, который работает с любыми Runnable объектами
 */

public class CustomThread implements Runnable {
	
	/*
	 * Объект класса Thread для работы с потоком
	 */
	protected Thread thread;
	
	public CustomThread() {
		
		/*
		 * Создаем экзепляр класса потока. Первый аргумент указывает на экземпляр
		 * Runnable объекта, чей метод run нужно запустить.
		 */
		thread = new Thread(this, "CustomThread");
		
		/*
		 * Запускаем поток на исполнение. Метод start запускает метод run.
		 */
		thread.start();
	}
	
	@Override
	public void run() {
		try
		{
			for (int n = 5; n > 0; n--)
			{
				System.out.println(n);
				Thread.sleep(500);
			}
			
		} catch (InterruptedException e) {
			
			/*
			 * Метод sleep может возбуждать исключение типа InterrupException, если другой поток
			 * запрашивает прерывание.
			 */
			System.out.println("Поток исполнения был прерван");
			
		}
		System.out.println("Завершился дочерний поток");
	}
}

/*
 * Тот же поток исполнения может быть создан наследованием класса Thread. Этот метод позволяет
 * переопределять некоторые методы этого класса
 */

class CustomThread_1 extends Thread {
	
	public CustomThread_1() {
		// Вызываем конструктор суперкласса
		super("CustomThread_1");
		// запускаем поток
		start();
	}
	
	public void run()
	{
		try
		{
			for (int n = 5; n > 0; n--)
			{
				System.out.println(n);
				Thread.sleep(500);
			}
			
		} catch (InterruptedException e) {
			
			/*
			 * Метод sleep может возбуждать исключение типа InterrupException, если другой поток
			 * запрашивает прерывание.
			 */
			System.out.println("Поток исполнения был прерван");
			
		}
		System.out.println("Завершился дочерний поток");
	}
}
