package com.cample.system.lib.common.base;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page {
    private int currentNumber;
    private int pageSize;
    private int totalNumber;
    private List<Object> data;


    public static Page toPage(int currentNumber,int pageSize,List<Object> data){
        Page page=new Page();
        if(data!=null){

            page.setCurrentNumber(currentNumber);
            page.setPageSize(pageSize);
            page.setTotalNumber(data.size());

            int fromIndex = currentNumber * pageSize;
            int toIndex = currentNumber * pageSize + pageSize;

            if(fromIndex > data.size()){
                page.setData(new ArrayList<>());
            } else if(toIndex >= data.size()) {
                page.setData(data.subList(fromIndex,data.size()));
            } else {
                page.setData(data.subList(fromIndex,toIndex));
            }
        }
        return page;
    }

}
