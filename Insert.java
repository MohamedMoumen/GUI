import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.*;


public class Insert {

    private Stage window;
    private Scene scene;


    public void start(int i) throws Exception {
        if(i == 1){
            Stage window = new Stage();
            window.setTitle("Insert");
            Insert insert = new Insert();
            Label label1 = new Label("New values : ");

            TextField indexInput1 = new TextField("ID");
            TextField indexInput2 = new TextField("EName");
            TextField indexInput3 = new TextField("EAge");
            TextField indexInput4 = new TextField("EAddres");
            TextField indexInput5 = new TextField("Ework");

            Button button1 = new Button("submit");
            Button button2 = new Button("back");

            button1.setOnAction(e -> {
                insert.sql(Integer.parseInt(indexInput1.getText()), indexInput2.getText(), Integer.parseInt(indexInput3.getText()), indexInput4.getText(), indexInput5.getText());
            });

            button2.setOnAction(event -> {
                window.close();
            });

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(label1, indexInput1, indexInput2, indexInput3,indexInput4, indexInput5, button1, button2);

            scene = new Scene(layout,400,400);
            window.setScene(scene);
            window.showAndWait();
        }else{
            Stage window = new Stage();
            window.setTitle("Insert");
            Insert insert = new Insert();
            Label label1 = new Label("New values : ");

            TextField indexInput1 = new TextField("ID");
            TextField indexInput2 = new TextField("EName");
            TextField indexInput3 = new TextField("EAge");
            TextField indexInput4 = new TextField("EAddres");
            TextField indexInput5 = new TextField("Ework");

            Button button1 = new Button("submit");
            Button button2 = new Button("back");

            button1.setOnAction(e -> {
                insert.sql1(Integer.parseInt(indexInput1.getText()), indexInput2.getText(), Integer.parseInt(indexInput3.getText()), indexInput4.getText());
            });

            button2.setOnAction(event -> {
                window.close();
            });

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(label1, indexInput1, indexInput2, indexInput3,indexInput4, button1, button2);

            scene = new Scene(layout,400,400);
            window.setScene(scene);
            window.showAndWait();
        }
    }

    private void sql(int s,String s2,int s3, String s4, String s5){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "src\\project-1.accdb";
            String url = "jdbc:ucanaccess://"+path;
            Connection c = DriverManager.getConnection(url);
            Statement stt = c.createStatement();
            stt.executeUpdate("INSERT INTO Employee (ID, EName, EAge, EAddres, Ework)\n" + "VALUES (" + s +", '" + s2 +"', "+ s3 +", '"+ s4 +"', '"+ s5 +"');");
            //.executeUpdate("INSERT INTO Customers " + "VALUES (1004, 'Cramden', 'Mr.', 'New York', 2001)");(ID, EName, EAge, EAddres, Ework)
            //"VALUES ('" + s +"', '" + s2 +"', '"+ s3 +"', '"+ s4 +"', '"+ s5 +"')")
        }catch(Exception ee){System.out.println(ee);JOptionPane.showMessageDialog(null,"Invalid Input");}
    }

    private void sql1(int s,String s2,int s3, String s4){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "src\\project-1.accdb";
            String url = "jdbc:ucanaccess://"+path;
            Connection c = DriverManager.getConnection(url);
            Statement stt = c.createStatement();
            stt.executeUpdate("INSERT INTO nurses " + "VALUES (" + s +", '" + s2 +"', "+ s3 +", '"+ s4 +"');");
            //stt.executeUpdate("INSERT INTO nurses (ID, Nurse Name, Nurse Age, Nurse Address)\n" + "VALUES (" + s +", '" + s2 +"', "+ s3 +", '"+ s4 +"');");
            //.executeUpdate("INSERT INTO Customers " + "VALUES (1004, 'Cramden', 'Mr.', 'New York', 2001)");(ID, EName, EAge, EAddres, Ework)
            //"VALUES ('" + s +"', '" + s2 +"', '"+ s3 +"', '"+ s4 +"', '"+ s5 +"')")
        }catch(Exception ee){System.out.println(ee);JOptionPane.showMessageDialog(null,"Invalid Input");}
    }
}
