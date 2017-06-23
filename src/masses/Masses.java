package masses;

import java.util.Arrays;

/*
 * В этом файле показано как работать с массивами
 */

public class Masses {

	public static void main(String[] args)
	{
		massExample();
	}
	
	
	public static void massExample()
	{
		/*
		 * Массивы в Java реализованы как классы
		 * 
		 * Чтобы создать одномерный массив, нужно создать ссылку
		 * на него
		 */
		
		int[] arr, arr1;
		
		/*
		 * или так
		 */
		
		int arr2[] = {41,2,-3};
		
		/*
		 * В первом случае вы можете объявить сразу несколько ссылок, используя
		 * квадратные скобки один раз.
		 * 
		 * Чтобы создать массив, нужно вызвать конструктор. Во втором примере
		 * мы назначили значения для массива сразу же.
		 */
		
		arr = new int[3];
		arr1 = new int[4];
		
		System.out.println("Размер массива arr = " + arr.length);
		printMassOneDim(arr);
		System.out.println("Размер массива arr1 = " + arr1.length);
		printMassOneDim(arr1);
		System.out.println("Размер массива arr2 = " + arr2.length);
		printMassOneDim(arr2);
		
		/*
		 * Для создания многомерного массива, нкобходимо создать массив ссылок на
		 * ссылки
		 */
		
		int arr3[][] = new int[2][2];
		/*
		 * Если бы понадобилась создать массив еще большей размерности
		 * 
		 * int arr[][][];
		 */
					
		arr3[0][0] = 1;
		arr3[0][1] = 2;
		arr3[1][0] = 3;
		arr3[1][1] = 4;
		
		/*
		 * Этот массив можно было проинициализировать так
		 * 
		 * {{1,2},{3,4}}
		 */
		
		printMassTwoDim(arr3);
		
		/*
		 * Многомерные массивы могут быть неквадратными, т.е. каждая ссылка
		 * массива может указывать на массив произвольного размера
		 */
		
		int arr4[][] = new int[3][];
		
		arr4[0] = new int[1];
		arr4[1] = new int[2];
		arr4[2] = new int[3];
		
		for (int i = 0; i < arr4.length; i++ )
		{
			for (int j = 0; j < arr4[i].length; j++ )
			{
				arr4[i][j] = 1;
			}
		}
		printMassTwoDim(arr4);
		for (int[] fDim : arr4)
		{
			for (int j = 0; j < fDim.length; j++)
			{
				 fDim[j] = 4;
			}
		}
		printMassTwoDim(arr4);
		
		/*
		 * Для работы с массивами в библиотеке Java используется класс Arrays из пакета java.util
		 * 
		 * Методы общего назначения
		 * 
		 * copyOf - копирование массива
		 * copyOfRange - копирование части массива
		 * toString - преобразует все элементы массива в одну строку
		 * sort - сортирует массив алгоритмом быстрой сортировки
		 * binarySearch - выполняет поиск в массиве методом бинарного поиска
		 * fill - заполняет массив стандартным значением
		 * equal - проверяет идентичность массивов (массивы идентичны, если их типы одинаковы
		 * и соответсвтующие элементы равны по значению
		 * deepEqual - проверяет на идентичность массивы массивов
		 * asList - возвращает массив как коллекцию
		 */
		
		Arrays.sort(arr2);
		System.out.println("Сортировка массива:");
		printMassOneDim(arr2);
		
		System.out.println("Копирование одномерного массива:");
		int arr5[] = Arrays.copyOf(arr2, 4);
		printMassOneDim(arr5);
		
		System.out.println("Копирование диапазона одномерного массива:");
		arr5 = Arrays.copyOfRange(arr5, 0, 2);	// второй аргумент - с какого индекса начинать,
												// третий аргумент - сколько элементов копировать, включая
												// выбранный
		printMassOneDim(arr5);
		
		System.out.println("Вывод массива строкой:");
		System.out.println(Arrays.toString(arr5));
		
		System.out.println("Вывод многомерного массива строкой:");
		System.out.println(Arrays.deepToString(arr3));
		
		System.out.println("Заполнение массива методом fill:");
		Arrays.fill(arr2, 88);
		printMassOneDim(arr2);
		
		/*
		 * Работа с частями массива
		 * 
		 * Один массив можно скопировать в другой, частично или полностью методом
		 * arraycopy()
		 * 
		 * или объеденить методом
		 * concat()
		 */
	}
	
	static void printMassOneDim(int[] arr)
	{
		if (null != arr)
		{
			for (int el : arr)
			{
				System.out.print(el + " ");
			}
			System.out.print("\n");
		}
	}
	
	static void printMassTwoDim(int[][] arr)
	{
		if(null != arr)
		{
			for (int[] fDim : arr)
			{
				for (int sDim : fDim)
				{
					System.out.print(sDim + " ");
				}
				System.out.print("\n");
			}
		}
	}
	
}
