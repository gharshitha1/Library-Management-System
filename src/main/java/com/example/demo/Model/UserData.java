package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name="userdata")
@NamedQuery(name="UserData.findByDays",query="from UserData d where d.days>=10")
@NamedQuery(name="UserData.findByRollno",query="from UserData d where d.rollno=?1")
public class UserData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String bookname;
	@Column
	private String rollno;
	@Column
	private String date;
	@Column
	private String sdate;
	@Column
	private long days;
	@Column
	private String fine;
	
	public String getFine() {
		return fine;
	}
	public void setFine(String fine) {
		this.fine = fine;
	}
	public long getDays() {
		return days;
	}
	public void setDays(long days) {
		this.days = days;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", name=" + name + ", bookname=" + bookname + ", rollno=" + rollno + ", date="
				+ date + ", sdate=" + sdate + ", days=" + days + ", fine=" + fine + "]";
	}
}
