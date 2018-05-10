package per.agreysky.sharedpreferences;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
/*
 * 每个列表项都对应于一个Intent
 * 使用launcherActivity实现一个列表，根据Intent启动不同Activity
 * */
//列表，根据不同列表项指定的参数跳转对应的类
public class MainActivity extends LauncherActivity {
    //1.定义Activity的名称
    String[] names={"设置程序参数"};
    //2.定义Activity对应的实现类,用于显示一个显示设置选项参数并进行保存的窗口
    //指定标签对应跳转的类
    //负责加载选项设置的布局文件
    Class<?>[] classes={PreferenceActivityTest.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3.装配ArrayAdapter适配器，将数据装配到对应的列表项视图中
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1 , names);
        //4.设置该窗口显示的列表所需的adapter
        setListAdapter(adapter);
    }
    //5.重写Intent IntentForPosition(int position)方法：根据列表项返回的intent,用于启动不同的Activity
    public Intent intentForPosition(int position){
        return new Intent(MainActivity.this,classes[position]);    //返回一个Intent对象，已指明将要启动的类，其中 position的值在当用户点击Activity中列表项被确定
    }
}
