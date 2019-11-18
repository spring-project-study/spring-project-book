package org.zerock.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SampleDTOList {
    List<SampleDTO> list = new ArrayList<SampleDTO>();
}
