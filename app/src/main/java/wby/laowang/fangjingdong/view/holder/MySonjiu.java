package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class MySonjiu extends RecyclerView.ViewHolder {

    @BindView(R.id.jiu_img)
    public ImageView jiuImg;
    @BindView(R.id.jiu_tev)
    public TextView jiuTev;

    public MySonjiu(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
