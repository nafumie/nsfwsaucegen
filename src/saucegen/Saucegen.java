package saucegen;

import java.awt.Desktop;
import java.net.URI;

public class Saucegen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int min = 10000;
        int max = 299999;
        //Generate random int value from 10000 to 200000
        int random_int = (int) (Math.random() * (max - min + 1) + min);
        System.out.println("Sending you to sauce: " + random_int);
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) { // DOES NOT OPEN IN INCOGNITO
            try {
                Desktop.getDesktop().browse(new URI("https://nhentai.to/g/" + random_int));
            } catch (Exception e) {
            }
        }
    }

}
