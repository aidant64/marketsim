package Main;

import Utils.NetworkUtil;
import Utils.ParseUtil;
import Utils.StorageUtil;
import Windows.mWindow;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Scanner;

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
