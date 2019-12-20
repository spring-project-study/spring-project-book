package org.ggyool.domain;

import java.util.Date;

import lombok.Data;


@Data
public class UserVO {
	private Long uno;
	private String userId;
	private String userPassword;
	private Date registerDate;
	private Date recentDate;
}
