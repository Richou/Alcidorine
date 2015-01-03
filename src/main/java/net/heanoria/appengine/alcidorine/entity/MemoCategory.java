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
	public static final String MEMOCAT_TOP_PARENT_FIELD = "topParent";
	public static final String MEMOCAT_CHILDREN_FIELD ="children";
	
	/* Fields */
	
	@Id private Long id;
	
	@Index private String title;
	@Index private String description;
	@Index private boolean topParent;
	
	/* RelationShips */
	
	@Load
	@Index
	private Set<Ref<MemoCategory>> children;
	
	@Load
	@Index
	private Set<Ref<Memo>> memories;
	
	/* Getters & Setters */

	public Long getId() {
		return id;
	}

	public MemoCategory setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public MemoCategory setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public MemoCategory setDescription(String description) {
		this.description = description;
		return this;
	}
	
	public boolean isTopParent() {
		return topParent;
	}

	public MemoCategory setTopParent(boolean topParent) {
		this.topParent = topParent;
		return this;
	}

	public Set<MemoCategory> getChildren() {
		if(children == null) {
			return null;
		}
		
		Set<MemoCategory> temp = new HashSet<MemoCategory>();
		for(Ref<MemoCategory> child : this.children) {
			temp.add(child.get());
		}
		return temp;
	}

	public MemoCategory setChildren(List<MemoCategory> children) {
		if(this.children == null) {
			this.children = new HashSet<Ref<MemoCategory>>();
		}
		
		for(MemoCategory child : children) {
			this.children.add(Ref.create(child));
		}
		return this;
	}

	public Set<Memo> getMemories() {
		if(this.memories == null) {
			return null;
		}
		
		Set<Memo> temp = new HashSet<Memo>();
		for(Ref<Memo> memo : this.memories) {
			temp.add(memo.get());
		}
		return temp;
	}

	public MemoCategory setMemories(Set<Memo> memories) {
		if(this.memories == null) {
			this.memories = new HashSet<Ref<Memo>>();
		}
		
		for(Memo memo : memories) {
			this.memories.add(Ref.create(memo));
		}
		return this;
	}
	
}