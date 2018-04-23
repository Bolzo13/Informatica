/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pop3;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class FXMLDocumentController implements Initializable {
    
    
    private Pop3Client p;
    private boolean isConnected;
    
	@FXML
	private TableView tabella;
	
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        int numOfMsg = 0;
        
        
        if (isConnected) {
            try {
                numOfMsg = p.getNumOfMessages();
				label.setText(Integer.toString(numOfMsg) + " Messaggi");
				tabella.setItems(p.getMessages());
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isConnected = false;
        try {
            // TODO
            p = new Pop3Client();
            isConnected = p.connect();
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
}
