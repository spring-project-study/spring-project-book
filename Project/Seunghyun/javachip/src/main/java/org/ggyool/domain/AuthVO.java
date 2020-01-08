package org.ggyool.domain;

import lombok.Data;

@Data
public class AuthVO {
	private String user_id;
	private String auth;
	
	AuthVO(String user_id, String auth){
		this.user_id = user_id;
		this.auth = auth;
	}
}
