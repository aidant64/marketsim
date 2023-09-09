package Main;

import Windows.mJFrameWindow;

public class Main {

    public static void main(String[] args) throws Exception {

        // Create and display the window/app
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mJFrameWindow().setVisible(true);
            }
        });

    }

}
