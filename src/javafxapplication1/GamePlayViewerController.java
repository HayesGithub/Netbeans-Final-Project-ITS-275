/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author hahay
 */
public class GamePlayViewerController implements Initializable {
    /**
     * Initializes the controller class.
     */
     @FXML public RadioButton HeadsRadioButton;
     @FXML public RadioButton TailsRadioButton;
     @FXML public Label radioButtonLabel;
     @FXML public ToggleGroup choiceToggleGroup;
   
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioButtonLabel.setText("");
        choiceToggleGroup = new ToggleGroup();
        this.HeadsRadioButton.setToggleGroup(choiceToggleGroup);
        this.TailsRadioButton.setToggleGroup(choiceToggleGroup);
               }
    
}
