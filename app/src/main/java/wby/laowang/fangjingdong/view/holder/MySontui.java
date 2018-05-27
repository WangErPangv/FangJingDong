package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MySontui extends RecyclerView.ViewHolder {

    @BindView(R.id.tui_img)
    public ImageView tuiImg;
    @BindView(R.id.tui_title)
    public TextView tuiTitle;
    @BindView(R.id.tui_price)
    public TextView tuiPrice;

    public MySontui(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
