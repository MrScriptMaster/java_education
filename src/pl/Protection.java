package pl;

/*
 *  В этом примере демонстрируется доступность классов и их
 *  при пакетировании
 */

public class Protection {
	int n = 1;					// Этот член доступен любому классу из этого пакета
	private int n_pri = 2;		// Этот член доступен только этому классу
	protected int n_pro = 3;	// Этот член доступен этому классу и всем подклассам
	public int n_pub = 4;		// Этот член доступен всем классам в этом и внешних пакетах
	
	public Protection() {
		System.out.println("Конструктор базового класса");
		System.out.println("n = " + n);
		System.out.println("n_pri = " + n_pri);
		System.out.println("n_pro = " + n_pro);
		System.out.println("n_pub = " + n_pub);
	}
}
