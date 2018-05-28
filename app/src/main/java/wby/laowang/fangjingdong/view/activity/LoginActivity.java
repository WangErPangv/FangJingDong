package wby.laowang.fangjingdong.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wby.laowang.fangjingdong.R;
import wby.laowang.fangjingdong.bean.LoginBean;
import wby.laowang.fangjingdong.bean.UserNameBean;
import wby.laowang.fangjingdong.model.ModelFusion;
import wby.laowang.fangjingdong.presenter.PresenterFusion;
import wby.laowang.fangjingdong.view.Iview.ILogin;
import wby.laowang.fangjingdong.view.Iview.IUser;
import wby.laowang.fangjingdong.view.message.MessageEvent;

public class LoginActivity extends AppCompatActivity implements ILogin, IUser {

    @BindView(R.id.ed_mobile)
    EditText edMobile;
    @BindView(R.id.ed_pass)
    EditText edPass;
    @BindView(R.id.lo_register)
    TextView loRegister;
    @BindView(R.id.qq_login)
    ImageView qqLogin;
    private LoginBean loginBeanp;
    private PresenterFusion presenterFusion;
    private String suid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    public void userinfo() {
        suid = String.valueOf(loginBeanp.getData().getUid());
        presenterFusion.showUserToview(new ModelFusion(presenterFusion), this);

    }

    @Override
    public void showLoginSuccess(LoginBean loginBean) {
        this.loginBeanp = loginBean;
        if (loginBean.getCode().equals("0")) {
            Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
            userinfo();
            finish();
        } else {
            Toast.makeText(this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick(R.id.lo_register)
    public void onViewClicked() {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    @Override
    public void showLoginError(String error) {

    }

    @Override
    public String mobile() {
        return edMobile.getText().toString();
    }

    @Override
    public String pass() {
        return edPass.getText().toString();
    }


    @Override
    public void showUser(UserNameBean userNameBean) {

        EventBus.getDefault().post(new MessageEvent(userNameBean.getData().getUsername()));
    }

    @Override
    public String uid() {
        return suid;
    }

}
