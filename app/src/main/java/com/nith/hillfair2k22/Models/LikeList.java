package com.nith.hillfair2k22.Models;

import java.util.List;

public class LikeList {
    int count;
    String next;
    String previous;
    List<User_Serializer_For_ImageFeed> result ;

    public LikeList() {
    }

    public LikeList(int count, String next, String previous, List<User_Serializer_For_ImageFeed> result) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<User_Serializer_For_ImageFeed> getResult() {
        return result;
    }

    public void setResult(List<User_Serializer_For_ImageFeed> result) {
        this.result = result;
    }
}
