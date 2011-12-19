package org.lindbergframework.test.testBeans;

import java.util.Date;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class Person {
	
	private String nickname, profession;
	private Integer id;
	private Address addres;
	private Date birthDate;
	
	public Person(){
		//
	}
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Address getAddres() {
		return addres;
	}

	public void setAddres(Address addres) {
		this.addres = addres;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
