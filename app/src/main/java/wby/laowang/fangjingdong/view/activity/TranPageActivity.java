package wby.laowang.fangjingdong.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wby.laowang.fangjingdong.R;

public class TranPageActivity extends AppCompatActivity {

    @BindView(R.id.splash_time)
    TextView tranTime;
    @BindView(R.id.skip)
    TextView skip;
    private MyHandler myHandler = new MyHandler();
    private int index = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_tran_page);
        ButterKnife.bind(this);

        //默认值
        tranTime.setText(index + "s");

        myHandler.sendEmptyMessageDelayed(0, 1000);
    }

    @OnClick(R.id.skip)
    public void onViewClicked() {
        startActivity(new Intent(TranPageActivity.this,MainActivity.class));
        finish();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            msg.what = 0;
            index--;
            tranTime.setText(index + "s");
            if (index == 0) {
                //removeCallbacksAndMessages代表清空当前Handler队列所有消息
                myHandler.removeCallbacksAndMessages(null);
                //跳转
                startActivity(new Intent(TranPageActivity.this, MainActivity.class));
                finish();
            } else {
                myHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myHandler.removeCallbacksAndMessages(null);
    }
}
