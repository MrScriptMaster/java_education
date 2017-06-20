package pa;

/*
 * Это класс другого пакета. Этот класс не объявлен как public, поэтому он
 * доступен толко в этом пакете
 */

class OtherPackage {
	public OtherPackage() {
		// Чтобы создать объект класса пакета pl, мы уточняем имя
		
		pl.Protection p = new pl.Protection();
		
		System.out.println("Конструктор другого пакета");
		
		// В это классе нам доступен только публичный член
		System.out.println("n_pub = " + p.n_pub);
	}
}

class AnotherClassInSameFile {
	public AnotherClassInSameFile() {
		// TODO Auto-generated constructor stub
	}
}