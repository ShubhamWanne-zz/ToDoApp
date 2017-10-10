/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javax.swing.event.HyperlinkEvent;

/**
 *
 * @author shubham_wanne
 */
public class MainController implements Initializable {
        
    private int  max_number_of_task=6;
    int get_task_number=1;

    
    @FXML
    private ImageView add_image;

    @FXML
    private JFXButton add_button;

    @FXML
    private JFXButton trash_button;

    @FXML
    private Label header;
    
    @FXML
    private ImageView trash_image;

    @FXML
    private JFXTextField event_text;
    
    @FXML
    private JFXListView<Node> task_space;
    
    @FXML
    private AnchorPane root;

    
    @FXML
    private Label greeting;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        root.addEventHandler(KeyEvent.KEY_PRESSED, e->{
            if(e.getCode() == KeyCode.ENTER){
                add_button.fire();
                e.consume();
            }
        });
        
        header.setText("Hello, "+System.getProperty("user.name"));
        
                        Calendar cal = Calendar.getInstance();
        
        System.out.println(cal.get(cal.HOUR_OF_DAY)+" "+cal.AM_PM);

        
        task_space.setExpanded(true);
        task_space.depthProperty().set(1);
        
        task_space.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        add_button.setOnAction(e->{
            if(!event_text.getText().equals("")){
                Label label=new Label(event_text.getText());
                label.setFont(Font.font("roboto", 14));
                label.setTextFill(Paint.valueOf("#009688"));
                task_space.getItems().add(label);
                event_text.requestFocus();
                event_text.setText("");
        }else{
                event_text.requestFocus();
            }
        });
        trash_button.setOnAction(e->{
            System.out.println(task_space.getSelectionModel().getSelectedItems());
            for(Node d : task_space.getSelectionModel().getSelectedItems()){
                System.out.println(d);
                task_space.getItems().remove(d);
            }
//            task_space.getItems().removeAll(task_space.getSelectionModel().getSelectedItems());
        });
    }    
}
