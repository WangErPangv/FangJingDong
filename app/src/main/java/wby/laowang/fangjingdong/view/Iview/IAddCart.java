package wby.laowang.fangjingdong.view.Iview;

import wby.laowang.fangjingdong.bean.AddCartBean;


public interface IAddCart {

    //添加购物车
    void showAddcart(AddCartBean addCartBean);

    //购物车的uid
    String auid();

    //购物车的pid
    String apid();
}
