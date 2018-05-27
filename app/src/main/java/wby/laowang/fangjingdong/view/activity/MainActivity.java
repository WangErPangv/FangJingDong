package wby.laowang.fangjingdong.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.view.fragment.FenLeiFragment;
import wby.laowang.fangjingdong.view.fragment.FindFragment;
import wby.laowang.fangjingdong.view.fragment.HomeFragment;
import wby.laowang.fangjingdong.view.fragment.MyFragment;
import wby.laowang.fangjingdong.view.fragment.ShoppCartFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    private HomeFragment homeFragment;
    private FenLeiFragment fenLeiFragment;
    private FindFragment findFragment;
    private ShoppCartFragment shoppCartFragment;
    private MyFragment myFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    public void initData(){

        //管理者...开启事务(一个事务只能执行一次)....默认的是要显示第一个首页
        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        //添加这个方法在使用的时候同一个fragment只能添加一次,否则会报错...结合着show和hide方法去使用
        fragmentManager.beginTransaction().add(R.id.frame, homeFragment).commit();
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        FragmentTransaction fragtran = fragmentManager.beginTransaction();
        //首先隐藏所有的fragment ...前提是不为空
        //在刚开始点击的时候,先判断fragment是否为空,,,如果不为空先让他隐藏
        if (homeFragment != null) {
            fragtran.hide(homeFragment);
        }
        if (fenLeiFragment != null) {
            fragtran.hide(fenLeiFragment);
        }
        if (findFragment != null) {
            fragtran.hide(findFragment);
        }
        if (shoppCartFragment != null) {
            fragtran.hide(shoppCartFragment);
        }
        if (myFragment != null) {
            fragtran.hide(myFragment);
        }

        switch (checkedId) {//点击选中某个button的时候要么去显示要么去添加,,,没有去添加,,,有则显示出来
            case R.id.home:
                if (homeFragment != null){
                    fragtran.show(homeFragment);
                }else {
                    homeFragment = new HomeFragment();
                    fragtran.add(R.id.frame,homeFragment);
                }
                break;

            case R.id.fenlei:
                if (fenLeiFragment != null){
                    fragtran.show(fenLeiFragment);
                }else {
                    fenLeiFragment = new FenLeiFragment();
                    fragtran.add(R.id.frame,fenLeiFragment);
                }
                break;

            case R.id.find:
                if (findFragment != null){
                    fragtran.show(findFragment);
                }else {
                    findFragment = new FindFragment();
                    fragtran.add(R.id.frame,findFragment);
                }
                break;

            case R.id.shopp_cart:
                if (shoppCartFragment != null){
                    fragtran.show(shoppCartFragment);
                }else {
                    shoppCartFragment = new ShoppCartFragment();
                    fragtran.add(R.id.frame,shoppCartFragment);
                }
                break;

            case R.id.my:
                if (myFragment != null){
                    fragtran.show(myFragment);
                }else {
                    myFragment = new MyFragment();
                    fragtran.add(R.id.frame,myFragment);
                }
                break;
        }

        //只能提交一次
        fragtran.commit();

    }
}
