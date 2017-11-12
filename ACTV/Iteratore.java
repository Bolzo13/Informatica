/**
 *
 * @author simone.bolzonella
 */
public interface Iteratore <T> {
	boolean inside();
	T current();
	void goNext();
	void goFirst();
}
