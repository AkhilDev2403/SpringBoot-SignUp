package com.mobileapp.Firstdemoproject.model.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class AbstractResponse<T> extends ArrayList<T> {

    protected boolean success = true;
    protected String message = "";

    protected int offset = 0;
    protected long size = 0l;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }




}
