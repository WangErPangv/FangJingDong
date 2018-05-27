package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.ShoppCartBean;
import wby.laowang.fangjingdong.view.custom.AddSubView;


public class MyExpanAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ShoppCartBean.DataBean> slist;

    public MyExpanAdapter(Context context, List<ShoppCartBean.DataBean> slist) {
        this.context = context;
        this.slist = slist;
    }

    @Override
    public int getGroupCount() {
        return slist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return slist.get(groupPosition).getList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return slist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return slist.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final ParentViewHolder parentViewHolder;
        if (convertView == null){
            parentViewHolder = new ParentViewHolder();
            convertView = View.inflate(context, R.layout.item_parent,null);

            parentViewHolder.parent_box = convertView.findViewById(R.id.parent_box);
            parentViewHolder.parent_title = convertView.findViewById(R.id.parent_title);

            convertView.setTag(parentViewHolder);
        }else {
            parentViewHolder = (ParentViewHolder) convertView.getTag();
        }

        parentViewHolder.parent_title.setText(slist.get(groupPosition).getSellerName());
        parentViewHolder.parent_box.setChecked(slist.get(groupPosition).isParent_flag());

        parentViewHolder.parent_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ischecked = parentViewHolder.parent_box.isChecked();
                slist.get(groupPosition).setParent_flag(ischecked);

                List<ShoppCartBean.DataBean.ListBean> list = slist.get(groupPosition).getList();
                for (int i = 0; i < list.size(); i++) {
                    ShoppCartBean.DataBean.ListBean listBean = list.get(i);
                    listBean.setChild_flag(ischecked);
                }
                notifyDataSetChanged();

            }
        });
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ChildViewHolder childViewHolder;
        if (convertView == null){
            childViewHolder = new ChildViewHolder();
            convertView = View.inflate(context, R.layout.item_child,null);

            childViewHolder.child_box = convertView.findViewById(R.id.child_box);
            childViewHolder.child_delete = convertView.findViewById(R.id.child_delete);
            childViewHolder.child_img = convertView.findViewById(R.id.child_img);
            childViewHolder.child_price = convertView.findViewById(R.id.child_price);
            childViewHolder.child_title = convertView.findViewById(R.id.child_title);
            childViewHolder.addSubView = convertView.findViewById(R.id.addsub);

            convertView.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        final List<ShoppCartBean.DataBean.ListBean> list = slist.get(groupPosition).getList();
        childViewHolder.child_title.setText(list.get(childPosition).getTitle());
        childViewHolder.child_price.setText("￥: "+list.get(childPosition).getPrice());
        childViewHolder.child_box.setChecked(list.get(childPosition).isChild_flag());

        String[] imags = list.get(childPosition).getImages().split("\\|");
        Uri parse = Uri.parse(imags[0]);
        childViewHolder.child_img.setImageURI(parse);

        childViewHolder.addSubView.setCount(list.get(childPosition).getNum());
        childViewHolder.addSubView.setOnAddClick(new AddSubView.OnAddSubClick() {
            @Override
            public void onAddSubClick() {
                String count = childViewHolder.addSubView.getCount();
                list.get(childPosition).setNum(Integer.parseInt(count));
                notifyDataSetChanged();
            }
        });
        childViewHolder.child_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean child_checked = childViewHolder.child_box.isChecked();
                list.get(childPosition).setChild_flag(child_checked);

                boolean ch_flag = true;//一个开关标记
                for (int i = 0; i < list.size(); i++){
                    boolean child_flag = list.get(i).isChild_flag();
                    if (child_flag == false){
                        ch_flag = false;
                    }
                }
                slist.get(groupPosition).setParent_flag(ch_flag);

                notifyDataSetChanged();
            }
        });

        childViewHolder.child_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slist.remove(groupPosition);
                list.remove(childPosition);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class ParentViewHolder{
        CheckBox parent_box;
        TextView parent_title;
    }

    static class ChildViewHolder{
        CheckBox child_box;
        ImageView child_img;
        TextView child_title;
        TextView child_price;
        TextView child_delete;
        AddSubView addSubView;
    }

}
