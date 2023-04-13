package br.com.magna.confeccao.entities;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class AbstractEntity<T, ID> {
	
	protected String userFirstInsert;
	protected String userLastModified;
	protected ZonedDateTime timeStamp;
	
	@Column(name="USER_FIRST_INSERT")
	public String getUser_first_insert() {
		return userFirstInsert;
	}

	public void setUser_first_insert(String user_first_insert) {
		this.userFirstInsert = user_first_insert;
	}

	@Column(name="USER_LAST_MODIFIED")
	public String getUser_last_modified() {
		return userLastModified;
	}

	public void setUser_last_modified(String user_last_modified) {
		this.userLastModified = user_last_modified;
	}

	@Column(name="TIMESTAMP")
	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(ZonedDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	public abstract Long getId();
	
	public abstract void setId(ID id);
	
	

}
