package wby.laowang.fangjingdong.view.Iview;

import wby.laowang.fangjingdong.bean.ShoppCartBean;

public interface IShoppCart {

    //展示购物车
    void showShoppCart(ShoppCartBean shoppCartBean);

    //购物车的uid
    String uid();
}
