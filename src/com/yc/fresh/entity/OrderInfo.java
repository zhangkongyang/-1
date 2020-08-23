package com.yc.fresh.entity;

import java.io.Serializable;

public class OrderInfo implements Serializable{
	private static final long serialVersionUID = -8700410980566181150L;
	private String  ono;
	private String odate;
	private String ano;
	private String sdate;
	private String rdate;
	private Integer status;
	private Double price;
	private Integer invoice;
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
	 * @return the odate
	 */
	public String getOdate() {
		return odate;
	}
	/**
	 * @param odate the odate to set
	 */
	public void setOdate(String odate) {
		this.odate = odate;
	}
	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}
	/**
	 * @param ano the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
	/**
	 * @return the sdate
	 */
	public String getSdate() {
		return sdate;
	}
	/**
	 * @param sdate the sdate to set
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	/**
	 * @return the rdate
	 */
	public String getRdate() {
		return rdate;
	}
	/**
	 * @param rdate the rdate to set
	 */
	public void setRdate(String rdate) {
		this.rdate = rdate;
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
	 * @return the invoice
	 */
	public Integer getInvoice() {
		return invoice;
	}
	/**
	 * @param invoice the invoice to set
	 */
	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
	}
	public OrderInfo(String ono, String odate, String ano, String sdate, String rdate, Integer status, Double price,
			Integer invoice) {
		super();
		this.ono = ono;
		this.odate = odate;
		this.ano = ano;
		this.sdate = sdate;
		this.rdate = rdate;
		this.status = status;
		this.price = price;
		this.invoice = invoice;
	}
	public OrderInfo() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
		result = prime * result + ((odate == null) ? 0 : odate.hashCode());
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((rdate == null) ? 0 : rdate.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
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
		OrderInfo other = (OrderInfo) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (invoice == null) {
			if (other.invoice != null)
				return false;
		} else if (!invoice.equals(other.invoice))
			return false;
		if (odate == null) {
			if (other.odate != null)
				return false;
		} else if (!odate.equals(other.odate))
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (rdate == null) {
			if (other.rdate != null)
				return false;
		} else if (!rdate.equals(other.rdate))
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderInfo [ono=" + ono + ", odate=" + odate + ", ano=" + ano + ", sdate=" + sdate + ", rdate=" + rdate
				+ ", status=" + status + ", price=" + price + ", invoice=" + invoice + "]";
	}
	
	

}
