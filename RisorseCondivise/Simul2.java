public class Simul2{
	public static void main(String args[]){
		Risorsa risorsa1 = new Risorsa("Risorsa1");
		Risorsa risorsa2 = new Risorsa("Risorsa2");
		Task task1 = new Task("Task1", new Risorsa[]{risorsa1, risorsa2});
		Task task2 = new Task("Task2", new Risorsa[]{risorsa1, risorsa2});
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		thread1.start();
		thread2.start();
		
		try{
			thread1.join();
			thread2.join();
		}catch(InterruptedException e){}
	}
}
