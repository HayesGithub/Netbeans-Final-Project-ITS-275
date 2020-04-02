package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author hahay
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    //when this method is called it will change the scene to the GameViewer
    public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        Parent GameViewerParent = FXMLLoader.load(getClass() .getResource("GamePlayViewer.fxml"));
        Scene GameViewerScene = new Scene(GameViewerParent);
        
        //This line get the Stage Information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(GameViewerScene);
        window.show();
    }
    
 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
}
