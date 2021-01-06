package com.yuntu.demo.pojo;

import java.util.List;


public class PageUtil<T> {
    //5������
    private int pageindex = 1;//��ǰҳ
    private int pagesize = 10;//ҳ���С��ÿҳ������
    private int counts = 0;//�ܼ�¼����������
    private int pagecount = 0;//��ҳ��
    private List<T> lists;//ÿҳ����ļ���

    //get��set
    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getCounts() {
        return counts;
    }

    //��ȥ�����������ǣ�һ������ҳ��Ҳ������
    public void setCounts(int counts) {
        this.counts = counts;
        if (counts > 0) {//ȷ��������
            if (counts % pagesize == 0) {//�ж��Ƿ�����
                pagecount = counts / pagesize;//��ҳ��=����/ҳ��С
            } else {
                pagecount = (counts / pagesize) + 1;//��ҳ��=����/ҳ��С+1
            }
        }
    }


    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }


}
