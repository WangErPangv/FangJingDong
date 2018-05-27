package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MyHomeTuiHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.home_tui)
    public RecyclerView homeTui;

    public MyHomeTuiHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
