package Main;

import Windows.mWindow;

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
