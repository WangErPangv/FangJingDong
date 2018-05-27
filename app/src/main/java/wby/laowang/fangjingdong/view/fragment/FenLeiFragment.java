package wby.laowang.fangjingdong.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.FenleiBean;
import wby.laowang.fangjingdong.bean.SubBean;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.IFenLei;
import wby.laowang.fangjingdong.view.Iview.ISub;
import wby.laowang.fangjingdong.view.adapter.MyLeftAdapter;
import wby.laowang.fangjingdong.view.adapter.MyRightAdapter;

public class FenLeiFragment extends Fragment implements IFenLei, ISub {

    @BindView(R.id.left_fen)
    ListView leftFen;
    @BindView(R.id.right_fen)
    RecyclerView rightFen;
    Unbinder unbinder;
    private String scid;
    private List<FenleiBean.DataBean> fenlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fenlei_ment, container, false);
        ButterKnife.bind(this, view);
        unbinder = ButterKnife.bind(this, view);
        initfenlei();
        return view;
    }

    public void initfenlei() {
        PresenterFusion presenterFusion = new PresenterFusion();
        presenterFusion.showFenleiToView(new ModelFusion(presenterFusion), this);

        leftFen.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            int cid = fenlist.get(position).getCid();
            scid = String.valueOf(cid);
            initSub();
        }
    });
}

    private void initSub() {
        PresenterFusion presenterFusion = new PresenterFusion();
        presenterFusion.showSubToView(new ModelFusion(presenterFusion), this);
    }

    @Override
    public void showFenLei(final FenleiBean fenleiBean) {
        this.fenlist = fenleiBean.getData();

        MyLeftAdapter myLeftAdapter = new MyLeftAdapter(getContext(), fenlist);
        leftFen.setAdapter(myLeftAdapter);

        int cid = fenlist.get(0).getCid();
        scid = String.valueOf(cid);

        initSub();
    }

    @Override
    public void showSub(SubBean subBean) {
        rightFen.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        MyRightAdapter myRightAdapter = new MyRightAdapter(getActivity(), subBean.getData());
        rightFen.setAdapter(myRightAdapter);
    }

    @Override
    public String cid() {
        return this.scid;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
