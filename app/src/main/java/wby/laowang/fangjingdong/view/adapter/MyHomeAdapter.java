package wby.laowang.fangjingdong.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.FenleiBean;
import wby.laowang.fangjingdong.bean.HomeBean;
import wby.laowang.fangjingdong.view.Iview.OnItemListener;
import wby.laowang.fangjingdong.view.activity.CustomCapatrueActivity;
import wby.laowang.fangjingdong.view.activity.DetailActivity;
import wby.laowang.fangjingdong.view.activity.SearchActivity;
import wby.laowang.fangjingdong.view.activity.WebActivity;
import wby.laowang.fangjingdong.view.holder.GlideImageLoader;
import wby.laowang.fangjingdong.view.holder.MyHomeBannerHolder;
import wby.laowang.fangjingdong.view.holder.MyHomeJiuHolder;
import wby.laowang.fangjingdong.view.holder.MyHomeMiaoHolder;
import wby.laowang.fangjingdong.view.holder.MyHomeTuiHolder;

public class MyHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private HomeBean homeBean;
    private FenleiBean fenleiBean;
    private int Home_banner = 0;
    private int Home_jiu = 1;
    private int Home_miao = 2;
    private int Home_tui = 3;
    //倒计时用到的变量
    @BindView(R.id.tv_hour)
    TextView tvHour;
    @BindView(R.id.tv_minute)
    TextView tvMinute;
    @BindView(R.id.tv_second)
    TextView tvSecond;
    static long mHour = 02;
    static long mMin = 15;
    boolean isRun = true;
    static long mSecond = 36;
    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == 1) {
                //调用 倒计时计算的方法
                computeTime();
                if (mHour < 10) {
                    tvHour.setText("0" + mHour + "");
                } else {
                    tvHour.setText(mHour + "");
                }
                if (mMin < 10) {
                    tvMinute.setText("0" + mMin + "");
                } else {
                    tvMinute.setText(mMin + "");
                }
                if (mSecond < 10) {
                    tvSecond.setText("0" + mSecond + "");
                } else {
                    tvSecond.setText(mSecond + "");
                }
            }
        }
    };

    public MyHomeAdapter(Context context, HomeBean homeBean, FenleiBean fenleiBean) {
        this.context = context;
        this.homeBean = homeBean;
        this.fenleiBean = fenleiBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == Home_banner) {

            View viewb = LayoutInflater.from(context).inflate(R.layout.home_banner, parent, false);
            MyHomeBannerHolder myHomeBannerHolder = new MyHomeBannerHolder(viewb);
            return myHomeBannerHolder;
        } else if (viewType == Home_jiu) {

            View viewj = LayoutInflater.from(context).inflate(R.layout.home_jiu, parent, false);
            MyHomeJiuHolder myHomeJiuHolder = new MyHomeJiuHolder(viewj);
            return myHomeJiuHolder;
        } else if (viewType == Home_miao) {

            View viewm = LayoutInflater.from(context).inflate(R.layout.home_miao, parent, false);
            ButterKnife.bind(this, viewm);
            MyHomeMiaoHolder myHomeMiaoHolder = new MyHomeMiaoHolder(viewm);
            return myHomeMiaoHolder;
        } else if (viewType == Home_tui) {

            View viewt = LayoutInflater.from(context).inflate(R.layout.home_tui, parent, false);
            MyHomeTuiHolder myHomeTuiHolder = new MyHomeTuiHolder(viewt);
            return myHomeTuiHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyHomeBannerHolder) {

            //设置banner样式...CIRCLE_INDICATOR_TITLE包含标题
            ((MyHomeBannerHolder) holder).bannerp.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //设置图片加载器
            ((MyHomeBannerHolder) holder).bannerp.setImageLoader(new GlideImageLoader());
            //设置自动轮播，默认为true
            ((MyHomeBannerHolder) holder).bannerp.isAutoPlay(true);
            //设置轮播时间
            ((MyHomeBannerHolder) holder).bannerp.setDelayTime(3000);
            //设置指示器位置（当banner模式中有指示器时）
            ((MyHomeBannerHolder) holder).bannerp.setIndicatorGravity(BannerConfig.CENTER);

            List<HomeBean.DataBean> data = homeBean.getData();
            List<String> limg = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                limg.add(data.get(i).getIcon());
            }
            ((MyHomeBannerHolder) holder).bannerp.setImages(limg);
            ((MyHomeBannerHolder) holder).bannerp.start();

            //banner的点击事件
            ((MyHomeBannerHolder) holder).bannerp.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {

                    if (homeBean.getData().get(position).getType() == 0) {
                        Intent intent = new Intent(context, WebActivity.class);
                        intent.putExtra("burl", homeBean.getData().get(position).getUrl());
                        context.startActivity(intent);
                    } else {

                        Toast.makeText(context, "即将跳转到商品详情页面", Toast.LENGTH_SHORT).show();
                    }


                }
            });

            //二维码的扫描点击事件
            ((MyHomeBannerHolder) holder).sao_miao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CustomCapatrueActivity.class));
                }
            });

            //搜索框的点击事件
            ((MyHomeBannerHolder) holder).sou_suo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, SearchActivity.class));
                }
            });

            //消息的点击事件
            ((MyHomeBannerHolder) holder).xiao_xi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"正在开发中",Toast.LENGTH_SHORT).show();
                }
            });


        } else if (holder instanceof MyHomeJiuHolder) {

            ((MyHomeJiuHolder) holder).homeJiu.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false));
            MySonjiuAdapter mySonjiuAdapter = new MySonjiuAdapter(context, fenleiBean);
            ((MyHomeJiuHolder) holder).homeJiu.setAdapter(mySonjiuAdapter);

            mySonjiuAdapter.setOnItemListener(new OnItemListener() {
                @Override
                public void OnItemClick(int position) {
                    Toast.makeText(context,"单击事件执行",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void OnItemLongClick(int position) {
                    Toast.makeText(context,"长按事件执行",Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof MyHomeMiaoHolder) {

            List<String> info = new ArrayList<>();
            info.add("欢迎访问京东App");
            info.add("铁三角ATHSH刷新了");
            info.add("地道日系风琴ATH-TECH");
            info.add("便携设备的音质救星");
            info.add("好好学习，马上就毕业了");
            ((MyHomeMiaoHolder) holder).marqueeView.startWithList(info);

            startRun();
            ((MyHomeMiaoHolder) holder).homeMiao.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            MySonmiaoAdapter mySonmiaoAdapter = new MySonmiaoAdapter(context, homeBean);
            ((MyHomeMiaoHolder) holder).homeMiao.setAdapter(mySonmiaoAdapter);

            mySonmiaoAdapter.setOnItemListener(new OnItemListener() {
                @Override
                public void OnItemClick(int position) {
                    Intent intent = new Intent(context, WebActivity.class);
                    intent.putExtra("burl", homeBean.getMiaosha().getList().get(position).getDetailUrl());
                    context.startActivity(intent);
                }

                @Override
                public void OnItemLongClick(int position) {

                }
            });
        } else if (holder instanceof MyHomeTuiHolder) {

            ((MyHomeTuiHolder) holder).homeTui.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false));
            MySontuiAdapter mySontuiAdapter = new MySontuiAdapter(context, homeBean);
            ((MyHomeTuiHolder) holder).homeTui.setAdapter(mySontuiAdapter);

            mySontuiAdapter.setOnItemListener(new OnItemListener() {
                @Override
                public void OnItemClick(int position) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("pid",homeBean.getTuijian().getList().get(position).getPid());
                    context.startActivity(intent);
                }

                @Override
                public void OnItemLongClick(int position) {

                }
            });
        }
    }

    /**
     * 开启倒计时
     */
    private void startRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRun) {
                    try {
                        //睡眠一秒发送消息handler
                        Thread.sleep(1000);
                        Message message = Message.obtain();
                        message.what = 1;
                        //发送消息
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    //调用 倒计时计算的方法

    /**
     * 倒计时计算
     */
    private static void computeTime() {
        //首先把秒减1
        mSecond--;
        if (mSecond < 0) {//如果秒已经减到了0
            mMin--;//分钟就减1
            mSecond = 59;//秒变成 59
            if (mMin < 0) {//如果分钟小于0
                mMin = 59;//分钟变成59
                mHour--;//小时减1
            }
        }
    }


    @Override
    public int getItemViewType(int position) {

        if (position == 0) {

            return Home_banner;
        } else if (position == 1) {

            return Home_jiu;
        } else if (position == 2) {

            return Home_miao;
        } else {

            return Home_tui;
        }
    }

    @Override
    public int getItemCount() {

        if (Home_banner == 0) {

            return homeBean.getData().size();
        } else if (Home_jiu == 1) {

            return fenleiBean.getData().size();
        } else if (Home_miao == 2) {

            return homeBean.getMiaosha().getList().size();
        } else {

            return homeBean.getTuijian().getList().size();
        }

    }
}
