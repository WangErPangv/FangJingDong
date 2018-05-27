package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import wby.laowang.fangjingdong.R;
import java.util.List;

import wby.laowang.fangjingdong.bean.FenleiBean;

public class MyLeftAdapter extends BaseAdapter {

    private Context context;
    private List<FenleiBean.DataBean> flist;

    public MyLeftAdapter(Context context, List<FenleiBean.DataBean> flist) {
        this.context = context;
        this.flist = flist;
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Override
    public Object getItem(int position) {
        return flist.get(position);
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
            convertView = View.inflate(context,R.layout.left_item,null);

            viewHolder.left_text = convertView.findViewById(R.id.left_text);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.left_text.setText(flist.get(position).getName());

        return convertView;
    }

    static class ViewHolder{
        TextView left_text;
    }
}
