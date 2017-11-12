import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author simone.bolzonella
 */
public class Mappa {
	Lista<PuntoMappa> mappa;
	public void load(String fileName) throws FileNotFoundException {
		mappa = new Lista();
		File in = new File(fileName);
		Scanner input = new Scanner(in);
		while(input.hasNextLine()) {
			try {
				mappa.add(new PuntoMappa(input.nextLine()));
			} catch(NumberFormatException ex) {
			}
			
		}
	}
	public PuntoMappa search(double lat, double lon) {
		double distanzaMinima = Double.MAX_VALUE; 
		PuntoMappa vicino = mappa.testa.info;               
		for(Iteratore<PuntoMappa> fermata = mappa.newIterator(); fermata.inside(); fermata.goNext()) {
			double distanzaElemento;
			double latDistanza = lat - fermata.current().latitudine; 
			double lonDistanza = lon - fermata.current().longitudine;
			distanzaElemento = Math.sqrt(latDistanza * latDistanza + lonDistanza * lonDistanza); 
			if(distanzaElemento < distanzaMinima) {
				distanzaMinima = distanzaElemento; 
				vicino = (PuntoMappa)fermata.current();
			}
		}
		return vicino;
	}
}
