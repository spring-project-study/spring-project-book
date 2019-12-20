package org.ggyool.service;

import org.ggyool.domain.UserVO;

public interface UserService {
	public boolean register(UserVO vo);
	public UserVO get(Long uno);
	public boolean remove(Long uno);
	public boolean modify(UserVO vo);
}
