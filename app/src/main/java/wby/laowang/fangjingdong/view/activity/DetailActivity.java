package wby.laowang.fangjingdong.view.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.DetailBean;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.IDetail;
import wby.laowang.fangjingdong.view.holder.GlideImageLoader;

public class DetailActivity extends AppCompatActivity implements IDetail {

    @BindView(R.id.detai_back)
    ImageView detaiBack;
    @BindView(R.id.detai_share)
    ImageView detaiShare;
    @BindView(R.id.detai_relative)
    RelativeLayout detaiRelative;
    @BindView(R.id.detai_banner)
    Banner detaiBanner;
    @BindView(R.id.detai_title)
    TextView detaiTitle;
    @BindView(R.id.detai_yuan_price)
    TextView detaiYuanPrice;
    @BindView(R.id.detai_bargin_price)
    TextView detaiBarginPrice;
    @BindView(R.id.watch_cart)
    TextView watchCart;
    @BindView(R.id.detai_add_cart)
    TextView detaiAddCart;
    private int pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        pid = getIntent().getIntExtra("pid",-1);
        if (pid != -1) {
            initDatas();
        }
        initBanner();
    }

    public void initDatas() {
        PresenterFusion presenterFusion = new PresenterFusion();
        presenterFusion.showDetailToView(new ModelFusion(presenterFusion), this);
    }

    private void initBanner() {

        //设置banner样式...CIRCLE_INDICATOR_TITLE包含标题
        detaiBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        detaiBanner.setImageLoader(new GlideImageLoader());
        //设置自动轮播，默认为true
        detaiBanner.isAutoPlay(true);
        //设置轮播时间
        detaiBanner.setDelayTime(2500);
        //设置指示器位置（当banner模式中有指示器时）
        detaiBanner.setIndicatorGravity(BannerConfig.CENTER);

    }


    @Override
    public void showDetail(DetailBean detailBean) {

        //添加删除线
        detaiYuanPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        //设置数据显示
        detaiTitle.setText(detailBean.getData().getTitle());
        detaiBarginPrice.setText("优惠价:"+detailBean.getData().getBargainPrice());
        detaiYuanPrice.setText("原价:"+detailBean.getData().getPrice());

        //获取bannet里面用的图片
        String[] images = detailBean.getData().getImages().split("\\|");

        final ArrayList<String> lists = new ArrayList<>();
        for (int i = 0; i<images.length; i++){
            lists.add(images[0]);
        }

        detaiBanner.setImages(lists);
        detaiBanner.start();
    }

    @Override
    public int pid() {
        return pid;
    }

    @OnClick({R.id.detai_back, R.id.detai_share, R.id.detai_banner, R.id.watch_cart, R.id.detai_add_cart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.detai_back:
                finish();
                break;
            case R.id.detai_share:
                break;
            case R.id.detai_banner:
                break;
            case R.id.watch_cart://查看购物车....跳转的是购物车的activity
                startActivity(new Intent(this,ShoppCartActivity.class));
                break;
            case R.id.detai_add_cart:
                break;
        }
    }
}
