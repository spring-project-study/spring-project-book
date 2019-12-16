package org.zerock.domain;

import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.Date;

@Data
public class ReplyVO {

    private Long rno;
    private Long bno;

    private String reply;
    private String replyer;
    private Date replyDate;
    private Date updateDate;
}
