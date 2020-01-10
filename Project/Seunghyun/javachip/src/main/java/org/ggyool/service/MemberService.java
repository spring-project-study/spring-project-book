package org.ggyool.service;

import org.ggyool.domain.MemberVO;

public interface MemberService {
	public MemberVO get(String userid);
	public boolean remove(String userid);
	public boolean modify(MemberVO vo);
	public boolean register(MemberVO vo);
}
