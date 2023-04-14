package br.com.magna.confeccao.entities;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class AbstractEntity<T, ID> {
	
	protected String userFirstInsert;
	protected String userLastModified;
	protected ZonedDateTime timeStampFirstInsert;
	protected ZonedDateTime timeStampLastModified;
	
	@Column(name="USER_FIRST_INSERT")
	public String getUserFirstInsert() {
		return userFirstInsert;
	}

	public void setUserFirstInsert(String userFirstInsert) {
		this.userFirstInsert = userFirstInsert;
	}

	@Column(name="USER_LAST_MODIFIED")
	public String getUserLastModified() {
		return userLastModified;
	}

	public void setUserLastModified(String userLastModified) {
		this.userLastModified = userLastModified;
	}


	@Column(name="TIMESTAMP_FIRST_INSERT")
	public ZonedDateTime getTimeStampfirstInsert() {
		return timeStampFirstInsert;
	}

	public void setTimeStampFirstInsert(ZonedDateTime timeStampFirstInsert) {
		this.timeStampFirstInsert = timeStampFirstInsert;
	}

	@Column(name="TIMESTAMP_LAST_MODIFIED")
	public ZonedDateTime getTimeStampLastModified() {
		return timeStampLastModified;
	}

	public void setTimeStampLastModified(ZonedDateTime timeStampLastModified) {
		this.timeStampLastModified = timeStampLastModified;
	}

	public abstract Long getId();
	
	public abstract void setId(ID id);
	
	

}
