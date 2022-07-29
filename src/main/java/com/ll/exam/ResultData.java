package com.ll.exam;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultData<T> {
    //        Map<String, Object> resultData = Ut.mapOf("resultCode", "S-1", "msg", "성공", "Data", articleDtoList);
    private String resultCode;
    private String msg;
    private T Data;
}
