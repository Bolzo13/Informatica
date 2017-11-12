/**
 *
 * @author simone.bolzonella
 */
public class PuntoMappa {
	final int idFermata;
	String nomeFermata; 
	final double latitudine; 
	final double longitudine;
	
	public PuntoMappa(String line) {
		String[] riga = line.split(",");
		idFermata = Integer.parseInt(riga[0]);
		nomeFermata = riga[2];	
		latitudine = Double.parseDouble(riga[4]);
		longitudine = Double.parseDouble(riga[5]);
	}
	
}
