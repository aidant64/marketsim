package Main;

import Windows.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Create and display the window/app
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mWindow().setVisible(true);
            }
        });

    }

}
