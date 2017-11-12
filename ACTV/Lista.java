/**
 *
 * @author simone.bolzonella
 */
public class Lista <PuntoMappa> implements Attraversabile {
	protected NodoConc<PuntoMappa> testa,coda;
	public Lista() {
		testa = coda = null;
	}
	public void add(PuntoMappa elem) {
		if(size() == 0) {
			testa = coda = new NodoConc(elem,null);
		} else {
			NodoConc toAdd = new NodoConc(elem, null);
			coda.next = toAdd;
			coda = toAdd;
		}
	}
	
	public int size() {
		if(testa == null) return 0;
		NodoConc temp = testa;
		int counter = 0;
		while(!temp.equals(coda)) {
			counter++;
			temp = temp.next;
		}
		return ++counter;
	}
	
	@Override
	public String toString() {
		int length = size();
		String toPrint = "[+\n";
		NodoConc temp = testa;
		for(int i = 0; i < length; i++) {
			toPrint += temp.info.toString() + "\n";
		}
		toPrint += coda.info.toString() +"\n";
		return toPrint;
	}
        @Override
        public Iteratore newIterator() {
            return new IteratoreClass(this);
        }
} 
