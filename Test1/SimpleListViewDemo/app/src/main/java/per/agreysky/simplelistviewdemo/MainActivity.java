package per.agreysky.simplelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView main_list;

    String[] names = new String[] {"鼠尾巴", "鼠屁股", "鼠头"};
    String[] descs = new String[] {"调皮", "圆润", "憨厚"};
    int[] imageIds = new int[] {R.drawable.mouse1, R.drawable.mouse2, R.drawable.mouse3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_list = (ListView) findViewById(R.id.main_list);
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("header", imageIds[i]);
            listItem.put("personName", names[i]);
            listItem.put("desc", descs[i]);
            listItems.add(listItem);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.item,
                new String[] {"personName", "header", "desc"},
                new int[]{R.id.item_tv_name, R.id.header, R.id.item_tv_desc});
        main_list.setAdapter(adapter);
    }
}
