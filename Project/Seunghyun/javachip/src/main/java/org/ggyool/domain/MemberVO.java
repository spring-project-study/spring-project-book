package org.ggyool.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private Date reg_date; // 啊涝老
	private Date recent_login_date; // 弥辟 立加老
	private List<AuthVO> authList;
}
