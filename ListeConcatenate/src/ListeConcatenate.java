/**
 *
 * @author simone.bolzonella
 */
public class ListeConcatenate {
	public static void main(String[] args) {
		String[] brugnaro= new String[]{"aa", "bb", "cc"};
		ListaConcatenata<String> lista=new ListaConcatenata(brugnaro);
		System.out.println(lista.toString());
		System.out.println(lista.Size());
		lista.addHead("00");
		System.out.println(lista.toString());
		lista.addTail("dd");
		System.out.println(lista.toString());
		lista.removeHead();
		System.out.println(lista.toString());
		lista.removeTail();
		System.out.println(lista.toString());
	}

}
