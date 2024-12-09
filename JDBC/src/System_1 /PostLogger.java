package Vani;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class PostLogger {
    private static final String LOG_FILE = "post_log.txt";

    public static void logEvent(String event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            String logEntry = "[" + LocalDate.now() + "] " + event;
            writer.write(logEntry);
            writer.newLine();
            System.out.println("Event logged: " + logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
