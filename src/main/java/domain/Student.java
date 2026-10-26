package domain;



public class Student {
	//JDBC 데이터를 받아올 처리용 
	private int stu_no;
	private String stu_name;
	private String stu_dept;
	private int stu_grade;
	private char stu_class;
	private char gender;
	private int stu_height;
	private int stu_weight;
	
	public int getStu_no() {
		return stu_no;
	}
	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_dept() {
		return stu_dept;
	}
	public void setStu_dept(String stu_dept) {
		this.stu_dept = stu_dept;
	}
	public int getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(int stu_grade) {
		this.stu_grade = stu_grade;
	}
	public char getStu_class() {
		return stu_class;
	}
	public void setStu_class(char stu_class) {
		this.stu_class = stu_class;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getStu_height() {
		return stu_height;
	}
	public void setStu_height(int stu_height) {
		this.stu_height = stu_height;
	}
	public int getStu_weight() {
		return stu_weight;
	}
	public void setStu_weight(int stu_weight) {
		this.stu_weight = stu_weight;
	}
	@Override
	public String toString() {
		return "Student [stu_no=" + stu_no + ", stu_name=" + stu_name + ", stu_dept=" + stu_dept + ", stu_grade="
				+ stu_grade + ", stu_class=" + stu_class + ", gender=" + gender + ", stu_height=" + stu_height
				+ ", stu_weight=" + stu_weight + "]";
	}
	
	
	
	
}
