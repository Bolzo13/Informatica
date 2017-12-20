import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Task implements Runnable{
	private String name;
	private Random random;
	private Risorsa[] risorse;
	
	public Task(String name, Risorsa[] risorse){
		this.name = name;
		this.risorse = risorse;
		random = new Random((new Date()).getTime());
	}
	
	
	@Override
	public void run(){
		int indice = 0;
		while(indice <= risorse.length){
			try{
				if(indice < risorse.length){
					System.out.println("[" + name + "]Provo ad accedere a \"" + risorse[indice].getName() + "\"");
					risorse[indice].semaphore.acquire(); //apertura risorsa numero indice
					System.out.println("[" + name + "]Accedo a \"" + risorse[indice].getName() + "\"");
				}
			} catch(InterruptedException e){
				
			}
			if(indice < risorse.length && indice > 0){
				//operazioni su entrambe le risorse apert
				System.out.println("[" + name + "]Eseguo operazioni su \"" + risorse[indice-1].getName() + "\" e \"" + risorse[indice].getName() + "\"");
			}			
			if(indice > 0){
				risorse[indice-1].semaphore.release(); //chiusura risorsa numero indice-1
				System.out.println("[" + name + "]Chiudo \"" + risorse[indice-1].getName() + "\"");
			}
			if(indice < risorse.length){
				//operazioni solo su una risorsa
				System.out.println("[" + name + "]Eseguo operazioni su \"" + risorse[indice].getName() + "\"");
			}
			indice++;
		}
	}
}
