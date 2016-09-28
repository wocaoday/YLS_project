package com.tosit.yls.entiy;

/**
 * Created by DELL on 2016/9/26.
 */
public class DataFile {
    private String column;//栏目
    private String content;//栏目标题

    public DataFile() {
    }

    public DataFile(String column, String content) {
        this.column = column;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}
