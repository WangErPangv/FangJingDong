package wby.laowang.fangjingdong.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.FindVideoBean;
import wby.laowang.fangjingdong.model.MyService;
import wby.laowang.fangjingdong.util.ApiNetWork;
import wby.laowang.fangjingdong.view.adapter.MyFindVideoAdapter;

public class FindFragment extends Fragment {

    @BindView(R.id.find_rec)
    RecyclerView findRec;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.find_ment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initDatas();
        return view;
    }

    public void initDatas(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiNetWork.Find_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyService myService = retrofit.create(MyService.class);

        Map<String,String> map = new HashMap<>();
        map.put("type","4");
        map.put("page","1");
        Call<FindVideoBean> call = myService.getvideodata(map);

        call.enqueue(new Callback<FindVideoBean>() {
            @Override
            public void onResponse(Call<FindVideoBean> call, Response<FindVideoBean> response) {

                if (response.isSuccessful()){
                    FindVideoBean findVideoBean = response.body();
                    findRec.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                    MyFindVideoAdapter myFindVideoAdapter = new MyFindVideoAdapter(getContext(),findVideoBean);
                    findRec.setAdapter(myFindVideoAdapter);
                    //添加自定义分割线
                    DividerItemDecoration divider = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
                    divider.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.custom_divider));
                    findRec.addItemDecoration(divider);
                }
            }

            @Override
            public void onFailure(Call<FindVideoBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
