package per.agreysky.bookdetail;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BookDetailFragment extends Fragment {

    public static final String ITEM_ID = "item_id";

    @BindView(R.id.bd_tv_title)
    TextView title;

    @BindView(R.id.bd_tv_desc)
    TextView desc;

    Book book;

    public BookDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ITEM_ID)) {
            //查询所有数据
            List<Book> items = MyApplication.getDao().loadAll();
            book = items.get(getArguments().getInt(ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_detail, container, false);
        ButterKnife.bind(this, root);
        if (null != book) {
            title.setText(book.title);
            desc.setText(book.desc);
        }
        return root;
    }

}
