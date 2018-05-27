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
import wby.laowang.fangjingdong.view.holder.MyProductListGridHolder;

public class MyProductListGridAdapter extends RecyclerView.Adapter<MyProductListGridHolder> {

    private Context context;
    private List<ProductListBean.DataBean> pglist;
    private OnItemListener onItemListener;

    public MyProductListGridAdapter(Context context, List<ProductListBean.DataBean> pglist) {
        this.context = context;
        this.pglist = pglist;
    }

    @Override
    public MyProductListGridHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.product_rec_grid_item, parent, false);
        MyProductListGridHolder myProductListGridHolder = new MyProductListGridHolder(view);
        return myProductListGridHolder;
    }

    @Override
    public void onBindViewHolder(MyProductListGridHolder holder, int position) {


        holder.productGridTitle.setText(pglist.get(position).getTitle());

        holder.productGridPrice.setText("￥" + pglist.get(position).getPrice());

        Glide.with(context).load(pglist.get(position).getImages().split("\\|")[0]).into(holder.productGridImg);

    }

    @Override
    public int getItemCount() {
        return pglist.size();
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }
}
