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
import wby.laowang.fangjingdong.view.holder.MySonmiao;

public class MySonmiaoAdapter extends RecyclerView.Adapter<MySonmiao> {


    private Context context;
    private HomeBean homeBean;
    private OnItemListener onItemListener;

    public MySonmiaoAdapter(Context context, HomeBean homeBean) {
        this.context = context;
        this.homeBean = homeBean;
    }

    @Override
    public MySonmiao onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.son_miao, parent, false);
        MySonmiao mySonmiao = new MySonmiao(view);
        return mySonmiao;
    }

    @Override
    public void onBindViewHolder(MySonmiao holder, final int position) {

        holder.miaoTev.setText(homeBean.getMiaosha().getList().get(position).getTitle());

        Glide.with(context).load(homeBean.getMiaosha().getList().get(position).getImages().split("\\|")[0]).into(holder.miaoImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemListener.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeBean.getMiaosha().getList().size();
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }
}
