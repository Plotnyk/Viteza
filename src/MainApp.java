import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        //authorization();
        listEmplouer();
    }

    /**
     * Створюємо метод для запуску авторизації при запуску програми
     */
    private void authorization() {
        try {
            primaryStage.hide();
            Parent loader = new FXMLLoader().load(getClass().getResource("/gui/login/authorization.fxml"));
            primaryStage.setTitle("Авторизация");
            primaryStage.setResizable(false);
            Scene scene = new Scene(loader);
            scene.getStylesheets().add(MainApp.class.getResource("/css/authorization.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Ошибка запуска окна авторизации");
        }

    }

    private void listEmplouer() {
        try {
            primaryStage.hide();
            Parent loader = new FXMLLoader().load(getClass().getResource("/gui/listEmployee.fxml"));
            primaryStage.setTitle("Авторизация");
            primaryStage.setResizable(false);

            Scene scene = new Scene(loader);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

