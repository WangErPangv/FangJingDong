package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import java.util.List;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.SubBean;
import wby.laowang.fangjingdong.view.Iview.OnItemListener;
import wby.laowang.fangjingdong.view.holder.MyFenleiRightRecHolder;

public class MyRightRecAdapter extends RecyclerView.Adapter<MyFenleiRightRecHolder> {

    private Context context;
    private List<SubBean.DataBean.ListBean> sclist;
    private OnItemListener onItemListener;

    public MyRightRecAdapter(Context context, List<SubBean.DataBean.ListBean> sclist) {
        this.context = context;
        this.sclist = sclist;
    }

    @Override
    public MyFenleiRightRecHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.right_rec_item, parent, false);
        MyFenleiRightRecHolder myFenleiRightRecHolder = new MyFenleiRightRecHolder(view);

        return myFenleiRightRecHolder;
    }

    @Override
    public void onBindViewHolder(MyFenleiRightRecHolder holder, final int position) {

        holder.rightTev.setText(sclist.get(position).getName());
        Glide.with(context).load(sclist.get(position).getIcon()).into(holder.rightImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemListener.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sclist.size();
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }
}
