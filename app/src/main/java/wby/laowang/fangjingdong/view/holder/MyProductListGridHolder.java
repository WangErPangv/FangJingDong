package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MyProductListGridHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.product_grid_img)
    public ImageView productGridImg;
    @BindView(R.id.product_grid_title)
    public TextView productGridTitle;
    @BindView(R.id.product_grid_price)
    public TextView productGridPrice;

    public MyProductListGridHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
