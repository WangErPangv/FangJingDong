package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import java.util.List;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.ProductListBean;
import wby.laowang.fangjingdong.view.Iview.OnItemListener;
import wby.laowang.fangjingdong.view.holder.MyProductListHolder;

public class MyProductListAdapter extends RecyclerView.Adapter<MyProductListHolder> {

    private Context context;
    private List<ProductListBean.DataBean> plist;
    private OnItemListener onItemListener;

    public MyProductListAdapter(Context context, List<ProductListBean.DataBean> plist) {
        this.context = context;
        this.plist = plist;
    }

    @Override
    public MyProductListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_rec_item, parent, false);
        MyProductListHolder myProductListHolder = new MyProductListHolder(view);
        return myProductListHolder;
    }

    @Override
    public void onBindViewHolder(MyProductListHolder holder, final int position) {

        holder.productTitle.setText(plist.get(position).getTitle());

        holder.productPrice.setText("￥"+plist.get(position).getPrice());

        Glide.with(context).load(plist.get(position).getImages().split("\\|")[0]).into(holder.productImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemListener.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }
}
