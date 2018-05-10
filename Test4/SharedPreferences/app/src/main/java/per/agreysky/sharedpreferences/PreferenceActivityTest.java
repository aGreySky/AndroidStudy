package per.agreysky.sharedpreferences;

import java.util.List;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;
/*PreferenceActivity:
 * 结合PreferenceFragment实现参数设置界面，
 * 其中，PreferenceFragment负责加载选项设置的布局文件；PreferenceActivity负责加载选项设置列表的布局文件*/
public class PreferenceActivityTest extends PreferenceActivity {
    @Override
    protected boolean isValidFragment (String fragmentName) {
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.该方法用于为该界面设置一个标题按钮
        if(hasHeaders())
        {
            Button button=new Button(this);
            button.setText("设置操作");
            //将该按钮添加到该界面上
            setListFooter(button);
        }
    }
    //2.该方法加载选项列表的页面布局文件
    @Override
    public void onBuildHeaders(List<Header> target) {
        // TODO Auto-generated method stub
        super.loadHeadersFromResource(R.xml.preference_headers,target);
    }
    //3.在PreferenceActivityTest中显示Prefs1Fragment、Prefs2Fragment两个内部类
    public static class Prefs1Fragment extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);    //加载选项设置布局文件到PreferenceFragment
        }
    }

    public static class Prefs2Fragment extends PreferenceFragment
    {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.display_prefs);  //加载选项设置布局文件到PreferenceFragment
//            //获取传入该Fragment的参数
//            String website = getArguments().getString("website");
//            Toast.makeText(getActivity(), "网站域名是："+website, Toast.LENGTH_SHORT).show();
        }
    }
}
