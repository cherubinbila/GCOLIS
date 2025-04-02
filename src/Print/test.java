
package Print;


import Services.PrintService;
import com.itextpdf.io.exceptions.IOException;

public class test {

    public static void main(String[] args) {
        PrintService printService = new PrintService();
        try {
            //printService.ImprimerListeLivraisons();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
