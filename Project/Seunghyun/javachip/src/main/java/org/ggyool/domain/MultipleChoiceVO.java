package org.ggyool.domain;

import lombok.Data;

@Data
public class MultipleChoiceVO {
	private int choice_id; // pk
	private int problem_id; // fk
	private boolean chk_answer;
	private String choice_content; 
}
