package org.ggyool.mapper;

import java.util.ArrayList;
import java.util.List;

import org.ggyool.domain.MultipleChoiceVO;

public interface MultipleChoiceMapper {
	public MultipleChoiceVO read(int choice_id);
	public int insert(MultipleChoiceVO vo);
	public int update(MultipleChoiceVO vo); 
	public int delete(int choice_id);
	public List<MultipleChoiceVO> getListWithProblem(int problem_id);
	public ArrayList<Integer> getAnswerListWithProblem(int problem_id);
}
