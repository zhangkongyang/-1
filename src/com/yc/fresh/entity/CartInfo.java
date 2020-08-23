package com.yc.fresh.entity;

import java.io.Serializable;

import com.yc.fresh.util.StringUtil;

public class CartInfo implements Serializable {
	private static final long serialVersionUID = 8848852000123844918L;
	private String cno;
	private Integer mno;
	private Integer gno;
	private Integer num;
	
	private String gname;
	private Double price;
	private String  pics;
	private String unit;
	private String  weight;
	/**
	 * @return the cno
	 */
	public String getCno() {
		return cno;
	}
	/**
	 * @param cno the cno to set
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}
	/**
	 * @return the mno
	 */
	public Integer getMno() {
		return mno;
	}
	/**
	 * @param mno the mno to set
	 */
	public void setMno(Integer mno) {
		this.mno = mno;
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
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * @return the gname
	 */
	public String getGname() {
		return gname;
	}
	/**
	 * @param gname the gname to set
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the pics
	 */
	public String getPics() {
		return pics;
	}
	/**
	 * @param pics the pics to set
	 */
	public void setPics(String pics) {
		if(!StringUtil.checkNull(pics)){
			this.pics=pics.split(";")[0];
			return;
		}
		this.pics = pics;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public CartInfo(String cno, Integer mno, Integer gno, Integer num, String gname, Double price, String pics,
			String unit, String weight) {
		super();
		this.cno = cno;
		this.mno = mno;
		this.gno = gno;
		this.num = num;
		this.gname = gname;
		this.price = price;
		this.pics = pics;
		this.unit = unit;
		this.weight = weight;
	}
	public CartInfo() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarInfo [cno=" + cno + ", mno=" + mno + ", gno=" + gno + ", num=" + num + ", gname=" + gname
				+ ", price=" + price + ", pics=" + pics + ", unit=" + unit + ", weight=" + weight + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cno == null) ? 0 : cno.hashCode());
		result = prime * result + ((gname == null) ? 0 : gname.hashCode());
		result = prime * result + ((gno == null) ? 0 : gno.hashCode());
		result = prime * result + ((mno == null) ? 0 : mno.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((pics == null) ? 0 : pics.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		CartInfo other = (CartInfo) obj;
		if (cno == null) {
			if (other.cno != null)
				return false;
		} else if (!cno.equals(other.cno))
			return false;
		if (gname == null) {
			if (other.gname != null)
				return false;
		} else if (!gname.equals(other.gname))
			return false;
		if (gno == null) {
			if (other.gno != null)
				return false;
		} else if (!gno.equals(other.gno))
			return false;
		if (mno == null) {
			if (other.mno != null)
				return false;
		} else if (!mno.equals(other.mno))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (pics == null) {
			if (other.pics != null)
				return false;
		} else if (!pics.equals(other.pics))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	
	

}
