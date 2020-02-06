package org.javachip.domain;

import lombok.Getter;
import lombok.Setter;

import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;
	private int amount;
	private int startNum;
	private int endNum;
	private int allAmount;
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1, 2, 0, 0, 0);
	}
	
	public Criteria(int pageNum, int amount, int startNum, int endNum, int allAmount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.startNum = startNum;
		this.endNum = endNum;
		this.allAmount = allAmount;
	}
}




