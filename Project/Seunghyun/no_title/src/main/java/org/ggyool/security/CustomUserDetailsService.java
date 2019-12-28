package org.ggyool.security;


import org.ggyool.domain.CustomUser;
import org.ggyool.domain.UserVO;
import org.ggyool.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.warn(userName);
		
		UserVO vo = userMapper.read(1L);
		
		log.warn("queried by member mapper: " + vo);
		return vo == null?null:new CustomUser(vo);
	}
	
}
