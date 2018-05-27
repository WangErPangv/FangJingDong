package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.FindVideoBean;
import wby.laowang.fangjingdong.view.holder.MyFindVideoHolder;


public class MyFindVideoAdapter extends RecyclerView.Adapter<MyFindVideoHolder> {

    private Context context;
    private FindVideoBean findVideoBean;

    public MyFindVideoAdapter(Context context, FindVideoBean findVideoBean) {
        this.context = context;
        this.findVideoBean = findVideoBean;
    }

    @Override
    public MyFindVideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recvideo_item, parent, false);
        MyFindVideoHolder myFindVideoHolder = new MyFindVideoHolder(view);
        return myFindVideoHolder;
    }

    @Override
    public void onBindViewHolder(MyFindVideoHolder holder, int position) {

        String videouri = findVideoBean.getData().get(position).getVideouri();

        holder.jcvVideo.setUp(videouri,holder.jcvVideo.SCREEN_LAYOUT_NORMAL, findVideoBean.getData().get(position).getText());

        Glide.with(context).load(findVideoBean.getData().get(position).getBimageuri()) .into(holder.jcvVideo.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return findVideoBean.getData().size();
    }
}
