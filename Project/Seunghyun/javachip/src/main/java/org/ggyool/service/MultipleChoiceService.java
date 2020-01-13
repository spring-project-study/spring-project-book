package org.ggyool.service;

import java.util.ArrayList;
import java.util.List;

import org.ggyool.domain.ListMultipleChoiceVO;
import org.ggyool.domain.MultipleChoiceVO;

public interface MultipleChoiceService {
	public MultipleChoiceVO get(int choice_id);
	public boolean remove(int choice_id);
	public boolean modify(MultipleChoiceVO vo);
	public boolean register(MultipleChoiceVO vo);
	public List<MultipleChoiceVO> getListWithProblem(int problem_id);
	public ArrayList<Integer> getAnswerListWithProblem(int problem_id);
	public void registerList(ListMultipleChoiceVO list, int problem_id);
}
