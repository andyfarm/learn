package cn.tedu.note.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 马成杰
 */
public class Share implements Serializable{
	private static final long serialVersionUID = 4614532048705269923L;
	private String id;
	private String title;
	private String body;
	private String noteId;

	public Share() {
	}

	public Share(String id, String title, String body, String noteId) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.noteId = noteId;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	@Override
	public String toString() {
		return "Share{" +
			"id='" + id + '\'' +
			", title='" + title + '\'' +
			", body='" + body + '\'' +
			", noteId='" + noteId + '\'' +
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
		Share share = (Share) o;
		return Objects.equals(id, share.id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		return prime * result + ((id == null) ? 0 : id.hashCode());
	}
}
