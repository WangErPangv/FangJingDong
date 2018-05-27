package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MyFenleiRightHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.right_text)
    public TextView rightText;
    @BindView(R.id.right_rec)
    public RecyclerView rightRec;

    public MyFenleiRightHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
