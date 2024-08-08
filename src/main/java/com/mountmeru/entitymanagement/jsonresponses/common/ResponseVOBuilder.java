package com.mountmeru.entitymanagement.jsonresponses.common;

public class ResponseVOBuilder<T> {

    private static final String SUCCESS_CODE = "200";
    private static final String FAILED_CODE = "500";

    private final ResponseVO<T> responseVO = new ResponseVO<>();
    private ResponseVOBuilder<T> result(String result) {
        responseVO.setResult(result);
        return this;
    }
    private ResponseVOBuilder<T> status(String status) {
        responseVO.setStatus(status);
        return this;
    }
    public ResponseVOBuilder<T> success() {
        return new ResponseVOBuilder<T>().result("Succeed").status(SUCCESS_CODE);
    }
    public ResponseVOBuilder<T> fail() {
        return new ResponseVOBuilder<T>().result("Failed").status(FAILED_CODE);
    }
    public ResponseVOBuilder<T> error(ResponseErrorVo error) {
        responseVO.setError(error);
        responseVO.setResult("Failed");
        responseVO.setStatus(FAILED_CODE);
        return this;
    }
    public ResponseVOBuilder<T> error(ResponseErrorVo error, String status, String result) {
        responseVO.setError(error);
        responseVO.setStatus(status);
        responseVO.setResult(result);
        return this;
    }
    public ResponseVOBuilder<T> addData(final T body) {
        responseVO.setData(body);
        responseVO.setResult("Succeeded");
        responseVO.setStatus(SUCCESS_CODE);
        return this;
    }

    public ResponseVOBuilder<T> addData(final T body, String status, String result) {
        responseVO.setData(body);
        responseVO.setStatus(status);
        responseVO.setResult(result);
        return this;
    }
    public ResponseVO<T> build() {
        return responseVO;
    }
}
