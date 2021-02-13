package application;

public class Contact {
	private String title;
	private String firstName;
	private String lastName;
	private String id;
	private String email;
	private String HW;
	private String quizzes;
	private String lab;
	private String midTerm;
	private String classTest;
	private String Final;
	private String total;
	private String letterGrade;


	public Contact (String title , String firstName , String lastName , String id,
			String email, String HW , String quizzes , String lab , String midTerm ,
			String classTest, String Final , String total , String letterGrade){

		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
		this.HW = HW;
		this.quizzes = quizzes;
		this.lab = lab;
		this.midTerm = midTerm;
		this.classTest =classTest;
		this.Final = Final ;
		this.total = total;
		this.letterGrade = letterGrade;
	}

	
	
	
	
	public String getTitle() {
		return title;
	}





	public String getFirstName() {
		return firstName;
	}





	public String getLastName() {
		return lastName;
	}





	public String getId() {
		return id;
	}





	public String getEmail() {
		return email;
	}





	public String getHW() {
		return HW;
	}





	public String getQuizzes() {
		return quizzes;
	}





	public String getLab() {
		return lab;
	}





	public String getMidTerm() {
		return midTerm;
	}





	public String getClassTest() {
		return classTest;
	}





	public String getFinal() {
		return Final;
	}





	public String getTotal() {
		return total;
	}





	public String getLetterGrade() {
		return letterGrade;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public void setId(String id) {
		this.id = id;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public void setHW(String hW) {
		HW = hW;
	}





	public void setQuizzes(String quizzes) {
		this.quizzes = quizzes;
	}





	public void setLab(String lab) {
		this.lab = lab;
	}





	public void setMidTerm(String midTerm) {
		this.midTerm = midTerm;
	}





	public void setClassTest(String classTest) {
		this.classTest = classTest;
	}





	public void setFinal(String final1) {
		Final = final1;
	}





	public void setTotal(String total) {
		this.total = total;
	}





	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}





	public String toString(){
		
		return (title +" "+ firstName +" "+ lastName +" "+ id +" "+ 
		email +" "+ HW +" "+ quizzes +" "+ lab +" "+ midTerm +" "+
				classTest +" "+ Final +" "+ total +" "+ letterGrade +"\n");
	}
}
