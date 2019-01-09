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


public class Delete {

    private Stage window;
    private Scene scene;


    public void start(int i) throws Exception {
        if(i == 1){
            Stage window = new Stage();
            window.setTitle("Delete");
            Delete delete= new Delete();

            TextField indexInput1 = new TextField("Column Name");
            TextField indexInput2 = new TextField("value");

            Button button1 = new Button("submit");
            Button button2 = new Button("back");

            button1.setOnAction(e -> {
                delete.sql(indexInput1.getText(),indexInput2.getText());
            });

            button2.setOnAction(event -> {
                window.close();
            });

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(indexInput1, indexInput2, button1, button2);

            scene = new Scene(layout,400,400);
            window.setScene(scene);
            window.showAndWait();
        }else{
            Stage window = new Stage();
            window.setTitle("Delete");
            Delete delete= new Delete();

            TextField indexInput1 = new TextField("Column Name");
            TextField indexInput2 = new TextField("value");

            Button button1 = new Button("submit");
            Button button2 = new Button("back");

            button1.setOnAction(e -> {
                delete.sql1(indexInput1.getText(),indexInput2.getText());
            });

            button2.setOnAction(event -> {
                window.close();
            });

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(indexInput1, indexInput2, button1, button2);

            scene = new Scene(layout,400,400);
            window.setScene(scene);
            window.showAndWait();
        }
    }

    private void sql(String s,String s2){//String columnName,String v1,String v3){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "src\\project-1.accdb";
            String url = "jdbc:ucanaccess://"+path;
            Connection c = DriverManager.getConnection(url);
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM Employee WHERE "+ s +" = '" + s2 + "'");
        }catch(Exception ee){System.out.println(ee);JOptionPane.showMessageDialog(null,"Invalid Input");}
    }

    private void sql1(String s,String s2){//String columnName,String v1,String v3){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "src\\project-1.accdb";
            String url = "jdbc:ucanaccess://"+path;
            Connection c = DriverManager.getConnection(url);
            Statement st = c.createStatement();
            st.executeUpdate("DELETE FROM nurses WHERE "+ s +" = '" + s2 + "'");
        }catch(Exception ee){
            System.out.println(ee);
            JOptionPane.showMessageDialog(null,"Invalid Input");
        }
    }
}
