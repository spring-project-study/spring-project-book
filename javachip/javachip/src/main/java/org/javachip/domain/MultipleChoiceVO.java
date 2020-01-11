package org.javachip.domain;

import lombok.Data;

@Data
public class MultipleChoiceVO {
	private long choice_id;
	private long problem_id;
	private String choice_content;
	private boolean chk_answer;
}
