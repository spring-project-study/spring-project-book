package org.ggyool.service;

import org.ggyool.domain.UserVO;
import org.ggyool.mapper.UserMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;



public class UserServiceImpl implements UserService{
	
	private UserMapper mapper;
	
	boolean isExist(Long uno) {
		return get(uno)==null ? false : true;
	}
	
	@Override
	public boolean register(UserVO vo) {
		mapper.insert(vo);
		if(vo.getUno() != null)
		{
			mapper.createTable("user_tbl_" + vo.getUno().toString());
			return true;
		}
		return false;
	}

	@Override
	public UserVO get(Long uno) {
		return mapper.read(uno);
	}
	
	@Override
	public boolean remove(Long uno) {
		if(mapper.delete(uno) > 0)
		{
			mapper.deleteTable("user_tbl_" + uno.toString());
			return true;
		}		
		return false;
	}

	@Override
	public boolean modify(UserVO vo) {
		return mapper.update(vo) > 0 ? true : false;
	}
	
	
}
