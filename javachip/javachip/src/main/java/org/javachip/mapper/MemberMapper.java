package org.javachip.mapper;

import java.util.List;

import org.javachip.domain.MemberVO;

public interface MemberMapper {
	public MemberVO get(String userid);
	public int insert(MemberVO vo);
	public int update(MemberVO vo); 
	public int delete(String userid);
	public List<MemberVO>getList() ;
}
