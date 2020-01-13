package org.ggyool.mapper;

import org.ggyool.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
	public void insert(MemberVO vo);
	public void authInsert(String userid);
	public void createTable(String newTableName); 
	
	public int delete(String userid);
	public int authDelete(String uerid);
	public void deleteTable(String eraseTableName);
}
