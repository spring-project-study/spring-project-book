package org.zerock.domain;

public class BoardBuilder {
    private Long bno;
    private String title;
    private String content;

    public BoardBuilder() {
    }

    public static class Builder  {

        private  Long bno;
        private  String title;
        private  String content;

        public Builder() {
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder(Long bno, String title, String content) {
            this.bno = bno;
            this.title = title;
            this.content = content;
        }

        public BoardBuilder boardBuild(){
            return new BoardBuilder();
        }


    }
    private BoardBuilder(Builder builder) {
        this.bno = builder.bno;
        this.title = builder.title;
        this.content = this.content;
    }
}
