import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;
import java.sql.*;


public class SelectQ  {

    private Stage window;
    private Scene scene;

    public void start(int i) throws Exception {
        if(i == 1){
            Stage window = new Stage();
            window.setTitle("AccessDataBase");
            SelectQ selectQ = new SelectQ();

            TextField indexInput1 = new TextField("Column Name");
            Button button1 = new Button("submit");
            Button button2 = new Button("back");

            button1.setOnAction(e -> {
                selectQ.access(indexInput1.getText());
                window.close();
            });

            button2.setOnAction(event -> {
                window.close();
            });

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(indexInput1, button1 ,button2);

            scene = new Scene(layout,400,400);
            window.setScene(scene);
            window.showAndWait();
        }else{
            Stage window = new Stage();
            window.setTitle("AccessDataBase");
            SelectQ selectQ = new SelectQ();

            TextField indexInput1 = new TextField("Column Name");
            Button button1 = new Button("submit");
            Button button2 = new Button("back");

            button1.setOnAction(e -> {
                selectQ.access1(indexInput1.getText());
                window.close();
            });

            button2.setOnAction(event -> {
                window.close();
            });

            VBox layout = new VBox(15);
            layout.setPadding(new Insets(20,20,20,20));
            layout.getChildren().addAll(indexInput1, button1 ,button2);

            scene = new Scene(layout,400,400);
            window.setScene(scene);
            window.showAndWait();
        }
    }

    private void access(String s){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "src\\project-1.accdb";
            String url = "jdbc:ucanaccess://"+path;
            Connection c = DriverManager.getConnection(url);
            Statement st = c.createStatement();
            // The last four lines remain the same in each program

            ResultSet rs = st.executeQuery("select * from Employee");
            //This also remains the same unless you're willing to executeUpdate(); which takes one of three statements (Delete, Insert, Update) SQl statements

            //From here on out is just printing/outputing the result nothing important it depends on how you want to use the data
            String result = "";
            int i = 0;
            while(rs.next()){
                System.out.println(rs.getString(s));
                result += rs.getString(s) + "\n";
            }
            JOptionPane.showMessageDialog(null, result);

        }catch(Exception ee){System.out.println(ee);JOptionPane.showMessageDialog(null,"Invalid Input");}
    }

    private void access1(String s){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String path = "src\\project-1.accdb";
            String url = "jdbc:ucanaccess://"+path;
            Connection c = DriverManager.getConnection(url);
            Statement st = c.createStatement();
            // The last four lines remain the same in each program

            ResultSet rs = st.executeQuery("select * from nurses");
            //This also remains the same unless you're willing to executeUpdate(); which takes one of three statements (Delete, Insert, Update) SQl statements

            //From here on out is just printing/outputing the result nothing important it depends on how you want to use the data
            String result = "";
            int i = 0;
            while(rs.next()){
                System.out.println(rs.getString(s));
                result += rs.getString(s) + "\n";
            }
            JOptionPane.showMessageDialog(null, result);

        }catch(Exception ee){System.out.println(ee);JOptionPane.showMessageDialog(null,"Invalid Input");}
    }
}
