package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.youth.banner.Banner;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MyHomeBannerHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.bannerp)
    public Banner bannerp;
    @BindView(R.id.sao_miao)
    public LinearLayout sao_miao;
    @BindView(R.id.sou_suo)
    public LinearLayout sou_suo;
    @BindView(R.id.xiao_xi)
    public LinearLayout xiao_xi;

    public MyHomeBannerHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
