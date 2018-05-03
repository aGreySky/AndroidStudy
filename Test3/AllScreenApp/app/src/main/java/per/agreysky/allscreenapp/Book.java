package per.agreysky.allscreenapp;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public class Book implements Serializable{

    private String title;
    private String desc;

    public Book(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

}
