package cn.tedu.note.entity;

import java.io.Serializable;
import java.util.Objects;

public class Notebook implements Serializable{
	private static final long serialVersionUID = 6645889448531380183L;
	private String id;
	private String name;
	private String typeId;
	private String userId;
	private String desc;
	private long createTime;

	public Notebook() {
	}

	public Notebook(String id, String name, String typeId, String userId, String desc, long createTime){
		this.id = id;
		this.name = name;
		this.typeId = typeId;
		this.userId = userId;
		this.desc = desc;
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Notebook{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", typeId='" + typeId + '\'' +
			", userId='" + userId + '\'' +
			", desc='" + desc + '\'' +
			", createTime=" + createTime +
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
		Notebook notebook = (Notebook) o;
		return Objects.equals(id, notebook.id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		return prime * result + ((id == null) ? 0 : id.hashCode());
	}
}
