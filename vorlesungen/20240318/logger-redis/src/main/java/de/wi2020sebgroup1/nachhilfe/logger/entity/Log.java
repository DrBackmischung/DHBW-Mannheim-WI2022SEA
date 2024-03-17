package de.wi2020sebgroup1.nachhilfe.logger.entity;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Log")
public class Log implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String message;
	private String type;
	private String date;
	private String time;
	private String source;
	
	public Log() {
		
	}

	public Log(String id, String title, String message, String type, String date, String time, String source) {
		super();
		this.id = id;
		this.title = title;
		this.message = message;
		this.type = type;
		this.date = date;
		this.time = time;
		this.source = source;
	}

	public Log(String title, String message, String type, String date, String time, String source) {
		super();
		this.title = title;
		this.message = message;
		this.type = type;
		this.date = date;
		this.time = time;
		this.source = source;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", title=" + title + ", message=" + message + ", type=" + type + ", date=" + date
				+ ", time=" + time + ", source=" + source + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, message, source, time, title, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(message, other.message) && Objects.equals(source, other.source)
				&& Objects.equals(time, other.time) && Objects.equals(title, other.title)
				&& Objects.equals(type, other.type);
	}
	
}
