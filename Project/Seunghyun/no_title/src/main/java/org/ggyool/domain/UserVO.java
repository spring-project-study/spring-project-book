package org.ggyool.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class UserVO{
	private Long uno;
	private String userId;
	private String userPassword;
	private Date registerDate;
	private Date recentDate;
	private List<AuthVO> authList;
}
