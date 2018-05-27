package wby.laowang.fangjingdong.view.Iview;

import wby.laowang.fangjingdong.bean.ProductListBean;


public interface IProductList {

    //展示商品列表
    void showProductList(ProductListBean productListBean);

    //刷新的方法
    void showSmartre();

    //加载的方法
    void showSmartload();

    //商品列表的keywords
    String keywords();

    //商品列表的page
    int page();
}
