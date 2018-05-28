package wby.laowang.fangjingdong.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.RegisterBean;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.IRegister;

public class RegisterActivity extends AppCompatActivity implements IRegister {

    @BindView(R.id.zedtel)
    EditText zedtel;
    @BindView(R.id.zedpass)
    EditText zedpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    public void re_gister(View view) {

        PresenterFusion presenterFusion = new PresenterFusion();
        presenterFusion.showRegisterToView(new ModelFusion(presenterFusion),this);
    }

    public void fan(View view) {
        finish();
    }

    @Override
    public void showRegisterSuccess(RegisterBean registerBean) {

        if (registerBean.getCode().equals("0")){
            Toast.makeText(this,registerBean.getMsg(),Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this,registerBean.getMsg(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public String mobile() {
        return zedtel.getText().toString();
    }

    @Override
    public String pass() {
        return zedpass.getText().toString();
    }
}
