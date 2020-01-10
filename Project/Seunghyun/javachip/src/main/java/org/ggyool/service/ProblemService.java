package org.ggyool.service;


import java.util.List;

import org.ggyool.domain.ProblemVO;

public interface ProblemService {
	public ProblemVO get(int problem_id);
	public boolean remove(int problem_id);
	public boolean modify(ProblemVO vo);
	public boolean register(ProblemVO vo);
	public List<ProblemVO> getList();
}
