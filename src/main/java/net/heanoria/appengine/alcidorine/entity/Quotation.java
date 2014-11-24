package net.heanoria.appengine.alcidorine.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Quotation {
	
	public static String QUOTATION_ID_FIELD = "id";
	public static String QUOTATION_QUOTE_FIELD = "quote";
	public static String QUOTATION_RANK_FIELD = "rank";

	@Id
	private Long id;
	
	@Index
	private String quote;
	
	@Index
	private Integer rank;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
}