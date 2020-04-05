package gui;


import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.PersonObserverForDB;
import logic.*;
import java.sql.Timestamp;


import static gui.MyScreen.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        TextField firstNameInput = new TextField();
        TextField secondNameInput = new TextField();

        TextField[] txtArr = new TextField[2];
        txtArr[0]= firstNameInput;
        txtArr[1]= secondNameInput;

        //buttons
        Button btnAdd = new Button("add");
        Button btnSaveToDB = new Button("save to db");
        Button btnReadFromDB = new Button("readFromDB");
        Button btnRemoveFromDB = new Button("remove all from DB");
        Button btnSaveToFile = new Button("save to file");
        Button[] btnArr={btnAdd,btnSaveToDB,btnReadFromDB,btnRemoveFromDB,btnSaveToFile};


        PersonObserverForDB personObserverForDB = new PersonObserverForDB();
        Person person = new Person("","", new Timestamp(System.currentTimeMillis()));

        //add observer on person object
        person.addObserver(personObserverForDB);



        primaryStage.setTitle("Zeiterfassung");
        primaryStage.setScene(makeScene( btnArr, person, personObserverForDB, txtArr));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
