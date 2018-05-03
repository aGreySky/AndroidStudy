package per.agreysky.launcheractivitydemo;

/**
 * Created by Administrator on 2018/4/24 0024.
 */

public class Item {

    private String name;
    private int drawable;

    public Item(String name, int drawable) {
        this.name = name;
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", drawable=" + drawable +
                '}';
    }

}
