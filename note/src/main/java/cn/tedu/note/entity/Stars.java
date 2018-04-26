package cn.tedu.note.entity;

import java.io.Serializable;
import java.util.Objects;

public class Stars implements Serializable {
	private static final long serialVersionUID = -2402091082427412347L;
	private String id;
	private String userId;
	private Integer stars;

	public Stars() {
	}

	public Stars(String id, String userId, Integer stars) {
		this.id = id;
		this.userId = userId;
		this.stars = stars;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Stars{" +
			"id='" + id + '\'' +
			", userId='" + userId + '\'' +
			", stars=" + stars +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Stars stars = (Stars) o;
		return Objects.equals(id, stars.id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}
