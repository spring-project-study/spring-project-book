package org.javachip.mapper;

import java.util.List;

import org.javachip.domain.ProblemVO;

public interface ProblemMapper {
	public ProblemVO get(long problem_id);
	public int insert(ProblemVO vo);
	public int update(ProblemVO vo); 
	public int delete(long problem_id);
	public List<ProblemVO> getList() ;
}
