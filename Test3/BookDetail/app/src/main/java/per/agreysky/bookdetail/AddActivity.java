package per.agreysky.bookdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.add_et_title)
    EditText add_et_title;

    @BindView(R.id.add_et_desc)
    EditText add_et_desc;

    @BindView(R.id.add_btn_ok)
    Button add_btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
        add_btn_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn_ok:
                String title = add_et_title.getText().toString();
                String desc = add_et_desc.getText().toString();
                //数据库插入数据
                MyApplication.getDao().insert(new Book(null, title, desc));
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
            default:
                break;
        }
    }
}
