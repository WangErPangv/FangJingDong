package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.FenleiBean;
import wby.laowang.fangjingdong.view.Iview.OnItemListener;
import wby.laowang.fangjingdong.view.holder.MySonjiu;

public class MySonjiuAdapter extends RecyclerView.Adapter<MySonjiu> {

    private Context context;
    private FenleiBean fenleiBean;
    private OnItemListener onItemListener;

    public MySonjiuAdapter(Context context, FenleiBean fenleiBean) {
        this.context = context;
        this.fenleiBean = fenleiBean;
    }

    @Override
    public MySonjiu onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.son_jiu, parent, false);
        MySonjiu mySonjiu = new MySonjiu(view);
        return mySonjiu;
    }

    @Override
    public void onBindViewHolder(MySonjiu holder, final int position) {

        holder.jiuTev.setText(fenleiBean.getData().get(position).getName());
        Glide.with(context).load(fenleiBean.getData().get(position).getIcon()).into(holder.jiuImg);

        //单击
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemListener.OnItemClick(position);
            }
        });

        //长按
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                onItemListener.OnItemLongClick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return fenleiBean.getData().size();
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }
}
