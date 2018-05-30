package wby.laowang.fangjingdong.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wby.laowang.fangjingdong.R;

public class PersonMationActivity extends AppCompatActivity {

    @BindView(R.id.detail_image_back)
    ImageView detailImageBack;
    @BindView(R.id.linear_upload)
    LinearLayout linearUpload;
    //SharedPreferences做判断值用
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_person_mation);
        ButterKnife.bind(this);

        //实例化SharedPreferences
        preferences = getSharedPreferences("judge", Context.MODE_PRIVATE);

    }

    @OnClick({R.id.detail_image_back, R.id.linear_upload})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.detail_image_back:
                finish();
                break;
            case R.id.linear_upload:
                break;
        }
    }

    public void signOut(View view) {

        boolean judgeValue = preferences.getBoolean("judgeValue", false);
        preferences.getString("louid","");
        if (!judgeValue){

        }else {

        }

        finish();
    }
}
