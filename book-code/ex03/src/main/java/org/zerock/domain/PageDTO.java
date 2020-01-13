package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

    private int startPage;
    private int endPage;
    private boolean prev, next;

    private int total;
    private Criteria cri;

    public PageDTO(int total, Criteria cri) {
        this.total = total;
        this.cri = cri;

        this.endPage = (int) Math.ceil(cri.getPageNum() / 10.0) * 10;
        this.startPage = endPage - (cri.getAmount() - 1);

        int realEnd = (int) Math.ceil((total * 1.0 / cri.getAmount()));

        if (realEnd < this.endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
