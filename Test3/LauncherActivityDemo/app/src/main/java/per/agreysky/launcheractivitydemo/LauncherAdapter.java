package per.agreysky.launcheractivitydemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24 0024.
 */

public class LauncherAdapter extends BaseAdapter {

    private Context context;
    private List<Item> data;

    public LauncherAdapter(Context context, List<Item> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.layout_item, null);
            viewHolder.item_name = convertView.findViewById(R.id.item_name);
            viewHolder.item_drawable = convertView.findViewById(R.id.item_drawable);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Item item = data.get(position);
        viewHolder.item_name.setText(item.getName());
        viewHolder.item_drawable.setImageResource(item.getDrawable());
        return convertView;
    }

    class ViewHolder {
        TextView item_name;
        ImageView item_drawable;
    }

}
