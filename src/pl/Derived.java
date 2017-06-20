package pl;

/*
 * Класс Derived наследует класс Protection того же пакета
 * ему доступные все члены суперкласса с видимостью public и
 * protected.
 * 
 */

public class Derived extends Protection {
	Derived() {
		System.out.println("Конструктор подкласса");
		System.out.println("n_pro = " + n_pro);
		System.out.println("n_pub = " + n_pub);
	}
}
