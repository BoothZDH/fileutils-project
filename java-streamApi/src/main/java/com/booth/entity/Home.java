package com.booth.entity;

/**
 * @ClassName: home
 * @Description:TODO
 * @Version:1.0
 */
public class Home {

	public Integer codeNum;
	public Integer FamilysNum;
	public String lastName;
	public String phoneNum ;

	public Integer getCodeNum() {
		return codeNum;
	}

	public void setCodeNum(Integer codeNum) {
		this.codeNum = codeNum;
	}

	public Integer getFamilysNum() {
		return FamilysNum;
	}

	public void setFamilysNum(Integer familysNum) {
		FamilysNum = familysNum;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Home(Integer codeNum, Integer familysNum, String lastName, String phoneNum) {
		this.codeNum = codeNum;
		FamilysNum = familysNum;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
	}

	public Home() {
	}

	public Home(Integer codeNum) {
		this.codeNum = codeNum;
	}

	public Home(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Home home = (Home) o;

		if (codeNum != null ? !codeNum.equals(home.codeNum) : home.codeNum != null) {
			return false;
		}
		if (FamilysNum != null ? !FamilysNum.equals(home.FamilysNum) : home.FamilysNum != null) {
			return false;
		}
		if (lastName != null ? !lastName.equals(home.lastName) : home.lastName != null) {
			return false;
		}
		return phoneNum != null ? phoneNum.equals(home.phoneNum) : home.phoneNum == null;
	}

	@Override
	public int hashCode() {
		int result = codeNum != null ? codeNum.hashCode() : 0;
		result = 31 * result + (FamilysNum != null ? FamilysNum.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Home{" +
				"codeNum=" + codeNum +
				", FamilysNum=" + FamilysNum +
				", lastName='" + lastName + '\'' +
				", phoneNum='" + phoneNum + '\'' +
				'}';
	}
}
