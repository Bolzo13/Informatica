import java.util.concurrent.Semaphore;

public class Risorsa{
	public Semaphore semaphore;
	private String name;
	
	public Risorsa(String name){
		semaphore = new Semaphore(1, true);
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
