package com.mao.smr.result;

/**
 * when the front end process data and send the result code to the backend
 * or the backend get the data and send the code
 * it actually sends the result object with the code
 * sometimes may have message showing in the pages
 */
public class Result {

    private int code;
    private String message;
    private Object result;

    public Result(int code) {
        this.code = code;
    }
    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}



