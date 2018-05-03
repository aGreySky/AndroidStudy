package per.agreysky.launcheractivitydemo;

import android.app.LauncherActivity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends LauncherActivity {

    private List<Item> data;
    private Intent intent = new Intent();

    private String[] actions = {Intent.ACTION_CALL_BUTTON, Intent.ACTION_PICK, Intent.ACTION_VIEW};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        LauncherAdapter adapter = new LauncherAdapter(this, data);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        intent.setAction(actions[position]);
        switch (position) {
            case 1:
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                break;
            case 2:
                Uri uri = Uri.parse("https://www.baidu.com");
                intent.setData(uri);
                break;
        }
        return intent;
    }

    private void initData() {
        data = new ArrayList();
        Item item;
        item = new Item("电话", R.drawable.phone);
        data.add(item);
        item = new Item("联系人", R.drawable.contact);
        data.add(item);
        item = new Item("浏览器", R.drawable.explorer);
        data.add(item);
    }

}
