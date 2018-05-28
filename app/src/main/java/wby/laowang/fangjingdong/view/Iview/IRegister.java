package wby.laowang.fangjingdong.view.Iview;


import wby.laowang.fangjingdong.bean.RegisterBean;

public interface IRegister {

    //注册成功
    void showRegisterSuccess(RegisterBean registerBean);

    //注册的电话号码
    String mobile();

    //注册的密码
    String pass();
}
