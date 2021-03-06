package com.demo.utils;

import lombok.Data;

@Data
public class BasicResult {

    private String code = CodeEnum.SUCCESS.getCode();

    private String msg;

    /**
     * 创建通用成功返回结果
     * @return 通用操作结果实例
     */
    public static BasicResult newSuccessBasicResult(){
        BasicResult basicResult = new BasicResult();
        basicResult.setCode(CodeEnum.SUCCESS.getCode());
        basicResult.setMsg(CodeEnum.SUCCESS.getMessage());
        return basicResult;
    }

    /**
     * 创建通用成功返回结果
     * @return 通用操作结果实例
     */
    public static BasicResult newSuccessBasicResult(String msg){
        BasicResult basicResult = new BasicResult();
        basicResult.setCode(CodeEnum.SUCCESS.getCode());
        basicResult.setMsg(msg);
        return basicResult;
    }

    /**
     * 创建通用失败返回结果
     * @return 通用操作结果实例
     */
    public static BasicResult newFailBasicResult(){
        BasicResult basicResult = new BasicResult();
        basicResult.setCode(CodeEnum.FAILED.getCode());
        basicResult.setMsg(CodeEnum.FAILED.getMessage());
        return basicResult;
    }

    /**
     * 创建通用失败返回结果
     * @return 通用操作结果实例
     */
    public static BasicResult newFailBasicResult(String msg){
        BasicResult basicResult = new BasicResult();
        basicResult.setCode(CodeEnum.FAILED.getCode());
        basicResult.setMsg(msg);
        return basicResult;
    }

    /**
     * 操作是否成功
     * @return true-成功 false-失败
     */
    public static boolean isSuccess(BasicResult result){
        return result != null && CodeEnum.SUCCESS.getCode().equals(result.getCode());
    }

    @Override
    public String toString() {
        return "BasicResult{" +
                "code='" + getCode() + '\'' +
                ", msg='" + getMsg() + '\'' +
                '}';
    }

}
