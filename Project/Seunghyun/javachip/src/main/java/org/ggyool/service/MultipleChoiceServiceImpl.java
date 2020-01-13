package org.ggyool.service;

import java.util.ArrayList;
import java.util.List;

import org.ggyool.domain.ListMultipleChoiceVO;
import org.ggyool.domain.MultipleChoiceVO;
import org.ggyool.mapper.MultipleChoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultipleChoiceServiceImpl implements MultipleChoiceService{

	@Autowired
	MultipleChoiceMapper mapper;
	
	@Override
	public MultipleChoiceVO get(int choice_id) {
		return mapper.read(choice_id);
	}

	@Override
	public boolean remove(int choice_id) {

		return mapper.delete(choice_id) > 0 ? true: false;
	}

	@Override
	public boolean modify(MultipleChoiceVO vo) {
		return mapper.update(vo) > 0 ? true: false;
	}

	@Override
	public boolean register(MultipleChoiceVO vo) {
		return mapper.insert(vo) > 0 ? true: false;
	}
	
	@Override
	public void registerList(ListMultipleChoiceVO listVO, int problem_id) {
		List<MultipleChoiceVO> list = listVO.getChoice_list();
		for(MultipleChoiceVO vo : list) {
			if(vo.getChoice_content() != null) {
				String content = vo.getChoice_content().trim();
				if(content.length() == 0) continue;
				vo.setChoice_content(content);
				vo.setProblem_id(problem_id);
				mapper.insert(vo);
			}
		}
	}
	
	@Override
	public List<MultipleChoiceVO> getListWithProblem(int problem_id) {
		return mapper.getListWithProblem(problem_id);
	}
	
	@Override
	public ArrayList<Integer> getAnswerListWithProblem(int problem_id) {
		return mapper.getAnswerListWithProblem(problem_id);
	}
}
