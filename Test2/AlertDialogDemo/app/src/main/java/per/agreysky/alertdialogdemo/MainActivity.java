package per.agreysky.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView show;
    String[] items = new String[]{"Android", "Java", "Python"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //简单
    public void simple(View source){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                //设置对话框标题
        .setTitle("简单对话框")
                //设置图标
        .setIcon(R.drawable.mouse3)
                .setMessage("对话框测试内容\n第二行内容");
    /*    setPositiveButton(builder);
        builder=setNegativeButton(builder);*/

        AlertDialog simplechoicedialog=builder.create();
        simplechoicedialog.show();
    }
    //单选
    public void singleChoice(View source){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
        //设置对话框标题
        .setTitle("单选列表项对话框")
                //设置图标
        .setIcon(R.drawable.mouse3)
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        show.setText("你被选中了<"+items[i]+">");
                    }
                });
        /*setPositiveButton(builder);
        builder=setNegativeButton(builder);*/

        AlertDialog simplechoicedialog=builder.create();
        simplechoicedialog.show();
    }
    
    

    //自定义
    public void alert(View v) {
        View view = View.inflate(this, R.layout.books, null);
        new AlertDialog.Builder(this)
                .setTitle("自定义列表对话框")
                .setView(view)
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

}
