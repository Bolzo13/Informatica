import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.*;

public class Bus{
	public static final int NUMERO_POSTI = 3;
	private Lock sezioneCritica;
	private Semaphore postiLiberi;
	private Semaphore postiOccupati;
	private Passeggero[] passeggeri;
	private int stopNumber;
	private String name;
	
	public Bus(String name){
		postiLiberi = new Semaphore(NUMERO_POSTI);
		postiOccupati = new Semaphore(0);
		sezioneCritica = new ReentrantLock();
		passeggeri = new Passeggero[NUMERO_POSTI];
		int stopNumber = -1;
		this.name = name;
	}
	public int getStop(){
		return stopNumber;
	}
	public boolean sale(Passeggero passeggero){
		int i;
	    boolean salito=false;
		sezioneCritica.lock();
		if(postiLiberi.tryAcquire()){
		    salito=true;
		    passeggero.setBus(this);
            for(i=0; passeggeri[i] != null; i++);
            passeggeri[i] = passeggero;
			postiOccupati.release();
        }
        sezioneCritica.unlock();
		return salito;
	}
	public void scende(Passeggero passeggero){
		int i;
		sezioneCritica.lock();
			postiOccupati.tryAcquire();
			for(i=0; passeggeri[i].getName()!=passeggero.getName(); i++);
			passeggeri[i] = null;
			postiLiberi.release();
			passeggero.setBus(null);
		sezioneCritica.unlock();
	}
	
	public void fermata(){
		stopNumber++;
		for(int i=0; i<NUMERO_POSTI; i++){
			if(passeggeri[i] !=  null) passeggeri[i].interrupt();
		}
	}
}
