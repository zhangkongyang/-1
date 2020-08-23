package com.yc.fresh.entity;

import java.io.Serializable;

public class OrderItemInfo implements Serializable {
	private static final long serialVersionUID = 6705137857967163264L;
	private Integer ino;
	private String ono;
	private Integer gno;
	private Integer nums;
	private double price;
	private Integer status;
	/**
	 * @return the ino
	 */
	public Integer getIno() {
		return ino;
	}
	/**
	 * @param ino the ino to set
	 */
	public void setIno(Integer ino) {
		this.ino = ino;
	}
	/**
	 * @return the ono
	 */
	public String getOno() {
		return ono;
	}
	/**
	 * @param ono the ono to set
	 */
	public void setOno(String ono) {
		this.ono = ono;
	}
	/**
	 * @return the gno
	 */
	public Integer getGno() {
		return gno;
	}
	/**
	 * @param gno the gno to set
	 */
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	/**
	 * @return the nums
	 */
	public Integer getNums() {
		return nums;
	}
	/**
	 * @param nums the nums to set
	 */
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gno == null) ? 0 : gno.hashCode());
		result = prime * result + ((ino == null) ? 0 : ino.hashCode());
		result = prime * result + ((nums == null) ? 0 : nums.hashCode());
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemInfo other = (OrderItemInfo) obj;
		if (gno == null) {
			if (other.gno != null)
				return false;
		} else if (!gno.equals(other.gno))
			return false;
		if (ino == null) {
			if (other.ino != null)
				return false;
		} else if (!ino.equals(other.ino))
			return false;
		if (nums == null) {
			if (other.nums != null)
				return false;
		} else if (!nums.equals(other.nums))
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	public OrderItemInfo(Integer ino, String ono, Integer gno, Integer nums, double price, Integer status) {
		super();
		this.ino = ino;
		this.ono = ono;
		this.gno = gno;
		this.nums = nums;
		this.price = price;
		this.status = status;
	}
	public OrderItemInfo() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderItemInfo [ino=" + ino + ", ono=" + ono + ", gno=" + gno + ", nums=" + nums + ", price=" + price
				+ ", status=" + status + "]";
	}
	
	

}
