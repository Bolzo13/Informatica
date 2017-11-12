/**
 *
 * @author simone.bolzonella
 */
public class Test {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		AlberoBin b = new AlberoBin(5, new AlberoBin(2, null, null), new AlberoBin(3, new AlberoBin(17, null, null), null));
		Lista[] lista = new Lista[3];
        for(int i = 0; i < 3; i++) {
            lista[i] = new Lista();
        }
		visitaAnticipata(lista[0],b);
		System.out.println("Visita Anticipata: " + lista[0].toString());
        visitaDifferita(lista[1],b);
        System.out.println("Visita Differita: " + lista[1].toString());
        visitaSimmetrica(lista[2],b);
        System.out.println("Visita Simmetrica " + lista[2].toString());
	}
	public static void visitaAnticipata(Lista l, AlberoBin b) {
            try {
		if(!b.isEmpty()) {
			l.addTail(b.getInfo());
			visitaAnticipata(l,b.getSinistra());
			visitaAnticipata(l,b.getDestra());
		}
            } catch (NullPointerException ex) {
            }                
	}
        public static void visitaDifferita(Lista l, AlberoBin b) {
            try {
                if(!b.isEmpty()) {
                    visitaDifferita(l,b.getSinistra());
                    visitaDifferita(l,b.getDestra());
                    l.addTail(b.getInfo());
                }
            } catch (NullPointerException ex) {
            }
            
        }
        public static void visitaSimmetrica(Lista l, AlberoBin b) {
            try {
                if(!b.isEmpty()) {
                    visitaSimmetrica(l,b.getSinistra());
                    l.addTail(b.getInfo());
                    visitaSimmetrica(l,b.getDestra());
                }
            } catch (NullPointerException ex) {
            } 
        }
}
