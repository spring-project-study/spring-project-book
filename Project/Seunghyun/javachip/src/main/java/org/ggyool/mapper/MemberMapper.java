package org.ggyool.mapper;

import org.ggyool.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
	public int insert(MemberVO vo);
	public int update(MemberVO vo); 
	public int delete(String userid);
}
