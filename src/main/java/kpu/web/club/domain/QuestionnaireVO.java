package kpu.web.club.domain;

public class QuestionnaireVO {
	
	private String no;
	private String name;	
	private String tel;
	private String birth;
	private String sex;
	private Boolean Q1;
	private Boolean Q2;
	private Boolean Q3;
	private String register_date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Boolean getQ1() {
		return Q1;
	}
	public void setQ1(Boolean q1) {
		Q1 = q1;
	}
	public Boolean getQ2() {
		return Q2;
	}
	public void setQ2(Boolean q2) {
		Q2 = q2;
	}
	public Boolean getQ3() {
		return Q3;
	}
	public void setQ3(Boolean q3) {
		Q3 = q3;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	

}
