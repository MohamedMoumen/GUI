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


public class Update {

    private Stage window;
    private Scene scene;


    public void start(int i) throws Exception {
        if(i == 1){
            Stage window = new Stage();
            window.setTitle("Update");
            Update update= new Update();
            Label label = new Label("Condition : ");
            Label label1 = new Label("New values : ");

            TextField indexInput1 = new TextField("ID");
            TextField indexInput2 = new TextField("EName");
            TextField indexInput3 = new TextField("EAge");
            TextField indexInput4 = new TextField("EAddres");
            TextField indexInput5 = new TextField("Ework");

            Button button1 = new Button("submit");
            Button button2 = new Button("back");

            button1.setOnAction(e -> {
                update.sql(indexInput2.getText(), Integer.parseInt(indexInput3.getText()),indexInput4.getText(),indexInput5.getText(),Integer.parseInt(indexInput1.getText()));
            });

            button2.setOnAction(event -> {
                window.close();
            });

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(label, indexInput1,label1, indexInput2, indexInput3, indexInput4, indexInput5, button1, button2);

            scene = new Scene(layout,400,400);
            window.setScene(scene);
            window.showAndWait();
        }else{
            Stage window = new Stage();
            window.setTitle("Update");
            Update update= new Update();
            Label label = new Label("Condition : ");
            Label label1 = new Label("New values : ");

            TextField indexInput1 = new TextField("ID");
            TextField indexInput2 = new TextField("EName");
            TextField indexInput3 = new TextField("EAge");
            TextField indexInput4 = new TextField("EAddres");
            TextField indexInput5 = new TextField("Ework");

            Button button1 = new Button("submit");
            Button button2 = new Button("back");

            button1.setOnAction(e -> {
                update.sql1(indexInput2.getText(), Integer.parseInt(indexInput3.getText()),indexInput4.getText(), Integer.parseInt(indexInput1.getText()));
            });

            button2.setOnAction(event -> {
                window.close();
            });

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(label, indexInput1,label1, indexInput2, indexInput3, indexInput4, button1, button2);

            scene = new Scene(layout,400,400);
            window.setScene(scene);
            window.showAndWait();
        }
    }

    private void sql(String s,int s2, String s3, String s4,int i){//String columnName,String v1,String v3){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "src\\project-1.accdb";
            String url = "jdbc:ucanaccess://"+path;
            Connection c = DriverManager.getConnection(url);
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE Employee \nSET EName = '"+ s +"', EAge = " + s2+ ", EAddres = '" + s3 + "', Ework = '" + s4 + "'\nWhere ID = " + i);

        }catch(Exception ee){System.out.println(ee);JOptionPane.showMessageDialog(null,"Invalid Input");}
    }

    private void sql1(String s,int s2, String s3, int i){//String columnName,String v1,String v3){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "src\\project-1.accdb";
            String url = "jdbc:ucanaccess://"+path;
            Connection c = DriverManager.getConnection(url);
            Statement st = c.createStatement();
            st.executeUpdate("UPDATE nurses \nSET Nurse Name = '"+ s +"', Nurse Age = " + s2+ ", Nurse Address = '" + s3 + "'\nWhere ID = " + i);

        }catch(Exception ee){System.out.println(ee);JOptionPane.showMessageDialog(null,"Invalid Input");}
    }
}
