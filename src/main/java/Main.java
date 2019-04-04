import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader =new  FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = (Parent) fxmlLoader.load();


        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 450, 450);


        String fontSheet = fileToStylesheetString( new File ("stylesheet.css") );
        if ( fontSheet == null ) {
            //Do Whatever you want with logging/errors/etc.
            System.out.println("errrorina");
        } else {
            scene.getStylesheets().add( fontSheet );
        }


        ((Controller) fxmlLoader.getController()).setScene(scene);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public String fileToStylesheetString ( File stylesheetFile ) {
        try {
            return stylesheetFile.toURI().toURL().toString();
        } catch ( MalformedURLException e ) {
            return null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}