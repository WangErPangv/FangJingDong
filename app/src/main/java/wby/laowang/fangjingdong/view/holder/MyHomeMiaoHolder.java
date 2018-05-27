package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.sunfusheng.marqueeview.MarqueeView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MyHomeMiaoHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.marqueeView)
    public MarqueeView marqueeView;
    @BindView(R.id.home_miao)
    public RecyclerView homeMiao;

    public MyHomeMiaoHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
