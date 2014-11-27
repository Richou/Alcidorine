package net.heanoria.appengine.alcidorine.entity;

import static net.heanoria.appengine.alcidorine.entity.Memo.MEMO_CATEGORY_FIELD;

import java.util.List;

import javax.jdo.annotations.Persistent;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class MemoCategory {

	public static final String MEMOCAT_ID_FIELD = "id";
	public static final String MEMOCAT_TITLE_FIELD = "title";
	public static final String MEMOCAT_DESCRIPTION_FIELD = "description";
	public static final String MEMOCAT_PARENT_FIELD = "parent";
	public static final String MEMOCAT_CHILDREN_FIELD ="children";
	
	/* Fields */
	
	@Id
	private Long id;
	
	private String title;
	private String description;
	
	/* Relationships */
	
	@Persistent
	private MemoCategory parent;
	
	@Persistent(mappedBy = MEMOCAT_PARENT_FIELD)
	private List<MemoCategory> children;
	
	@Persistent(mappedBy = MEMO_CATEGORY_FIELD) 
	private List<Memo> memos;

	/* Getters & Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MemoCategory getParent() {
		return parent;
	}

	public void setParent(MemoCategory parent) {
		this.parent = parent;
	}

	public List<MemoCategory> getChildren() {
		return children;
	}

	public void setChildren(List<MemoCategory> children) {
		this.children = children;
	}

	public List<Memo> getMemos() {
		return memos;
	}

	public void setMemos(List<Memo> memos) {
		this.memos = memos;
	}
	
}
