package wby.laowang.fangjingdong.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import wby.laowang.fangjingdong.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


public class MyFindVideoHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.jcv_video)
    public JCVideoPlayerStandard jcvVideo;

    public MyFindVideoHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
