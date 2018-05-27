package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MyProductListHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.product_img)
    public ImageView productImg;
    @BindView(R.id.product_title)
    public TextView productTitle;
    @BindView(R.id.product_price)
    public TextView productPrice;

    public MyProductListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
