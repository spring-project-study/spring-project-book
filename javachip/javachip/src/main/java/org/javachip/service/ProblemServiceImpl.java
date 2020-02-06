package org.javachip.service;

import java.util.List;

import org.javachip.domain.Criteria;
import org.javachip.domain.ProblemVO;
import org.javachip.mapper.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ProblemServiceImpl implements ProblemService{
	
	@Setter(onMethod_ = @Autowired)
	private ProblemMapper mapper;

	@Override
	public List<ProblemVO> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		cri.setStartNum((cri.getPageNum() - 1) * cri.getAmount());
		cri.setEndNum(cri.getStartNum() + cri.getAmount() - 1);
		System.out.println("77777" + mapper.getListWithPaging(cri));
		
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

}
