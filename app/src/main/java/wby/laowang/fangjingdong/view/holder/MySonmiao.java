package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MySonmiao extends RecyclerView.ViewHolder {

    @BindView(R.id.miao_tev)
    public TextView miaoTev;
    @BindView(R.id.miao_img)
    public ImageView miaoImg;

    public MySonmiao(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
