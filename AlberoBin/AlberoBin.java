/**
 *
 * @author simone.bolzonella
 */
public class AlberoBin <T> {
	private T info;
	private AlberoBin <T> sinistra;
	private AlberoBin <T> destra;
	public AlberoBin() {
		this(null, null, null);
	}
	public AlberoBin(T info, AlberoBin left, AlberoBin right) {
		this.info = info;
		this.sinistra = left;
		this.destra = right;
	}
	public T getInfo() {
		return (T)info;
	}
	public AlberoBin getSinistra() {
		return sinistra;
	}
	public AlberoBin getDestra() {
		return destra;
	}
	public boolean isEmpty() {
		return (destra == null && sinistra == null && info == null);
	}
}
