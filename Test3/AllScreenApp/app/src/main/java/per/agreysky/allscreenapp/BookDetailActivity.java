package per.agreysky.allscreenapp;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailActivity extends AutoLayoutActivity {

    @BindView(R.id.detail_tb)
    Toolbar detail_tb;

    @BindView(R.id.detail_tv_title)
    TextView detail_tv_title;

    @BindView(R.id.detail_tv_desc)
    TextView detail_tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        ButterKnife.bind(this);
        Book book = (Book) getIntent().getSerializableExtra("book");
        detail_tb.setNavigationIcon(R.drawable.back_white);
        detail_tb.setTitle("");
        setSupportActionBar(detail_tb);
        detail_tv_title.setText(book.getTitle());
        detail_tv_desc.setText(book.getDesc());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
