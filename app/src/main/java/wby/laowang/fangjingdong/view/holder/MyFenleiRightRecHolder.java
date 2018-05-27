package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MyFenleiRightRecHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.right_img)
    public ImageView rightImg;
    @BindView(R.id.right_tev)
    public TextView rightTev;

    public MyFenleiRightRecHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
