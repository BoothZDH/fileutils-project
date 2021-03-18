package com.booth.entity;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: EmployEntity
 * @Description:TODO
 * @Version:1.0
 */
public class EmployEntity {
	@JSONField(ordinal = 1)
	public int id;
	@JSONField(ordinal = 2)
	public String name;
	@JSONField(ordinal = 3)
	public int age;
	@JSONField(ordinal = 4,format = "yyyyMMdd")
	public Double salary;
	@JSONField(ordinal = 5)
	public String status;

	public EmployEntity(int id, String name, int age, Double salary, String status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}

	public EmployEntity() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void getStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EmployEntity that = (EmployEntity) o;

		if (id != that.id) {
			return false;
		}
		if (age != that.age) {
			return false;
		}
		if (name != null ? !name.equals(that.name) : that.name != null) {
			return false;
		}
		if (salary != null ? !salary.equals(that.salary) : that.salary != null) {
			return false;
		}
		return status == that.status;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + age;
		result = 31 * result + (salary != null ? salary.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		return result;
	}
}
