package pl;

/*
 * Этот класс из того же пакета, но не являющийся подклассом.
 */

public class SamePackage {
	public SamePackage() {
		// Мы имеем доступ к классам одного пакета
		Protection p = new Protection();
		System.out.println("Конструктор этого же пакета");
		
		// мы имеем доступ к переменным, которые имеют видимость по умолчанию, в том же пакете
		System.out.println("n = " + p.n);
		
		System.out.println("n_pro = " + p.n_pro);
		System.out.println("n_pub = " + p.n_pub);
	}
}
