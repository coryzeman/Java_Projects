import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main extends Application {
    /**
      This JavaFX application provides a simple user interface with a menu bar.
      Users can perform the following actions:
      1. Display the current date and time in the text area.
      2. Save the contents of the text area to a log file named "log.txt".
      3. Change the background color of the text area to a random shade of green,
         displaying the RGB value each time the menu option is selected.
      4. Exit the application.
     */
    // Declare components
    private TextArea textArea;
    private BorderPane layout;
    //  Main method
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Menu Example");

        // Initialize components
        layout = new BorderPane();
        textArea = new TextArea();
        textArea.setEditable(true); // Set to editable

        // Create menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        menu.getItems().addAll(
                new MenuItem("Date & Time"),
                new MenuItem("Save to Log"),
                new MenuItem("Change Background Color"),
                new MenuItem("Exit")
        );

        //  Set event handlers for menu items
        menu.getItems().get(0).setOnAction(e -> showDateTime());
        menu.getItems().get(1).setOnAction(e -> saveToLog());
        menu.getItems().get(2).setOnAction(e -> changeBackgroundColor());
        menu.getItems().get(3).setOnAction(e -> primaryStage.close());

        //  Add menu to menu bar
        menuBar.getMenus().add(menu);
        layout.setTop(menuBar);
        layout.setCenter(textArea);

        // Display the window
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // Menu Option 1: Date & Time
    private void showDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm a");
        textArea.appendText(now.format(formatter) + "\n"); // Removed "Current Date and Time: "
    }
    // Menu Option 2: Save to Log
    private void saveToLog() {
        String content = textArea.getText();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(content);
            textArea.appendText("Saved to log.txt\n"); // Changed message here
        } catch (IOException e) {
            textArea.appendText("Error saving to log.txt\n");
        }
    }
    // Menu Option 3: Change Background Color
    private void changeBackgroundColor() {
        Random random = new Random();

        // Generate a new random green value each time
        int greenValue = random.nextInt(256); // Random green value from 0 to 255
        String color = String.format("rgb(0, %d, 0)", greenValue); // Create the RGB color string

        // Set the background color
        textArea.setStyle("-fx-control-inner-background: " + color + ";");

        // Print the hue ID (RGB value) to the text area
        textArea.appendText("Background color changed to: " + color + "\n");
    }
}
