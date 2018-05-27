package wby.laowang.fangjingdong.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.activity.CaptureActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;

public class CustomCapatrueActivity extends AppCompatActivity {

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_result)
    TextView tvResult;
    private final static int REQ_CODE = 1028;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_custom_capatrue);
        ButterKnife.bind(this);

        //扫码
        Intent intent = new Intent(CustomCapatrueActivity.this, CaptureActivity.class);
        startActivityForResult(intent,REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            ivImage.setVisibility(View.VISIBLE);
            //edtContent.setVisibility(View.GONE);

            String result = data.getStringExtra(CaptureActivity.SCAN_QRCODE_RESULT);
            Bitmap bitmap = data.getParcelableExtra(CaptureActivity.SCAN_QRCODE_BITMAP);

            tvResult.setText("扫描结果为：" + result);
            showToast("扫码结果："+result);
            if (bitmap != null) {
                ivImage.setImageBitmap(bitmap);
            }
        }
    }

    private void showToast(String msg) {
        Toast.makeText(CustomCapatrueActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
    }
}
