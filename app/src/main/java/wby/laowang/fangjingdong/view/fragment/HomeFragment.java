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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.FenleiBean;
import wby.laowang.fangjingdong.bean.HomeBean;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.IFenLei;
import wby.laowang.fangjingdong.view.Iview.IHome;
import wby.laowang.fangjingdong.view.adapter.MyHomeAdapter;

public class HomeFragment extends Fragment implements IHome, IFenLei {

    @BindView(R.id.home_rec)
    RecyclerView homeRec;
    Unbinder unbinder;
    private HomeBean homeBeanp;
    private FenleiBean fenleiBeanp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_ment, container, false);
        unbinder = ButterKnife.bind(this, view);
        inithome();
        initfenlei();

        return view;
    }

    public void inithome() {
        PresenterFusion presenterFusion = new PresenterFusion();
        presenterFusion.showHomeToView(new ModelFusion(presenterFusion), this);
    }

    public void initfenlei() {
        PresenterFusion presenterFusion = new PresenterFusion();
        presenterFusion.showFenleiToView(new ModelFusion(presenterFusion), this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showFenLei(FenleiBean fenleiBean) {
        this.fenleiBeanp = fenleiBean;
    }

    @Override
    public void showHome(HomeBean homeBean) {
        this.homeBeanp = homeBean;
        homeRec.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        MyHomeAdapter myHomeAdapter = new MyHomeAdapter(getActivity(), homeBean, fenleiBeanp);
        homeRec.setAdapter(myHomeAdapter);
        //recyclerView滑动卡顿解决方案，利用RecyclerView内部方法
        homeRec.setHasFixedSize(true);
        homeRec.setNestedScrollingEnabled(false);
    }
}
