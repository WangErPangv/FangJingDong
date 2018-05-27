package wby.laowang.fangjingdong.view.Iview;

import wby.laowang.fangjingdong.bean.LoginBean;


public interface ILogin {

    //登录成功
    void showLoginSuccess(LoginBean loginBean);

    //登录失败
    void showLoginError(String error);

    //登录的电话号码
    String mobile();

    //登录的密码
    String pass();

}
