package giorno1;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
  
	private int id;
	private String name;
	private String lastname;
	private String birthdate;
	private String gender;
	private double avg;
	private int min_vote;
	private int max_vote;
	
	public Student(String name, String lastname, String birthdate, String gender, double avg, int min_vote,
			int max_vote) {	
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.gender = gender;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(Integer avg) {
		this.avg = avg;
	}

	public int getMin_vote() {
		return min_vote;
	}

	public void setMin_vote(Integer min_vote) {
		this.min_vote = min_vote;
	}

	public int getMax_vote() {
		return max_vote;
	}

	public void setMax_vote(Integer max_vote) {
		this.max_vote = max_vote;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
