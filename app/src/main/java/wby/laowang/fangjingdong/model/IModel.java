package wby.laowang.fangjingdong.model;

import java.util.Map;

public interface IModel {

    //获取登录数据
    void getDataLogin(Map<String, String> map);

    //获取用户信息
    void getUser(String uid);

    //获取购物车数据
    void getDataShoppCart(Map<String, String> map);

    //获取首页
    void getDataHome();

    //获取分类
    void getDataFenlei();

    //获取子分类
    void getDataSub(String cid);

    //获取商品列表
    void getDataProductList(Map<String, String> map);

    //获取商品详情
    void getDataDetail(int pid);

}
