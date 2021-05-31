package com.canthny.dubbo.common.filter.test;

import java.io.Serializable;
import java.util.List;

public class ResultVo implements Serializable {

    private int total ;

    private ResultDto resultDto;

    public ResultVo(int total, ResultDto resultDto) {
        this.total = total;
        this.resultDto = resultDto;
    }
    //    private T data;
//
//    public ResultVo(int total,T data){
//        this.total = total;
//        this.data = data;
//    }
//    private List<T> data;

//    public ResultVo(int total,List<T> data){
//        this.total = total;
//        this.data = data;
//    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//    public List<T> getData() {
//        return data;
//    }
//
//    public void setData(List<T> data) {
//        this.data = data;
//    }


    public ResultDto getResultDto() {
        return resultDto;
    }

    public void setResultDto(ResultDto resultDto) {
        this.resultDto = resultDto;
    }
}
