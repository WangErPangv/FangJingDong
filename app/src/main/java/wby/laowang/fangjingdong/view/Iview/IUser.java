package wby.laowang.fangjingdong.view.Iview;

        import wby.laowang.fangjingdong.bean.UserNameBean;

public interface IUser {

    //获取用户信息
    void showUser(UserNameBean userNameBean);

    //用户信息的uid
    String uid();
}
