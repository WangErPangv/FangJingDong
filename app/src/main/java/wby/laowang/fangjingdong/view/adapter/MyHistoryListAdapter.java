package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import wby.laowang.fangjingdong.R;
import java.util.List;

public class MyHistoryListAdapter extends BaseAdapter {

    private Context context;
    private List<String> hlist;

    public MyHistoryListAdapter(Context context, List<String> hlist) {
        this.context = context;
        this.hlist = hlist;
    }

    @Override
    public int getCount() {
        return hlist.size();
    }

    @Override
    public Object getItem(int position) {
        return hlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context,R.layout.history_item,null);
            viewHolder.history_text = convertView.findViewById(R.id.history_text);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.history_text.setText(hlist.get(position));
        return convertView;
    }

    static class ViewHolder{
        TextView history_text;
    }
}
