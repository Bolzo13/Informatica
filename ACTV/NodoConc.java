/**
 *
 * @author simone.bolzonella
 */
public class NodoConc <T> {

  public T info;    
  public NodoConc <T> next;   

  

  public NodoConc (T  info, NodoConc <T>  next){
    this.info = info;
    this.next = next;
  }

}
