import java.util.Scanner;

public class Esercizio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        //boolean guardia = true;
        System.out.println("Inserisci qualcosa");
        String s = "";
        ListaConcatenata y = createAListFromAString(input.nextLine());
        System.out.println(y.Size());
        System.out.println(y.toString());

    }
    static ListaConcatenata createAListFromAString(String s) {
        int i = 0;
        int spazi = 0;
        ListaConcatenata nuova = new ListaConcatenata();
        while(i < s.length()) {
            if(s.charAt(i)==' ') {
                nuova.addTail(s.substring(spazi,i));
                spazi = i;
            }
            if(i == s.length()-1) {
                nuova.addTail(s.substring(spazi,i+1));
            }
            i++;
        }
        return nuova;
    }
}