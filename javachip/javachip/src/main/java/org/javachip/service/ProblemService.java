package org.javachip.service;

import java.util.List;

import org.javachip.domain.Criteria;
import org.javachip.domain.ProblemVO;

public interface ProblemService {

	public List<ProblemVO> getListWithPaging(Criteria cri);
	
	public int getTotal(Criteria cri);

}
