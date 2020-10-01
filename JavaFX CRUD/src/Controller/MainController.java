package Controller;

import java.net.URL;
import java.security.acl.LastOwnerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Model.Staff;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MainController implements Initializable{
	
	@FXML
	private TextField idField;
	
	@FXML
	private TextField fnField;
	
	@FXML
	private TextField lnField;
	
	@FXML
	private TextField miField;
	
	@FXML
	private TextField addressField;
	
	@FXML
	private TextField cityField;
	
	
	@FXML
	private TextField tpField;
	
	
	@FXML
	private ComboBox<String> stateField;
	
	int lastid = 0;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	    String check = "SELECT * FROM staff ORDER BY id DESC LIMIT 1 "; //getting last id and set it to the id text view and disable
	    
	    
				ResultSet rs;
				try {
					rs = getConnection().createStatement().executeQuery(check);
					
					if(rs.next()) {
						
						lastid = rs.getInt("id");
					}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
		idField.setText(String.valueOf(lastid+1));		
		idField.setEditable(false);
	
		
		
		
	}
	
	   public void executeQuery(String query) {  // common method for executing queries
	    	Connection conn = getConnection();
	    	Statement st;
	    	try {
				st = conn.createStatement();
				st.executeUpdate(query);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	
	  public Connection getConnection() {  //common method for db connection
	    	Connection conn;
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver"); 
	    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/staff_db","root","");
	    		return conn;
	    	}
	    	catch (Exception e){
	    		e.printStackTrace();
	    		return null;
	    	}
	    }

	  
	  @FXML
	    private void insertButton() { 
		  
		  idField.setText(String.valueOf(lastid+1));		
			idField.setEditable(false);					//Enable fields to insert new record
		
			 fnField.setEditable(true);  
			  lnField.setEditable(true);
			  miField.setEditable(true);
			  addressField.setEditable(true);
			  cityField.setEditable(true);
			 
			  tpField.setEditable(true);
		
			  
		
			//Validation before insert
			
			  if(fnField.getText().equals("") || lnField.getText().equals("") || miField.getText().equals("") || addressField.getText().equals("") || cityField.getText().equals("")
					  || stateField.getValue().equals("") || tpField.getText().equals("") || !tpField.getText().matches("^\\d{10}$")) {
				  
				  Alert alert = new Alert(AlertType.ERROR);
				  alert.setContentText("Please fill out all the details with valid phone number before you insert");
				  alert.show();
				  
			  }
			  
			  else {
		  
		int ids = 0;
		  
		  try {
			 
			  
				 
				 
				 
		    String check1 = "SELECT Count(*) as ids FROM staff WHERE id = " + Integer.parseInt(idField.getText()); //checking existing record before insert
			ResultSet rs1 = getConnection().createStatement().executeQuery(check1);
			
			if(rs1.next()) {
			ids = rs1.getInt("ids");
			
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		  
		  if(ids == 0) {
	    	String query = "insert into staff values('"+idField.getText()+"','"+fnField.getText()+"','"+lnField.getText()+"','"+miField.getText()+"','"+addressField.getText()+"','"+cityField.getText()+"','"+stateField.getSelectionModel().getSelectedItem()+"','"+tpField.getText()+"')";
	    	executeQuery(query);
	    	
	    	Alert alrt = new Alert(AlertType.CONFIRMATION);
	    	alrt.setContentText("The record saved succesfully");
		    alrt.show();
		  
		
	    }
		  else {
			  
			  Alert alert = new Alert(AlertType.ERROR);
			  alert.setContentText("The record already available");
			  alert.show();
			  
		  }
		  
			  }
			  
			  clearButton();
			
		  }
	  
	  @FXML
	  private void clearButton() {
		  
		  idField.setText("");
		  fnField.setText("");
		  lnField.setText("");
		  miField.setText("");
		  addressField.setText("");
		  cityField.setText("");
		  tpField.setText("");
		  
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setContentText("Please insert or View a new rocord");
		  alert.show();
		  
		  String check = "SELECT * FROM staff ORDER BY id DESC LIMIT 1 "; //getting last id and set it to the id text view and disable
		    int lastid = 0;
		    
					ResultSet rs;
					try {
						rs = getConnection().createStatement().executeQuery(check);
						
						if(rs.next()) {
							
							lastid = rs.getInt("id");
						}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
			idField.setText(String.valueOf(lastid+1));		
			idField.setEditable(false);					//Enable fields after click clear button to insert new record
		
			 fnField.setEditable(true);  
			  lnField.setEditable(true);
			  miField.setEditable(true);
			  addressField.setEditable(true);
			  cityField.setEditable(true);
			 
			  tpField.setEditable(true);
		  
		   
	  }
	  
	  
	  
	  @FXML
	  private void updateButton() {
		  
		  idField.setEditable(true);					//Enable fields after click clear button to insert new record
			
			 fnField.setEditable(true);  
			  lnField.setEditable(true);
			  miField.setEditable(true);
			  addressField.setEditable(true);
			  cityField.setEditable(true);
			 
			  tpField.setEditable(true);
		  
		  if(fnField.getText().equals("") || lnField.getText().equals("") || miField.getText().equals("") || addressField.getText().equals("") || cityField.getText().equals("")
				  || stateField.getValue().equals("") || tpField.getText().equals("") || !tpField.getText().matches("^\\d{10}$")) {
			  
			  Alert alert = new Alert(AlertType.ERROR);
			  alert.setContentText("Please fill out all the details valid before you update");
			  alert.show();
			  
		  }
		  
		  else {
			  
				int ids = 0;
				  
				  try {
					 
					  
						 
						 
						 
				    String check1 = "SELECT Count(*) as ids FROM staff WHERE id = " + Integer.parseInt(idField.getText()); //checking existing record before insert
					ResultSet rs1 = getConnection().createStatement().executeQuery(check1);
					
					if(rs1.next()) {
					ids = rs1.getInt("ids");
					
					}
					
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
				  
				  if(ids == 0) {
					  
					  Alert alert = new Alert(AlertType.ERROR);
					  alert.setContentText("There is no such record to update.Click insert and save a new record");
					  alert.show();
					  
			    	
				  
				
			    }
				  else {
					  String query = "UPDATE staff SET firstName='"+fnField.getText()+"',lastName ='"+lnField.getText()+"',MI='"+miField.getText()+"',Address='"+addressField.getText()+"',City='"+cityField.getText()+"',State='"+stateField.getSelectionModel().getSelectedItem()+"',Telephone='"+tpField.getText()+"' WHERE id ="+ idField.getText();		    	executeQuery(query);
				    	
				    	Alert alrt = new Alert(AlertType.CONFIRMATION);
				    	alrt.setContentText("The record updated succesfully");
					    alrt.show();
					 
					  
				  }
				  
					  }
					  
					  
				
		  
		  
		  
		  
	  }
	  
	  @FXML
	  private void viewButton() {
		  
		  
		  
		  fnField.setEditable(false);   //disbale the fields except idField
		  lnField.setEditable(false);
		  miField.setEditable(false);
		  addressField.setEditable(false);
		  cityField.setEditable(false);
		  stateField.setEditable(false);
		  tpField.setEditable(false);
		  
		  while(!idField.isEditable()) {
			  
			  idField.setEditable(true);
			  
		  }
		  
		  if(!idField.getText().equals("")) {
		  
		  String qry = "Select * from staff where id = " + Integer.parseInt(idField.getText());
		  
		  try {
			ResultSet result = getConnection().createStatement().executeQuery(qry);
			
			if(result.next()) {
				Staff staff = new Staff(result.getInt("id"),result.getString("firstName"),result.getString("lastName"),result.getString("MI"),result.getString("Address"),result.getString("City"),result.getString("State"),result.getInt("Telephone"));
				
				fnField.setText(staff.getFirstName());
				lnField.setText(staff.getLastName());
				miField.setText(staff.getMI());
				addressField.setText(staff.getAddress());
				cityField.setText(staff.getCity());
				stateField.setValue(staff.getState());
				tpField.setText(String.valueOf(staff.getTelephone()));
				
			}
			
			else {
				
				fnField.setText("");
				lnField.setText("");
				miField.setText("");
				addressField.setText("");
				cityField.setText("");
				stateField.setValue("");
				tpField.setText("");
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("The record not found in the database for this id");
				alert.show();
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		  
		  }
		  else {
			  
			  Alert alert = new Alert(AlertType.ERROR);
			  alert.setContentText("Enter the id and find the record");
			  alert.show();
			  
		  }
		  
		  
	  } 
	  
}
