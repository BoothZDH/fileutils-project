package com.booth.domain;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: order
 * @Description:TODO
 * @Version:1.0
 */
public class Order {

	private int id;
	private Date orderTime;
	private Double total;
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Order() {
	}

	public Order(int id, Date orderTime, Double total, Student student) {
		this.id = id;
		this.orderTime = orderTime;
		this.total = total;
		this.student = student;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		if (id != order.id) return false;
		if (orderTime != null ? !orderTime.equals(order.orderTime) : order.orderTime != null) return false;
		if (total != null ? !total.equals(order.total) : order.total != null) return false;
		return student != null ? student.equals(order.student) : order.student == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
		result = 31 * result + (total != null ? total.hashCode() : 0);
		result = 31 * result + (student != null ? student.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", orderTime=" + orderTime +
				", total=" + total +
				", student=" + student +
				'}';
	}
}
