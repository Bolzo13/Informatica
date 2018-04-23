/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rilevatore;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 *
 * @author simone.bolzonella
 */
public class FXMLDocumentController implements Initializable {
	
	@FXML
	private Label label;
	
	@FXML
	private TextField display;
	
	@FXML
	private Slider barra;
	
	@FXML
	private Button play;
	
	@FXML
	private Button stop;
	
	@FXML
	private void handleButtonAction(ActionEvent event) {
		
	}
	
	@FXML
	private void BarraSpostata(){
		display.setText(Double.toString(barra.getValue()));
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}	
	
}
