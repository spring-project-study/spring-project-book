package org.ggyool.service;

import java.util.HashMap;
import java.util.Map;

import org.ggyool.domain.AuthVO;
import org.ggyool.domain.MemberVO;
import org.ggyool.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;


@Service
@Log4j
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public MemberVO get(String userid) {
		return mapper.read(userid);
	}
	
	@Override
	public boolean register(MemberVO vo) {
		String s = vo.getUserid();
		if(get(s) != null || s == "auth") 
		{
			return false;
		}
		mapper.insert(vo);
		mapper.authInsert(s);
		mapper.createTable("tbl_member_" + vo.getUserid());
		return true;
	}

	@Override public boolean remove(String userid) {
		if(mapper.authDelete(userid) == 0) return false;
		if(mapper.delete(userid) == 0) return false;
		mapper.deleteTable("tbl_member_" + userid);
		return true;
	}
	
}
