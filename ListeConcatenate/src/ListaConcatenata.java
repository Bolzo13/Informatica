/**
 *
 * @author simone.bolzonella
 */
public class ListaConcatenata <T>{
	
	private NodoConc<T> last=new NodoConc();
	private NodoConc<T> first=new NodoConc();
	private int lunghezza=0;

    public ListaConcatenata() {
		NodoConc n=new NodoConc();
		last=first=n;
	}


    public ListaConcatenata(T[] array) {
        for (int i = 0; i < array.length; i++) {
		    if (i == 0) {
		        first = last = new NodoConc(array[i]);
		    }
		    else {
		    	NodoConc n = new NodoConc(array[i]);
		    	last.next = n;
		    	last = n;
		    }
	    }
    }
	
	@Override
	public String toString(){
		NodoConc n=first;
		String out="[ ";
		while(n.getNext()!=null){
		    out+=n.getInfo()+" ";
		    n=n.getNext();
		    lunghezza++;
        }
        out+=n.getInfo()+" ]";
		lunghezza++;
		return out;
	}

	public int Size(){
	    return lunghezza;
    }

    /**
     * Esercizio 2
     */

    public void addHead(T elem){
        if(Size()==0){
            first=last=new NodoConc(elem);
        }else{
            first=new NodoConc(elem,first);
        }
    }

    public void addTail(T elem){
        if(Size()==0) {
            first = last = new NodoConc<>(elem);
        }else {
            NodoConc n=new NodoConc(elem);
            last.next=n;
            last=n;
        }
    }

    public T removeHead(){
        NodoConc n=first;
        first=first.next;
        return (T) n.getInfo();
    }

    public T removeTail(){
        NodoConc n=first;
        while (!n.next.equals(last)){
            n=n.next;
        }
        last=n;
        last.next=null;
        return (T)n.next;
    }

    /**
     * esercizio 3
     *
     */
    public T get(int x) {
        int lunghezza = Size();
        NodoConc node = first;
        for(int i = 0; i < lunghezza; i++) {
            if(i == x) {
                return (T)node.info;
            } else node = node.next;
        }
        return (T)"Non Trovato!";
    }
    public void set(int x, T val) {
        int lunghezza = Size();
        NodoConc node = first;
        for(int i = 0; i < lunghezza; i++) {
            if(i == x) {
                node.info = val;
            } else node = node.next;
        }
    }
    public void add(int x, T val) {
        int lunghezza = Size();
        NodoConc toAdd = first;
        if(x == 0) {
            addHead(val);
            return;
        }
        for(int i = 0; i < lunghezza; i++) {
            if(i == x-1) {
                NodoConc temp = toAdd;
                toAdd = new NodoConc(val ,null);
                toAdd.next = temp.next;
                temp.next = toAdd;
            }
            toAdd = toAdd.next;
        }
    }
    public T remove(int n) {
        int lunghezza = Size();
        NodoConc temp;
        if(n == 0) {
            temp = first;
            removeHead();
            return (T)temp.info;
        }
        if(n == lunghezza-1) {
            temp = last;
            removeTail();
            return (T)temp.info;
        }
        temp = first;
        for(int i = 0; i < lunghezza; i++) {
            if(i == n-1) {
                NodoConc toRemove = temp.next;
                temp.next=toRemove.next;
                return (T)toRemove.info;
            } else temp = temp.next;
        }
        return (T)"Non Trovato!";
    }
}
