import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 *
 * @author simone.bolzonella
 */
public class Test {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Mappa p = new Mappa();
		p.load("stops.csv");
		PuntoMappa close = p.search(45.19,12.73);
		System.out.println("Sei vicino a "+close.nomeFermata);
	}	
}
