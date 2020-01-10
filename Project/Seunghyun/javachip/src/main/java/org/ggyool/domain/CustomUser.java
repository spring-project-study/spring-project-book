package org.ggyool.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User{
	private static final long serialVersionUID = 1L;
	private MemberVO member;
	static private List<String> authList = new ArrayList<>(Arrays.asList("ROLE_USER"));
	
	public CustomUser(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	public CustomUser(MemberVO vo) {
		super(vo.getUser_id(), vo.getUser_pw(), authList.stream()
				.map(auth->new SimpleGrantedAuthority(auth)).collect(Collectors.toList()));
		this.member = vo;
	}
}
