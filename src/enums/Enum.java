package enums;

/*
 * Перечисления в Java, в отличие например от того же С/С++, реализованы через классы.
 * При первом рассмотрении это не так очевидно. Тем не менее, на перечисления наложено
 * много ограничений, поэтому можно сказать, что это не полный класс.
 */

public class Enum {

	/*
	 * Чтобы создать перечисление нужно использовать ключевое слово enum.
	 */
	
	enum Weapon {
		Stone,		// Для этого элемента будет вызван конструктор без аргументов
		Sword(30),	// Для этого элемента мы вызываем второй конструктор
		Stick(10);	// Для этого элемента мы вызываем второй конструктор
		
		private float attack;
		
		/*
		 * Если вам нужен конструктор перечисления вы можете явно его объявить
		 */
		Weapon()
		{
			attack = 0.0f;
		}
		Weapon(float attack)
		{
			this.attack = attack;
		}
		
		/*
		 * Если вам нужны методы, вы также можете их объявить
		 */
		public float getAttack()
		{
			return attack;
		}
	} // enum Weapon
	
	public static void main(String[] args)
	{
		/*
		 * Все пункты перечисления являются объектами, который разделяют общий конструктор и общий набор 
		 * свойств и методов. Каждый объект перечисления вызывает конструктор индивидуально, когда
		 * вы объявляете ссылку на перечисление.
		 */
	
		/*
		 * Какова атака меча?
		 */
		
		System.out.println("Атака " + Weapon.Sword + " равна " + Weapon.Sword.getAttack() + "\n");
		
		/*
		 * Вы можете выводить перечисления подобно массивам, используя встроенный в перечисления
		 * метод values, который возаращает массив объектов перечисления.
		 */
		
		for(Weapon wp : Weapon.values())
		{
			System.out.println("Атака " + wp + " равна " + wp.getAttack());
		}
		
		/*
		 * Перечисления имеют метод ValueOf для получения доступа к отдельным элементам
		 * перечисления.
		 */
		
		Weapon stck = Weapon.valueOf("Stick");
		
		System.out.println("Атака " + stck + " равна " + stck.getAttack() + "\n");
		
		/*
		 * Объекты перечисления упорядочены в самом перечислении. Если вы работаете с ссылками
		 * на объекты перечисления, то вы можете их сравнивать на предмет, как в перечислении
		 * они стоят друг относительно друга.
		 */
		
		Weapon wp1,wp2;
		
		wp1 = Weapon.Stone;
		wp2 = Weapon.Stick;
		
		/*
		 * Метод CompareTo возвращает отрицательное значение, если элемент перечисления, передаваемый
		 * в аргументе стоит после; 0 - если обе ссылки указывают на одинаковый элемент перечисления;
		 * >0 - если ссылка, передаваемая в аргументе, указывает на элемент, стоящий до.
		 * 
		 * Чтобы узнать порядковый номер в перечислении, нужно воспользоваться методом ordinal().
		 */
		
		if (wp1.compareTo(wp2) < 0)
		{
			System.out.println(wp1 + " стоит до " + wp2);
		}
		else if (wp1.compareTo(wp2) > 0)
		{
			System.out.println(wp1 + " стоит после " + wp2);
		}
		else
		{
			System.out.println(wp1 + " тоже самое, что " + wp2);
		}
		
		/*
		 * Две ссылки на объекты перечисления равны, если они указывают на один и тот же объект перечисления.
		 * Это можно выяснить через метод equals() или оператор "==".
		 */
		
		wp1 = Weapon.Sword;
		wp2 = Weapon.Sword;
		
		if (wp1.equals(wp2))
		{
			System.out.println(wp1 + " тоже самое, что " + wp2);
		}
		
		if (wp1 == wp2)
		{
			System.out.println(wp1 + " тоже самое, что " + wp2);
		}
	}
	
}
