package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.HomeBean;
import wby.laowang.fangjingdong.view.Iview.OnItemListener;
import wby.laowang.fangjingdong.view.holder.MySontui;

public class MySontuiAdapter extends RecyclerView.Adapter<MySontui> {

    private Context context;
    private HomeBean homeBean;
    private OnItemListener onItemListener;

    public MySontuiAdapter(Context context, HomeBean homeBean) {
        this.context = context;
        this.homeBean = homeBean;
    }

    @Override
    public MySontui onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.son_tui, parent, false);
        MySontui mySontui = new MySontui(view);
        return mySontui;
    }

    @Override
    public void onBindViewHolder(MySontui holder, final int position) {

       holder.tuiTitle.setText(homeBean.getTuijian().getList().get(position).getTitle());

       holder.tuiPrice.setText("￥" + String.valueOf(homeBean.getTuijian().getList().get(position).getPrice()));

       Glide.with(context).load(homeBean.getTuijian().getList().get(position).getImages().split("\\|")[0]).into(holder.tuiImg);

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onItemListener.OnItemClick(position);
           }
       });
    }

    @Override
    public int getItemCount() {
        return homeBean.getTuijian().getList().size();
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }
}
