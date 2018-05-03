package per.agreysky.allscreenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AutoLayoutActivity {

    @BindView(R.id.main_lv)
    ListView main_lv;

    private List<Book> data;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        main_lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, titles));
        main_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);
                intent.putExtra("book", data.get(position));
                startActivity(intent);
            }
        });
    }

    private void initData() {
        data = new ArrayList<>();
        titles = new ArrayList<>();
        data.add(new Book("疯狂Android", "疯狂Android"));
        data.add(new Book("疯狂Java", "疯狂Java"));
        data.add(new Book("疯狂JavaEE", "疯狂JavaEE"));
        for (int i = 0; i < data.size(); i++) {
            titles.add(data.get(i).getTitle());
        }
    }

}
