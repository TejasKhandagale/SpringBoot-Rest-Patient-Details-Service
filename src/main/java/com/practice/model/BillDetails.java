package com.practice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BILL_DTLS")
public class BillDetails {

	@Id
	@Column(name = "BILL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int bid;
	
	@Column(name = "B_DATE")
	public Date billDate;
	
	@Column(name = "B_TOTAL_AMOUNT")
	public String totalAmount;
	
	@Column(name = "B_PAID_AMOUNT")
	public String paidAmount;
	
	@Column(name = "B_UNPAID_AMOUNT")
	public String unpaidAmount;
	
	@Column(name = "B_STATUS")
	public String status;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getUnpaidAmount() {
		return unpaidAmount;
	}

	public void setUnpaidAmount(String unpaidAmount) {
		this.unpaidAmount = unpaidAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

