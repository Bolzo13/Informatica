/**
 *
 * @author simone.bolzonella
 */
public class Lista <T> {
	private NodoLista testa,coda;

	public Lista() {
		testa = coda = null;
	}
	public Lista(T[] n) {
		for(int i = 0; i < n.length; i++) {
			if(i == 0) testa = coda = new NodoLista(n[i],null);
			else {
				NodoLista tempCoda = new NodoLista(n[i], null);
				coda.next = tempCoda;
				coda = tempCoda;
			}
		}
	}
	@Override
	public String toString() {
            if(size() == 0) return "It's empty!";
		NodoLista toPrint = testa;
		String s = "[";
		while(!toPrint.equals(coda)) {
			s+=toPrint.info.toString()+",";
			toPrint = toPrint.next;
		}
		s+=toPrint.info.toString()+"]";
		return s;
	}
	public int size() {
            if(testa == null) return 0;
		int i = 0;
		NodoLista temp = testa;
		while(!temp.equals(coda)) {
			temp = temp.next;
			i++;
		}
		return ++i;
	}

	public void addHead(T elem) {
            if(size() == 0)
		testa = coda = new NodoLista(elem,null);
            else testa = new NodoLista(elem,testa);
	}
	public void addTail(T elem) {
            NodoLista temp;
            if(size() == 0) {
		temp = new NodoLista(elem, null);
		coda = temp;
                testa = coda;
            } else {
                temp = new NodoLista(elem, null);
		coda.next = temp;
		coda = temp;
            }
	}
	public T removeHead() {
		NodoLista oldHead = testa;
		testa = testa.next;
		return (T)oldHead.info;
	}
	public T removeTail() {
		NodoLista newTail = testa;
		while(!newTail.next.equals(coda)) {
			newTail = newTail.next;
		}
		coda = newTail;
		coda.next=null;
		return (T)newTail.next;
	}

	public T get(int x) {
		int lunghezza = size();
		NodoLista node = testa;
		for(int i = 0; i < lunghezza; i++) {
			if(i == x) {
				return (T)node.info;
			} else node = node.next;
		}
		return (T)"Non Trovato!";
	}
	public void set(int x, T val) {
		int lunghezza = size();
		NodoLista node = testa;
		for(int i = 0; i < lunghezza; i++) {
			if(i == x) {
				node.info = val;
			} else node = node.next;
		}
	}
	public void add(int x, T val) {
		int lunghezza = size();
		NodoLista toAdd = testa;
                if(x == 0) {
                    addHead(val);
                    return;
                }                
		for(int i = 0; i < lunghezza; i++) {
			if(i == x-1) {
				NodoLista temp = toAdd;
				toAdd = new NodoLista(val ,null);
				toAdd.next = temp.next;
				temp.next = toAdd;
			}
			toAdd = toAdd.next;
		}
	}
        public T remove(int n) {
            int lunghezza = size();
            NodoLista temp;
            if(n == 0) {
                temp = testa;
                removeHead();
                return (T)temp.info;
            }
            if(n == lunghezza-1) {
                temp = coda;
                removeTail();
                return (T)temp.info;
            }
            temp = testa;
            for(int i = 0; i < lunghezza; i++) {
                if(i == n-1) {
                    NodoLista toRemove = temp.next;
                    temp.next=toRemove.next;
                    return (T)toRemove.info;
                } else temp = temp.next;
            }
            return (T)"Non Trovato!";
        }
}
