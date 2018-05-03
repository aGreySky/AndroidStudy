package per.agreysky.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_list1)
    ListView main_list1;

    @BindView(R.id.main_list2)
    ListView main_list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String[] arr1 = new String[]{"孙悟空", "猪八戒", "牛魔王"};
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr1);
        main_list1.setAdapter(adapter1);
        String[] arr2 = new String[]{"Java", "Hibernate", "Spring", "struts"};
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr2);
        main_list2.setAdapter(adapter2);
    }
}
