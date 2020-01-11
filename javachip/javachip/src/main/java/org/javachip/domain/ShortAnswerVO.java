package org.javachip.domain;

import lombok.Data;

@Data
public class ShortAnswerVO {
	private long answer_id;
	private long problem_id;
	private String answer_content;
}
