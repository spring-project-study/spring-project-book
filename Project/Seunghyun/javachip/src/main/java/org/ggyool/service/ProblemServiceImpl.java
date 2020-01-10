package org.ggyool.service;

import java.util.List;

import org.ggyool.domain.ProblemVO;
import org.ggyool.mapper.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService{
	
	@Autowired
	private ProblemMapper mapper;
	
	@Override
	public ProblemVO get(int problem_id) {
		return mapper.read(problem_id);
	}

	@Override
	public boolean remove(int problem_id) {
		return mapper.delete(problem_id)>0 ? true : false;
	}

	@Override
	public boolean modify(ProblemVO vo) {
		return mapper.update(vo)>0 ? true : false;
	}

	@Override
	public boolean register(ProblemVO vo) {
		return mapper.insert(vo) > 0 ? true : false;
	}

	@Override
	public List<ProblemVO> getList() {
		return mapper.getListAll();
	}

}
