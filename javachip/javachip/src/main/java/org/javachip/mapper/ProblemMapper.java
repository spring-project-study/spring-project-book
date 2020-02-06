package org.javachip.mapper;

import java.util.List;

import org.javachip.domain.Criteria;
import org.javachip.domain.ProblemVO;

public interface ProblemMapper {

	public List<ProblemVO> getList();
	
	public List<ProblemVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
