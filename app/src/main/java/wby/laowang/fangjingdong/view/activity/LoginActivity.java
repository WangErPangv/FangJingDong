package wby.laowang.fangjingdong.view.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.LoginBean;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.ILogin;

public class LoginActivity extends AppCompatActivity implements ILogin {

    @BindView(R.id.ed_mobile)
    EditText edMobile;
    @BindView(R.id.ed_pass)
    EditText edPass;
    @BindView(R.id.lo_register)
    TextView loRegister;
    @BindView(R.id.qq_login)
    ImageView qqLogin;
    private PresenterFusion presenterFusion;
    //SharedPreferences做判断值用
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public void cha(View view) {
        finish();
    }

    public void login(View view) {
        presenterFusion = new PresenterFusion();
        presenterFusion.showLoginToView(new ModelFusion(presenterFusion), this);
    }

    @Override
    public void showLoginSuccess(LoginBean loginBean) {

        if (loginBean.getCode().equals("0")) {
            Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();

            //实例化SharedPreferences
            preferences = getSharedPreferences("judge", Context.MODE_PRIVATE);
            editor = preferences.edit();
            editor.putBoolean("judgeValue", true);
            editor.putString("username",loginBean.getData().getUsername());
            editor.putString("louid",String.valueOf(loginBean.getData().getUid()));
            editor.commit();

            finish();
        } else {
            Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.lo_register)
    public void onViewClicked() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public String mobile() {
        return edMobile.getText().toString();
    }

    @Override
    public String pass() {
        return edPass.getText().toString();
    }

}
