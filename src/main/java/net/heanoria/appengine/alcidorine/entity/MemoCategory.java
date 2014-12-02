package net.heanoria.appengine.alcidorine.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class MemoCategory {

	public static final String MEMOCAT_ID_FIELD = "id";
	public static final String MEMOCAT_TITLE_FIELD = "title";
	public static final String MEMOCAT_DESCRIPTION_FIELD = "description";
	public static final String MEMOCAT_PARENT_FIELD = "parent";
	public static final String MEMOCAT_CHILDREN_FIELD ="children";
	
	/* Fields */
	
	@Id private Long id;
	
	@Index private String title;
	@Index private String description;
	
	/* RelationShips */
	
	@Load
	@Index
	private Ref<MemoCategory> parent;
	
	@Load
	@Index
	private Set<Ref<MemoCategory>> children;
	
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
		if(parent != null)
			return parent.get();
		return null;
	}

	public void setParent(MemoCategory parent) {
		this.parent = Ref.create(parent);
	}

	public Set<MemoCategory> getChildren() {
		if(children == null) return null;
		Set<MemoCategory> temp = new HashSet<MemoCategory>();
		for(Ref<MemoCategory> child : this.children) {
			temp.add(child.get());
		}
		return temp;
	}

	public void setChildren(List<MemoCategory> children) {
		if(this.children == null) this.children = new HashSet<Ref<MemoCategory>>();
		for(MemoCategory child : children) {
			this.children.add(Ref.create(child));
		}
	}
	
}