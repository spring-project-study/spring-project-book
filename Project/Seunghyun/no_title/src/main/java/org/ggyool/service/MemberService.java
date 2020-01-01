package org.ggyool.service;

import org.ggyool.domain.MemberVO;


public interface MemberService {
	public boolean register(MemberVO vo);
	public MemberVO get(String userid);
	public boolean remove(String userid);
}
