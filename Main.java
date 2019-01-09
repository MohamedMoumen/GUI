import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("AccessDataBase");
        Label label1 = new Label("Welcome to Access DataBase.");
        Label label = new Label("Select a table");
        Label label2 = new Label(" ");
        Label label3 = new Label("Employee table");
        Label label4 = new Label("nurses table");

        SelectQ selectQ = new SelectQ();
        Update update = new Update();
        Delete delete = new Delete();
        Insert insert = new Insert();

        Button button1 = new Button("Select");
        Button button2 = new Button("Update");
        Button button3 = new Button("Delete");
        Button button4 = new Button("Insert");
        Button button5 = new Button("Exit");
        Button button6 = new Button("Employee");
        Button button7 = new Button("nurses");
        Button button8 = new Button("Back");

        button6.setOnAction(e -> {
            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(label3, button1, button2, button3, button4);

            button1.setOnAction(f -> {
                try{selectQ.start(1);}
                catch (Exception e1){
                    System.out.println(e1);
                }
            });

            button2.setOnAction(f -> {
                try { update.start(1);}
                catch (Exception e2){
                    System.out.println(e2);
                }
            });

            button3.setOnAction(f -> {
                try { delete.start(1);}
                catch (Exception e3){
                    System.out.println(e3);
                }
            });

            button4.setOnAction(f -> {
                try { insert.start(1);}
                catch (Exception e4){
                    System.out.println(e4);
                }
            });

            button8.setOnAction(f -> window.close());

            scene = new Scene(layout,350,350);
            window.setScene(scene);
            window.show();
        });

        button7.setOnAction(e -> {
            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(label4, button1, button2, button3, button4);

            button1.setOnAction(f -> {
                try{selectQ.start(2);}
                catch (Exception e1){
                    System.out.println(e1);
                }
            });

            button2.setOnAction(f -> {
                try { update.start(2);}
                catch (Exception e2){
                    System.out.println(e2);
                }
            });

            button3.setOnAction(f -> {
                try { delete.start(2);}
                catch (Exception e3){
                    System.out.println(e3);
                }
            });

            button4.setOnAction(f -> {
                try { insert.start(2);}
                catch (Exception e4){
                    System.out.println(e4);
                }
            });

           button8.setOnAction(f -> window.close());

            scene = new Scene(layout,350,350);
            window.setScene(scene);
            window.show();
        });

        button5.setOnAction(e -> {
            primaryStage.close();
        });



        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(label1,label,label3,button6,label4,button7,label2,button5);

        scene = new Scene(layout,350,350);
        window.setScene(scene);
        window.show();

    }

}