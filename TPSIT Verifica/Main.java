import java.util.Random;

import static java.lang.Thread.sleep;

public class Main{
	public static final int NUMERO_FERMATE = 4;
	public static final int MAX_PERSONE_PER_FERMATA = 6;

	public static void main(String[]args) throws InterruptedException {
		Random generatore = new Random(System.currentTimeMillis());
		Passeggero[][] passeggeri = new Passeggero[NUMERO_FERMATE][];
		System.out.println("Generazione passegeri");
		for(int i=0; i<NUMERO_FERMATE; i++){
			passeggeri[i] = new Passeggero[generatore.nextInt(MAX_PERSONE_PER_FERMATA+1)];
			System.out.println("\tFermata numero " + i + " con " + passeggeri[i].length + " passegeri");
			for(int j=0; j<passeggeri[i].length; j++){
				passeggeri[i][j] = new Passeggero("Passeggero"+i+"-"+j, i, generatore.nextInt(NUMERO_FERMATE-i)+i+1);
				passeggeri[i][j].setName("Passeggero"+i+"-"+j);
				System.out.println("\t\t" + passeggeri[i][j].getName() + " generato");
			}
		}

		System.out.println("Avvio passegeri");
		for(int i=0; i<NUMERO_FERMATE; i++){
			System.out.println("\tFermata numero " + i);
			for(int j=0; j<passeggeri[i].length; j++){
				passeggeri[i][j].start();
				System.out.println("\t\t" + passeggeri[i][j].getName() + " avviato");
			}
		}
		Bus autobus = new Bus("Trenino Thomas");
		System.out.println("Partenza bus");
		for(int i=0; i<NUMERO_FERMATE; i++){
			System.out.println("\tAutobus per strada in direzione della fermata " + i);
			sleep(generatore.nextInt(1000)+1000); //aspetta tra 1 e 2 secondi
			System.out.println("\tAutobus in fermata " + i);
			autobus.fermata();
			for(int j=0; j<passeggeri[i].length; j++){
				passeggeri[i][j].setBus(autobus);
				passeggeri[i][j].interrupt();
				//System.out.println("\t\t" + passeggeri[i][j].getName() + " prova a salire");
				//if(autobus.sale(passeggeri[i][j])) System.out.println("\t\t" + passeggeri[i][j].getName() + " è salito");
				//else System.out.println("\t\t" + passeggeri[i][j].getName() + "NON è salito");
			}
			sleep(generatore.nextInt(1000)+1000); //aspetta tra 1 e 2 secondi
		}
		
	}
}
