package web;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

/**
 * Open Web Page
 */
public class OpenWebPage {

    /**
     * After finishing all the tasks in the Mental Health Centre, open the Mental Health Web Page
     */
    public static void openMentalHealth() {
        // index.html is in the project root directory
        String filePath = "src/main/java/Mental Health/index.html";
        // Get File
        File file = new File(filePath);

        try {
            // Create URI Object
            URI uri = file.toURI();
            // Get Desktop Object
            Desktop desktop = Desktop.getDesktop();
            // Open the Web Page
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * After finishing all the tasks in the Mental Health Centre, open the Food Bank Web Page
     */
    public static void openFoodBank() {
        // index.html is in the project root directory
        String filePath = "src/main/java/Food Bank/index.html";
        // Get File
        File file = new File(filePath);

        try {
            // Create URI Object
            URI uri = file.toURI();
            // Get Desktop Object
            Desktop desktop = Desktop.getDesktop();
            // Open the Web Page
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}










