package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.SubBean;
import wby.laowang.fangjingdong.view.Iview.OnItemListener;
import wby.laowang.fangjingdong.view.activity.ProductListActivity;
import wby.laowang.fangjingdong.view.holder.MyFenleiRightHolder;

public class MyRightAdapter extends RecyclerView.Adapter<MyFenleiRightHolder> {

    private Context context;
    private List<SubBean.DataBean> slist;

    public MyRightAdapter(Context context, List<SubBean.DataBean> slist) {
        this.context = context;
        this.slist = slist;
    }

    @Override
    public MyFenleiRightHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.right_item, parent, false);
        MyFenleiRightHolder myFenleiRightHolder = new MyFenleiRightHolder(view);
        return myFenleiRightHolder;
    }

    @Override
    public void onBindViewHolder(MyFenleiRightHolder holder, int position) {

        holder.rightText.setText(slist.get(position).getName());

        holder.rightRec.setLayoutManager(new GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false));
        MyRightRecAdapter myRightRecAdapter = new MyRightRecAdapter(context,slist.get(position).getList());
        holder.rightRec.setAdapter(myRightRecAdapter);

        myRightRecAdapter.setOnItemListener(new OnItemListener() {
            @Override
            public void OnItemClick(int position) {

                Intent intent = new Intent(context,ProductListActivity.class);
                String name = slist.get(position).getList().get(position).getName();
                intent.putExtra("keywords",name);
                Log.d("keypppp",name);
                context.startActivity(intent);
            }

            @Override
            public void OnItemLongClick(int position) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return slist.size();
    }
}
