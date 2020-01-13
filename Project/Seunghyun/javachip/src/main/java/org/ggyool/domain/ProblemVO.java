package org.ggyool.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ProblemVO {
	private int problem_id;
	private String user_id;
	private String user_name;
	private String problem_title;
	private String problem_content;
	private char problem_type;
	private Date reg_date;
	private Date update_date;
}
