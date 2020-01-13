package org.javachip.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ProblemVO {
	private long problem_id;
	private String problem_title;
	private String problem_content;
	private Date reg_date;
	private Date update_date;
	private String user_id;
	private String user_pw;
	private boolean problem_type;
}
