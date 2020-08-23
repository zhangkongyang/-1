package com.yc.fresh.entity;

import java.io.Serializable;

public class AdminInfo implements Serializable {
	private static final long serialVersionUID = -3571301482241775928L;
	
	private Integer aid;
	private String aname;
	private String pwd;
	private String tel;
	
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return the aid
	 */
	public Integer getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	/**
	 * @return the aname
	 */
	public String getAname() {
		return aname;
	}
	/**
	 * @param aname the aname to set
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public AdminInfo(Integer aid, String aname, String pwd) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.pwd = pwd;
	}
	public AdminInfo() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public AdminInfo(Integer aid, String aname, String pwd, String tel) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.pwd = pwd;
		this.tel = tel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdminInfo [aid=" + aid + ", aname=" + aname + ", pwd=" + pwd + ", tel=" + tel + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		AdminInfo other = (AdminInfo) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	
	
	

}
