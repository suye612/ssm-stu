package com.ytj.ssm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 *
 * @author amin
 * @date 2018/12/4
 */
public class PageInfo<T> implements Serializable {
    private int page;
    private int pageSize;
    private int maxCount;
    private int maxPage;
    private int start;
    private Boolean isFirstPage;
    private Boolean isLastPage;
    private int nextPage;
    private int backPage;
    private List<T> list;
    private List<Integer> nums = new ArrayList<>();

    public Boolean getFirstPage() {
        if(getPage()==1){
            return true;
        }
        return false;
    }

    public void setFirstPage(Boolean firstPage) {
        isFirstPage = firstPage;
    }

    public Boolean getLastPage() {
        if(getPage()==getMaxPage()){
            return true;
        }
        return false;
    }

    public void setLastPage(Boolean lastPage) {
        isLastPage = lastPage;
    }

    public PageInfo(int maxCount, Integer page) {
        this.maxCount = maxCount;
        this.page = page;
    }

    public int getStart() {
        return (getPage() - 1)*pageSize;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getNextPage() {
        return getPage() +1;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getBackPage() {
        return getPage() -1;
    }
    public void setBackPage(int backPage) {
        this.backPage = backPage;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getMaxCount() {
        return maxCount;
    }
    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }
    public int getMaxPage() {
        return getMaxCount()%getPageSize() == 0 ? getMaxCount()/getPageSize() :getMaxCount()/getPageSize()+1;
    }
    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public List<T> getList() {

        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public List<Integer> getNums() {
        if(getMaxPage()<=5){
            for(int i=1;i<=getMaxPage();i++){
                nums.add(i);
            }
        }else {
            if(page<=3){
                for(int i = 1;i<=5 ; i++){
                    nums.add(i);
                }
            }else if (page>=getMaxPage()-2){
                for(int i=getMaxPage()-4;i<=getMaxPage();i++){
                    nums.add(i);
                }
            }else{
                for(int i=page-2;i<=page+2;i++){
                    nums.add(i);
                }
            }
        }

        return nums;
    }
    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }
    public Boolean getIsFirstPage() {
        if(getPage()==1){
            return true;
        }
        return false;
    }
    public void setIsFirstPage(Boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }
    public Boolean getIsLastPage() {
        if(getPage()==getMaxPage()){
            return true;
        }
        return false;
    }
    public void setIsLastPage(Boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

}
