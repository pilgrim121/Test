package com.example.demo.Apipo;

import java.util.List;

public class Apilist {
    String currPage;
    String pageSize;
    String totalCount;
    String totalPage;
    List<Data> datas;

    public Apilist() {
    }

    public String getCurrPage() {
        return currPage;
    }

    public void setCurrPage(String currPage) {
        this.currPage = currPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Apilist{" +
                "currPage='" + currPage + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", totalCount='" + totalCount + '\'' +
                ", totalPage='" + totalPage + '\'' +
                ", datas=" + datas +
                '}';
    }

    class Data{
        String name;
        String type;

        public Data() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

}
