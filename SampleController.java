package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SampleController implements Initializable, EventHandler<ActionEvent> {

	public static ArrayList<Contact> a = new ArrayList<Contact>();
	public static String g ;

	@FXML
	Button load;
	@FXML
	TextArea txtA;
	@FXML
	public ComboBox <String> CoBo;
	@FXML
	Button Start;
	@FXML
	MenuItem loadT;
	@FXML
	MenuItem save;
	@FXML
	MenuItem saveAs;
	@FXML
	Label lbl;


	ObservableList<String> list = FXCollections.observableArrayList("[[TITLE]]",
			"[[FIRST_NAME]]","[[LAST_NAME]]","[[ID_NUMBER]]","[[EMAIL]]","[[HW]]","[[QUIZZES]]","[[LAB]]","[[MIDTERM]]",
			"[[CLASS_TESTS]]","[[FINAL]]","[[TOTAL]]","[[LETTER_GRADE]]");
		int i = 1;
		int m=0;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CoBo.setItems(list);
		Start.setDisable(true);
		
	}



	@Override
	public void handle(ActionEvent event){
			
		if(event.getSource()==saveAs){
			FileChooser F = new FileChooser();
			F.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
			F.getExtensionFilters().addAll(new ExtensionFilter("CSV Files", "*.csv"));
			File s = F.showSaveDialog(null);
			try {
				PrintWriter p1 = new PrintWriter(new FileOutputStream(s.getAbsolutePath()));
				p1.write(txtA.getText());
				p1.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			}

		else if (event.getSource()==loadT){
			FileChooser F = new FileChooser();
			F.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
			File s = F.showOpenDialog(null);
			try {
				Scanner N1 = new Scanner(new FileInputStream(s.getAbsolutePath()));

				while(N1.hasNextLine()){
					txtA.appendText(N1.nextLine()+"\n");
				}
			N1.close();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
			
			else if(event.getSource()==load){
			FileChooser F = new FileChooser();
			F.getExtensionFilters().addAll(new ExtensionFilter("CSV Files", "*.csv"));

			File s = F.showOpenDialog(null);

				if (s != null){
					try {
				a.add(0,new Contact("[[TITLE]]","[[FIRST_NAME]]","[[LAST_NAME]]","[[ID_NUMBER]]",
						"[[EMAIL]]","[[HW]]","[[QUIZZES]]","[[LAB]]","[[MIDTERM]]",
						"[[CLASS_TESTS]]","[[FINAL]]","[[TOTAL]]","[[LETTER_GRADE]]"));

					Scanner n1 = new Scanner(new FileInputStream(s.getAbsolutePath()));
					Scanner n2 = new Scanner(new FileInputStream(s.getAbsolutePath()));


				while (n2.hasNextLine()){
					n2.nextLine();
					m++;
				}
				n1.nextLine();
				for(int w =0 ; w<m-1;w++)
				{

				String	data = n1.next();

				String title = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String FirstName = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String LastName = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String ID = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String Email = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String HomeWork = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String quizzes = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String Lab = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String MidTerm = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String ClassTest = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String Final = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String Total = data.substring(0, data.indexOf(","));
				data = data.substring(data.indexOf(",")+1);
				String letterGrade = data;


		a.add(i, new Contact(title,FirstName,LastName,ID,Email,HomeWork,quizzes,Lab,MidTerm,
				ClassTest,Final,Total,letterGrade));
		i++;
		}

				
				
				
				lbl.setText(" " +"is loaded");
				lbl.setText(s.getName()+" " +"is loaded");
				Start.setDisable(false);
				n1.close();
				n2.close();
		} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
							}

			}
		else if(event.getSource()== CoBo){

			txtA.appendText((CoBo.getValue()));
		}
		
		
	}

		public void handler(ActionEvent event){
				g=txtA.getText();
			try {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondSample.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setScene(new Scene(root1));
				stage.show();


			} catch (IOException e) {

				e.printStackTrace();
			}
		}




}
