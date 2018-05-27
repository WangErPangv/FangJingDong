package wby.laowang.fangjingdong.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.view.adapter.MyHistoryListAdapter;
import wby.laowang.fangjingdong.view.custom.XCFlowLayout;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.search_finish)
    ImageView searchFinish;
    @BindView(R.id.sou_suo)
    LinearLayout souSuo;
    @BindView(R.id.search_sou)
    TextView searchSou;
    @BindView(R.id.search_liushi)
    XCFlowLayout searchLiushi;
    @BindView(R.id.search_list)
    ListView searchList;
    @BindView(R.id.search_kong)
    Button searchKong;
    @BindView(R.id.search_edit)
    EditText search_edit;
    private List<String> list;
    private MyHistoryListAdapter myHistoryListAdapter;
    private String mNames[] = {
            "应急启动电源", "餐桌", "粽子散装",
            "智能手表", "摩托车配件", "批发方便面",
            "王中王火腿", "手机", "桶装矿泉水",
            "U盘64G", "机械革命电脑", "洗发水",
            "护发素", "奶粉", "search", "logcat"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        initChildViews();

    }

    @OnClick({R.id.search_finish, R.id.search_sou, R.id.search_kong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search_finish:
                finish();
                break;
            //点击搜索并且显示按钮
            case R.id.search_sou:
                String shu = search_edit.getText().toString();
                list.add(shu);

                myHistoryListAdapter = new MyHistoryListAdapter(SearchActivity.this, list);
                searchList.setAdapter(myHistoryListAdapter);

                Intent intent = new Intent(SearchActivity.this,ProductListActivity.class);
                intent.putExtra("keywords",shu);
                if (shu == null || shu.equals("")){
                    Toast.makeText(this,"输入内容不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(intent);
                }

                searchKong.setVisibility(View.VISIBLE);
                break;
            case R.id.search_kong:
                list.clear();
                myHistoryListAdapter.notifyDataSetChanged();
                searchKong.setVisibility(View.GONE);
                break;
        }
    }

    //流式布局
    public void initChildViews() {
        // TODO Auto-generated method stub
        searchLiushi = findViewById(R.id.search_liushi);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for (int i = 0; i < mNames.length; i++) {
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            searchLiushi.addView(view, lp);
        }
    }

}
