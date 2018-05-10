package per.agreysky.sharedpreferences;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import per.agreysky.sharedpreferences.preferencesmanager.PreferencesManager;


public class SharedPreferenceTest extends AppCompatActivity {


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //初始化preferences manager
        new PreferencesManager(this)
                .setName("prefs")
                .init();

        Button intButton = (Button) findViewById(R.id.int_button);
        intButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //PreferencesManager为操作SharedPreferences的工具类，里面封装了所有对应的方法
                PreferencesManager.putInt("age", (int) 21);
                makeToast("存入的年龄为："+String.valueOf(PreferencesManager.getInt("age")));
            }
        });

        Button objectButton = (Button) findViewById(R.id.object_button);
        objectButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //它能帮我们存入Object对象，以Json格式存入
                PreferencesManager.putObject("person", new Person("周志强",21));
                Person person = PreferencesManager.getObject("person", Person.class);
                makeToast("存入的Person属性：\n" +"name:"+ person.name + ",年龄：" + person.age);
            }
        });
    }

    private void makeToast(String str) {
        Toast.makeText(SharedPreferenceTest.this, str, Toast.LENGTH_SHORT).show();
    }

    class Person {

        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

}
