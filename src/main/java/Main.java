import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;
    public void start(Stage primaryStage) throws Exception {
        //CONTROLER
        Parent root = FXMLLoader.load(this.getClass().getResource("view.fxml"));
        //TITLE OF APP
        primaryStage.setTitle("Entropia-zadanie");
        primaryStage.setScene(new Scene(root));
        //SIZABLE IS OFF
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }

}
