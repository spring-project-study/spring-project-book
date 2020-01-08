package org.ggyool.service;

import org.ggyool.domain.MemberVO;
import org.ggyool.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public MemberVO get(String userid) {
		return mapper.read(userid);
	}

	@Override
	public boolean remove(String userid) {
		return mapper.delete(userid) > 0 ? true : false;
	}

	@Override
	public boolean modify(MemberVO vo) {
		return mapper.update(vo) > 0 ? true : false;
	}

	@Override
	public boolean register(MemberVO vo) {
		return mapper.insert(vo) > 0 ? true : false;
	}
	
}
