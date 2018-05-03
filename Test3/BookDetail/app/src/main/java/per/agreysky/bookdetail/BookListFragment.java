package per.agreysky.bookdetail;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookListFragment extends ListFragment {

    private List<Book> items;
    private List<String> titles;

    private CallBack mCallBack;

    private ArrayAdapter adapter;

    public BookListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items = new ArrayList<>();
        titles = new ArrayList();
        items = MyApplication.getDao().loadAll();
        for (int i = 0; i < items.size(); i++) {
            titles.add(items.get(i).title);
        }
        //设置适配器
        adapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1,
                titles);
        setListAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        items = MyApplication.getDao().loadAll();
        titles.clear();
        for (int i = 0; i < items.size(); i++) {
            titles.add(items.get(i).title);
        }
        //刷新视图
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallBack.onItemSelected(position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof CallBack)) {
            throw new IllegalStateException("Activity必须实现CallBack接口");
        }
        mCallBack = (CallBack) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack = null;
    }

    public interface CallBack {
        void onItemSelected(Integer id);
    }

}
