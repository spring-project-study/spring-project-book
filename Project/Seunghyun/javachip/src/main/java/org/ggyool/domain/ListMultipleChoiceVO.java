package org.ggyool.domain;

import java.util.List;

import lombok.Data;

@Data
public class ListMultipleChoiceVO {
	List<MultipleChoiceVO> choice_list;
}
