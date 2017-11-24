import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.Random;
/**
 * Created by simone
 */
public class Bus extends Thread{

    private Random nRandom = new Random();
    private Semaphore semaphore;
    private int maxPasseggeri;
    private int nFermate = 6;
    private int fermataControllore;
    private int tempoFermata = 10;

    Bus(int maxPasseggeri){
        this.maxPasseggeri = maxPasseggeri;
        semaphore = new Semaphore(maxPasseggeri);
    }

    @Override
    public void run(){
        fermataControllore = nRandom.nextInt(nFermate);
        for(int i=0; i<nFermate; i++){

            System.out.println("Fermata numero "+(i+1)+" di "+nFermate);

            //Random passeggeri che scendono
            int randomPass = nRandom.nextInt(maxPasseggeri);
            //Faccio scendere passeggeri
            for(int j=0; j<randomPass; j++){
                if(semaphore.availablePermits() < maxPasseggeri) {
                    System.out.println("Sceso passeggero numero " + (maxPasseggeri - semaphore.availablePermits()));
                    semaphore.release();
                }
            }

            if(i+1 < nFermate){
                //Random di passeggeri che montano
                randomPass = nRandom.nextInt(maxPasseggeri);

                //Faccio salire passeggeri
                for(int j=0; j<randomPass; j++){
                    try {
                        semaphore.acquire();
                        System.out.println("Salito passeggero numero "+(maxPasseggeri-semaphore.availablePermits()));
                    } catch (InterruptedException ex) {
                    }
                }
            }

            if(i+1 == fermataControllore){
                Thread controllore = new Thread(new Controllore(semaphore, maxPasseggeri));
                controllore.start();
                try {
                    controllore.join();
                } catch (InterruptedException e) {}
            }

            try {
                TimeUnit.SECONDS.sleep(tempoFermata);
            } catch (InterruptedException ex) {}
        }
    }
}

private class Controllore extends Thread{

    private Semaphore s;
    private int p;

    Controllore(Semaphore s, int p){
        this.s = s;
        this.p = p;
    }

    @Override
    public void run(){
        System.out.println("Controllore! I passeggeri sono i seguenti:");
        int i;
        for(i = 0; i<p-s.availablePermits()-1; i++)
            System.out.print("Passeggero"+(i+1)+", ");
        System.out.print("Passeggero"+(i+1)+"\n");
    }

}