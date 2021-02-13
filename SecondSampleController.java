package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class SecondSampleController extends SampleController implements Initializable, EventHandler<ActionEvent> {

	String s;
	@FXML
	private TableView<Contact> TV;
	@FXML
	private TableColumn<Contact,String> title;
	@FXML
	private TableColumn<Contact,String> FirstName;
	@FXML
	private TableColumn<Contact,String> LastName;
	@FXML
	private TableColumn<Contact,String> id;
	@FXML
	private TableColumn<Contact,String> email;
	@FXML
	private TableColumn<Contact,String> hw;
	@FXML
	private TableColumn<Contact,String> quizzes;
	@FXML
	private TableColumn<Contact,String> lab;
	@FXML
	private TableColumn<Contact,String> MT;
	@FXML
	private TableColumn<Contact,String> CT;
	@FXML
	private TableColumn<Contact,String> Final;
	@FXML
	private TableColumn<Contact,String> total;
	@FXML
	private TableColumn<Contact,String> LG;
	@FXML
	Button send;
	@FXML
	Button pdf;
	@FXML
	PasswordField pass;
	@FXML
	TextField user;
String F = "you will get F";
	public ObservableList<Contact> list1= FXCollections.observableArrayList(a);

	@Override
	public void handle(ActionEvent event) {

		if(!(user.getText().isEmpty())&&!(pass.getText().isEmpty())){
			send.setDisable(false);
		}

		if(event.getSource()==send){

				boolean u = true;

			for(int i = 1 ; i<a.size() ; i++){
			s=g;
			s=s.replace(a.get(0).getTitle(), a.get(i).getTitle());
			s=s.replace(a.get(0).getFirstName(), a.get(i).getFirstName());
			s=s.replace(a.get(0).getLastName(), a.get(i).getLastName());
			s=s.replace(a.get(0).getId(), a.get(i).getId());
			s=s.replace(a.get(0).getEmail(), a.get(i).getEmail());
			s=s.replace(a.get(0).getHW(), a.get(i).getHW());
			s=s.replace(a.get(0).getQuizzes(), a.get(i).getQuizzes());
			s=s.replace(a.get(0).getLab(), a.get(i).getLab());
			s=s.replace(a.get(0).getMidTerm(), a.get(i).getMidTerm());
			s=s.replace(a.get(0).getClassTest(), a.get(i).getClassTest());
			s=s.replace(a.get(0).getFinal(), a.get(i).getFinal());
			s=s.replace(a.get(0).getTotal(), a.get(i).getTotal());
			s=s.replace(a.get(0).getLetterGrade(), a.get(i).getLetterGrade());


			SendEmailOffice365 S = new SendEmailOffice365(user.getText(),pass.getText(),a.get(i).getEmail()," ",s);
			if(S.sendEmail()){
				u = true;
			}
			else{u = false;
			}
			}
			if(u==true){
				Alert AS = new Alert(AlertType.INFORMATION);
				AS.setContentText("Your email has been sent successfully");
				AS.setTitle("Success");
				AS.setHeaderText("Information alert");
				AS.show();
			}
			else if(u==false){
				Alert Af = new Alert(AlertType.ERROR);
				Af.setContentText("your email didn't go through");
				Af.setTitle("Failed");
				Af.show();
			}
			
			}
		else if(event.getSource()==pdf){





			Document G = new Document(PageSize.A4, 50, 50, 50, 50);
			try {

				FileChooser F = new FileChooser();
				F.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));

				File S = F.showSaveDialog(null);
				PdfWriter w = PdfWriter.getInstance(G, new FileOutputStream(S.getAbsolutePath()));


			G.open();

			     for(int i = 1 ; i<a.size() ; i++){
						s=g;
						s=s.replace(a.get(0).getTitle(), a.get(i).getTitle());
						s=s.replace(a.get(0).getFirstName(), a.get(i).getFirstName());
						s=s.replace(a.get(0).getLastName(), a.get(i).getLastName());
						s=s.replace(a.get(0).getId(), a.get(i).getId());
						s=s.replace(a.get(0).getEmail(), a.get(i).getEmail());
						s=s.replace(a.get(0).getHW(), a.get(i).getHW());
						s=s.replace(a.get(0).getQuizzes(), a.get(i).getQuizzes());
						s=s.replace(a.get(0).getLab(), a.get(i).getLab());
						s=s.replace(a.get(0).getMidTerm(), a.get(i).getMidTerm());
						s=s.replace(a.get(0).getClassTest(), a.get(i).getClassTest());
						s=s.replace(a.get(0).getFinal(), a.get(i).getFinal());
						s=s.replace(a.get(0).getTotal(), a.get(i).getTotal());
						s=s.replace(a.get(0).getLetterGrade(), a.get(i).getLetterGrade());

			  G.add(new Paragraph(s, FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(255, 255,255,255))));
			     G.newPage();
			     }
			G.close();
			w.close();
			}


			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		}


	//}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		send.setDisable(true);

		title.setCellValueFactory(new PropertyValueFactory<Contact ,String>("title"));
		FirstName.setCellValueFactory(new PropertyValueFactory<Contact ,String>("firstName"));
		LastName.setCellValueFactory(new PropertyValueFactory<Contact ,String>("lastName"));
		id.setCellValueFactory(new PropertyValueFactory<Contact ,String>("id"));
		email.setCellValueFactory(new PropertyValueFactory<Contact ,String>("email"));
		hw.setCellValueFactory(new PropertyValueFactory<Contact ,String>("HW"));
		quizzes.setCellValueFactory(new PropertyValueFactory<Contact ,String>("quizzes"));
		lab.setCellValueFactory(new PropertyValueFactory<Contact ,String>("lab"));
		MT.setCellValueFactory(new PropertyValueFactory<Contact ,String>("midTerm"));
		CT.setCellValueFactory(new PropertyValueFactory<Contact ,String>("classTest"));
		Final.setCellValueFactory(new PropertyValueFactory<Contact ,String>("Final"));
		total.setCellValueFactory(new PropertyValueFactory<Contact ,String>("total"));
		LG.setCellValueFactory(new PropertyValueFactory<Contact ,String>("letterGrade"));

		TV.setItems(list1);

	}

}
