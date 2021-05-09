package saucegen;

import java.awt.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class Saucegen {

    /**
     * @param args the command line arguments
     */
    public static void generateSauce() {
        int min = 1;
        int max = 999999;
        //Generate random int value from 10000 to 200000
        int code = (int) (Math.random() * (max - min + 1) + min);
        System.out.println("Sending you to sauce: " + code);

        try {
            int rCode = getResponseCode("https://nhentai.to/g/" + code);
            if (rCode == 404) {
                System.out.println("Code 404: Finding a new sauce...");
                generateSauce();
            } else {
                System.out.println("Code " + rCode + ": Sending you to the sauce!");
                sendtoSite(code);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static int getResponseCode(String urlString) throws MalformedURLException, IOException {
        URL u = new URL(urlString);
        System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.51 Safari/537.36 Edg/90.0.818.27");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        return huc.getResponseCode();
    }

    public static void sendtoSite(int code) {
        Runtime rt = Runtime.getRuntime();
        try {
//            rt.exec(new String[]{"cmd.exe", "/c", "start chrome /incognito nhentai.to/g/" + random_int});
            rt.exec(new String[]{"cmd.exe", "/c", "start msedge /inprivate nhentai.to/g/" + code});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame f;
        f = new JFrame("SauceGen");
        f.setVisible(false);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(f, "Finding you a random sauce! Please wait...", "nsaucegen", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        generateSauce();
        f.dispose();
    }

}
