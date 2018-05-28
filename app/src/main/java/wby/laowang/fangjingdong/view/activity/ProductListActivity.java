package wby.laowang.fangjingdong.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.ProductListBean;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.IProductList;
import wby.laowang.fangjingdong.view.Iview.OnItemListener;
import wby.laowang.fangjingdong.view.adapter.MyProductListAdapter;
import wby.laowang.fangjingdong.view.adapter.MyProductListGridAdapter;
/*
* 在这个商品列表里应该有一个grid的适配器，这个欠缺了这个，只是使用了myProductListAdapter来做为两个的转换
* 如果在后边有学会在更改
* **/
public class ProductListActivity extends AppCompatActivity implements IProductList {

    @BindView(R.id.product_finish)
    ImageView productFinish;
    @BindView(R.id.product_suo)
    LinearLayout productSuo;
    @BindView(R.id.product_change)
    ImageView productChange;
    @BindView(R.id.product_rec)
    RecyclerView productRec;
    @BindView(R.id.product_smart)
    SmartRefreshLayout productSmart;
    private int ppage = 1;
    private String pkeywords;
    Boolean flag = true;
    private List<ProductListBean.DataBean> plist;
    private MyProductListAdapter myProductListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);

        pkeywords = getIntent().getStringExtra("keywords");
        initDatas();

    }

    public void initDatas() {
        PresenterFusion presenterFusion = new PresenterFusion();
        presenterFusion.showProductListToView(new ModelFusion(presenterFusion), this);

        productSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                ppage = 1;
                plist.clear();
                initDatas();
            }
        });

        productSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                ppage++;
                initDatas();
            }
        });

    }

    @OnClick({R.id.product_finish, R.id.product_suo, R.id.product_change})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.product_finish:
                finish();
                break;
            case R.id.product_suo:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.product_change:

                if (flag) {
                    productRec.setLayoutManager(new GridLayoutManager(ProductListActivity.this, 2, GridLayoutManager.VERTICAL, false));
                    myProductListAdapter.notifyDataSetChanged();
                    productChange.setImageResource(R.drawable.kind_liner);
                    flag = false;
                } else {
                    productRec.setLayoutManager(new LinearLayoutManager(ProductListActivity.this, LinearLayoutManager.VERTICAL, false));
                    myProductListAdapter.notifyDataSetChanged();
                    productChange.setImageResource(R.drawable.kind_grid);
                    flag = true;
                }

                break;
        }
    }

    @Override
    public void showProductList(ProductListBean productListBean) {
        this.plist = productListBean.getData();

        if (myProductListAdapter == null) {
            myProductListAdapter = new MyProductListAdapter(ProductListActivity.this, plist);
            productRec.setAdapter(myProductListAdapter);

        } else {
            myProductListAdapter.notifyDataSetChanged();
        }

        productSmart.finishRefresh(2000);
        productSmart.finishLoadMore(2000);

        if (flag) {
            productRec.setLayoutManager(new LinearLayoutManager(ProductListActivity.this, LinearLayoutManager.VERTICAL, false));

        } else {
            productRec.setLayoutManager(new GridLayoutManager(ProductListActivity.this, 2, GridLayoutManager.VERTICAL, false));
        }

        myProductListAdapter = new MyProductListAdapter(ProductListActivity.this, plist);
        productRec.setAdapter(myProductListAdapter);

        //recyclerView滑动卡顿解决方案，利用RecyclerView内部方法
        productRec.setHasFixedSize(true);
        productRec.setNestedScrollingEnabled(false);

        myProductListAdapter.setOnItemListener(new OnItemListener() {
            @Override
            public void OnItemClick(int position) {
                int pid = plist.get(position).getPid();
                Intent intent = new Intent(ProductListActivity.this, DetailActivity.class);
                intent.putExtra("pid", pid);
                startActivity(intent);
            }

            @Override
            public void OnItemLongClick(int position) {

            }
        });



}

    @Override
    public String keywords() {
        return pkeywords;
    }

    @Override
    public int page() {
        return ppage;
    }
}
