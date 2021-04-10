package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class AirlineController implements Initializable{
   
    @FXML
    private RadioButton rbAirline;

    @FXML
    private RadioButton rbAirlineNo;

    @FXML
    private RadioButton rbDeptAirport;

    @FXML
    private RadioButton rbArrAirport;

    @FXML
    private ChoiceBox<String> cbAirline;

    @FXML
    private ChoiceBox<String> cbAirlineNo;

    @FXML
    private ChoiceBox<String> cbDeptAirport;

    @FXML
    private ChoiceBox<String> cbArrAirport;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnClose;

    @FXML
    private TableView<AirlineTable> airlineTableView;

    @FXML
    private TableColumn<AirlineTable, String> airlineColumn;

    @FXML
    private TableColumn<AirlineTable, String> airlineNoColumn;

    @FXML
    private TableColumn<AirlineTable, String> deptColumn;

    @FXML
    private TableColumn<AirlineTable, String> arrColumn;
    

    private ObservableList<String> airlineList = FXCollections.observableArrayList();
    private ObservableList<String> airlineNoList = FXCollections.observableArrayList();
    private ObservableList<String> deptList = FXCollections.observableArrayList();
    private ObservableList<String> arrList = FXCollections.observableArrayList();
    
    private ObservableList<AirlineTable> tableData = FXCollections.observableArrayList();
    
    ArrayList<Airline> airArray;
    int selectedChoiceBox;  //To store the selected choice box
    int i;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		airlineColumn.setCellValueFactory(cellData -> cellData.getValue().airlineProperty());
		airlineNoColumn.setCellValueFactory(cellData -> cellData.getValue().airlineNoProperty());
		deptColumn.setCellValueFactory(cellData -> cellData.getValue().departureProperty());
		arrColumn.setCellValueFactory(cellData -> cellData.getValue().arrivalProperty());
		
		try {
			FileReader fr=new FileReader("D:\\Flight.txt");
			BufferedReader br=new BufferedReader(fr);
			String c;
			String[] arr;
			airArray = new ArrayList<Airline>();
			while((c=br.readLine())!=null) 
			{
				arr=c.split(",");
				airArray.add(new Airline(arr[0],arr[1],arr[2],arr[3]));	
			}
			br.close();
			
			cbAirline.setValue("Select Airline");
			cbAirlineNo.setValue("Select Airline No");
			cbArrAirport.setValue("Select Arrival Airport");
			cbDeptAirport.setValue("Select Departure airport");
			
			for(i=0;i<airArray.size();i++)
			{
				if(!airlineList.contains(airArray.get(i).getAirline()))
					airlineList.add(airArray.get(i).getAirline());
				if(!airlineNoList.contains(airArray.get(i).getAirlineNo()))
					airlineNoList.add(airArray.get(i).getAirlineNo());
				if(!deptList.contains(airArray.get(i).getDeptAirport()))
					deptList.add(airArray.get(i).getDeptAirport());
				if(!arrList.contains(airArray.get(i).getArrAirport()))
					arrList.add(airArray.get(i).getArrAirport());
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	

    @FXML
    void airlineSelected(ActionEvent event) {
    	if(rbAirline.isSelected())
    	{
    		selectedChoiceBox=1;
    		
    		if(cbAirline.getItems().size()<=0)
    		cbAirline.getItems().addAll(airlineList);
    		
    		rbAirlineNo.setSelected(false);
    		rbDeptAirport.setSelected(false);
    		rbArrAirport.setSelected(false);
    		
    		cbAirline.setDisable(false);
    		cbArrAirport.setDisable(true);
    		cbDeptAirport.setDisable(true);
    		cbAirlineNo.setDisable(true);
    	}
    	else {
    		cbAirline.getItems().clear();
    		cbAirlineNo.setDisable(false);
    		cbArrAirport.setDisable(false);
    		cbDeptAirport.setDisable(false);
    		selectedChoiceBox=0;
    		
    		cbAirline.setValue("Select Airline");
    	}
    }
    
    
    @FXML
    void airlineNoSelected(ActionEvent event) {
    	if(rbAirlineNo.isSelected())
    	{
    		selectedChoiceBox=2;
    		if(cbAirlineNo.getItems().size()<=0)
    		cbAirlineNo.getItems().addAll(airlineNoList);
    		
    		rbAirline.setSelected(false);
    		rbDeptAirport.setSelected(false);
    		rbArrAirport.setSelected(false);
    		
    		cbAirlineNo.setDisable(false);
    		cbAirline.setDisable(true);
    		cbArrAirport.setDisable(true);
    		cbDeptAirport.setDisable(true);
    	}
    	else {
    		cbAirlineNo.getItems().clear();
    		cbAirline.setDisable(false);
    		cbArrAirport.setDisable(false);
    		cbDeptAirport.setDisable(false);
    		selectedChoiceBox=0;
    		
			cbAirlineNo.setValue("Select Airline No");
    	}
    		
    }


    @FXML
    void deptSelected(ActionEvent event) {
    	if(rbDeptAirport.isSelected())
    	{
    		selectedChoiceBox=3;
    		
    		if(cbDeptAirport.getItems().size()<=0)
    		cbDeptAirport.getItems().addAll(deptList);
    		
    		rbAirlineNo.setSelected(false);
    		rbAirline.setSelected(false);
    		rbArrAirport.setSelected(false);
    		
    		cbDeptAirport.setDisable(false);
    		cbAirline.setDisable(true);
    		cbArrAirport.setDisable(true);
    		cbAirlineNo.setDisable(true);
    	}
    	else {
    		cbDeptAirport.getItems().clear();
    		cbAirlineNo.setDisable(false);
    		cbAirline.setDisable(false);
    		cbArrAirport.setDisable(false);
    		selectedChoiceBox=0;
    		
			cbDeptAirport.setValue("Select Departure airport");
    	}
    }

    @FXML
    void arrSelected(ActionEvent event) {
    	if(rbArrAirport.isSelected())
    	{
    		selectedChoiceBox=4;
    		
    		if(cbArrAirport.getItems().size()<=0)
    		cbArrAirport.getItems().addAll(arrList);
    		
    		rbAirlineNo.setSelected(false);
    		rbAirline.setSelected(false);
    		rbDeptAirport.setSelected(false);
    		
    		cbArrAirport.setDisable(false);
    		cbAirline.setDisable(true);
    		cbDeptAirport.setDisable(true);
    		cbAirlineNo.setDisable(true);
    	}
    	else
    	{
    		cbArrAirport.getItems().clear();
    		cbAirlineNo.setDisable(false);
    		cbAirline.setDisable(false);
    		cbDeptAirport.setDisable(false);
    		selectedChoiceBox=0;
    		
			cbArrAirport.setValue("Select Arrival Airport");
    	}
    }



    @FXML
    void onCloseClicked(ActionEvent event) {
    	Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onSearchClicked(ActionEvent event) 
    {
    	String a;
    	switch(selectedChoiceBox)
    	{
    	case 1:
    		a = cbAirline.getSelectionModel().getSelectedItem();
    		tableData.clear();
    		for(i = 0; i < airArray.size();i++)
    		{
    			if(airArray.get(i).getAirline().equals(a))
    			{
    				tableData.add(new AirlineTable(airArray.get(i).getAirline(),airArray.get(i).getAirlineNo(),airArray.get(i).getDeptAirport(),
    						airArray.get(i).getArrAirport()));
    			}
    		}
    		
    		break;
    	case 2:
    		 a = cbAirlineNo.getSelectionModel().getSelectedItem();
    		 tableData.clear();
    		for(i = 0; i < airArray.size();i++)
    		{
    			if(airArray.get(i).getAirlineNo().equals(a))
    			{
    				tableData.add(new AirlineTable(airArray.get(i).getAirline(),airArray.get(i).getAirlineNo(),
    						airArray.get(i).getDeptAirport(), airArray.get(i).getArrAirport()));
    			}
    		}
    		break;
    	case 3:
    		a = cbDeptAirport.getSelectionModel().getSelectedItem();
    		tableData.clear();
    		for(i = 0; i < airArray.size();i++)
    		{
    			if(airArray.get(i).getDeptAirport().equals(a))
    			{
    				tableData.add(new AirlineTable(airArray.get(i).getAirline(),airArray.get(i).getAirlineNo(),
    						airArray.get(i).getDeptAirport(), airArray.get(i).getArrAirport()));
    			}
    		}
    		break;
    	case 4:
    		 a = cbArrAirport.getSelectionModel().getSelectedItem();
    		 tableData.clear();
    		for(i = 0; i < airArray.size();i++)
    		{
    			if(airArray.get(i).getArrAirport().equals(a))
    			{
    				tableData.add(new AirlineTable(airArray.get(i).getAirline(),airArray.get(i).getAirlineNo(),airArray.get(i).getArrAirport(),
    						airArray.get(i).getDeptAirport()));
    			}
    		}
    		break;
    	case 0:
    		tableData.clear();
    		airlineTableView.getItems().clear();
    		break;
    	}
    	airlineTableView.setItems(tableData);
    }

}
