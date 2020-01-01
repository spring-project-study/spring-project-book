package org.ggyool.mapper;

import org.ggyool.domain.UserVO;

public interface UserMapper {
	public void insert(UserVO vo);
	public void createTable(String newTableName); 
	public UserVO read(Long uno);
	public int delete(Long uno);
	public int update(UserVO vo);
	public int deleteTable(String deleteTableName);
}
