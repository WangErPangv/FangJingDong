package wby.laowang.fangjingdong.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.HomeBean;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.IHome;
import wby.laowang.fangjingdong.view.Iview.OnItemListener;
import wby.laowang.fangjingdong.view.activity.DetailActivity;
import wby.laowang.fangjingdong.view.activity.LoginActivity;
import wby.laowang.fangjingdong.view.activity.PersonMationActivity;
import wby.laowang.fangjingdong.view.adapter.MySontuiAdapter;


public class MyFragment extends Fragment implements IHome {

    @BindView(R.id.my_user_icon)
    SimpleDraweeView myUserIcon;
    @BindView(R.id.my_user_name)
    TextView myUserName;
    @BindView(R.id.my_linear_login)
    LinearLayout myLinearLogin;
    @BindView(R.id.my_xx)
    ImageView myXx;
    @BindView(R.id.login_pic)
    RelativeLayout loginPic;
    @BindView(R.id.myfx)
    ImageView myfx;
    @BindView(R.id.mysh)
    ImageView mysh;
    @BindView(R.id.mypj)
    ImageView mypj;
    @BindView(R.id.myth)
    ImageView myth;
    @BindView(R.id.tui_jian_recycler)
    RecyclerView tuiJianRecycler;
    private SharedPreferences preferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_ment, container, false);
        ButterKnife.bind(this,view);

        initData();

        return view;
    }

    public void initData(){

        PresenterFusion presenterFusion = new PresenterFusion();
        presenterFusion.showHomeToView(new ModelFusion(presenterFusion),this);
    }

    @Override
    public void showHome(final HomeBean homeBean) {

        tuiJianRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false));
        MySontuiAdapter mySontuiAdapter = new MySontuiAdapter(getActivity(),homeBean);
        tuiJianRecycler.setAdapter(mySontuiAdapter);

        mySontuiAdapter.setOnItemListener(new OnItemListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("pid",homeBean.getTuijian().getList().get(position).getPid());
                startActivity(intent);
            }

            @Override
            public void OnItemLongClick(int position) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        preferences = getContext().getSharedPreferences("judge", Context.MODE_PRIVATE);
        boolean judgeValue = preferences.getBoolean("judgeValue", false);
        String username = preferences.getString("username", "登录/注册");

        if (judgeValue){

            myUserName.setText(username);
            myLinearLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   startActivity(new Intent(getActivity(), PersonMationActivity.class));
                }
            });
        }else {

            myLinearLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
            });

        }

    }

}
