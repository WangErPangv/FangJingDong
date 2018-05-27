package wby.laowang.fangjingdong.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.bean.ShoppCartBean;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.IShoppCart;
import wby.laowang.fangjingdong.view.adapter.MyExpanAdapter;


public class ShoppCartFragment extends Fragment implements IShoppCart {

    @BindView(R.id.expan_able)
    ExpandableListView expanAble;
    @BindView(R.id.quan_cbox)
    CheckBox quanCbox;
    @BindView(R.id.total)
    TextView total;
    Unbinder unbinder;
    private MyExpanAdapter myExpanAdapter;
    private ShoppCartBean shopplist;
    private String suid = "10756";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shoppcart_ment, container, false);
        ButterKnife.bind(this,view);
        initdatas();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void initdatas(){
       PresenterFusion presenterFusion = new PresenterFusion();
       presenterFusion.showShoppCartToView(new ModelFusion(presenterFusion),this);

        quanCbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean quan_checked = quanCbox.isChecked();
                List<ShoppCartBean.DataBean> data = shopplist.getData();

                for (int i = 0; i < data.size() ; i++){
                    data.get(i).setParent_flag(quan_checked);

                    List<ShoppCartBean.DataBean.ListBean> list = data.get(i).getList();
                    for (int j = 0; j < list.size(); j++) {
                        list.get(j).setChild_flag(quan_checked);
                    }
                }
                myExpanAdapter.notifyDataSetChanged();

                double sum = 0;

                for (int p = 0; p < data.size(); p++) {

                    List<ShoppCartBean.DataBean.ListBean> plist = shopplist.getData().get(p).getList();

                    for (int o = 0; o < plist.size(); o++) {

                        boolean child_flag = plist.get(o).isChild_flag();
                        if (child_flag) {
                            double price = plist.get(o).getPrice()*plist.get(o).getNum();
                            sum += price;
                        }

                    }
                }

                total.setText("合计:"+sum);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showShoppCart(ShoppCartBean shoppCartBean) {
        this.shopplist = shoppCartBean;

        myExpanAdapter = new MyExpanAdapter(getContext(),shoppCartBean.getData());
        expanAble.setAdapter(myExpanAdapter);

        int count = expanAble.getCount();
        for (int i = 0; i < count; i++) {
            expanAble.expandGroup(i);
        }
    }

    @Override
    public String uid() {
        return suid;
    }
}
