package wby.laowang.fangjingdong.presenter;

import wby.laowang.fangjingdong.bean.AddCartBean;
import wby.laowang.fangjingdong.bean.DetailBean;
import wby.laowang.fangjingdong.bean.FenleiBean;
import wby.laowang.fangjingdong.bean.HomeBean;
import wby.laowang.fangjingdong.bean.ProductListBean;
import wby.laowang.fangjingdong.bean.RegisterBean;
import wby.laowang.fangjingdong.bean.SubBean;
import wby.laowang.fangjingdong.model.IModel;
import wby.laowang.fangjingdong.bean.LoginBean;
import wby.laowang.fangjingdong.bean.ShoppCartBean;
import wby.laowang.fangjingdong.bean.UserNameBean;
import wby.laowang.fangjingdong.view.Iview.IAddCart;
import wby.laowang.fangjingdong.view.Iview.IDetail;
import wby.laowang.fangjingdong.view.Iview.IFenLei;
import wby.laowang.fangjingdong.view.Iview.IHome;
import wby.laowang.fangjingdong.view.Iview.ILogin;
import wby.laowang.fangjingdong.view.Iview.IProductList;
import wby.laowang.fangjingdong.view.Iview.IRegister;
import wby.laowang.fangjingdong.view.Iview.IShoppCart;
import wby.laowang.fangjingdong.view.Iview.ISub;
import wby.laowang.fangjingdong.view.Iview.IUser;

public interface IPresenter {

    //p的登录请求数据
    void showLoginToView(IModel iModel, ILogin iLogin);

    //p的注册请求数据
    void showRegisterToView(IModel iModel, IRegister iRegister);

    //p的用户请求数据
    void showUserToview(IModel iModel, IUser iUser);

    //p的购物车请求数据
    void showShoppCartToView(IModel iModel, IShoppCart iShoppCart);

    //p的首页请求数据
    void showHomeToView(IModel iModel, IHome iHome);

    //p的分类请求数据
    void showFenleiToView(IModel iModel, IFenLei iFenLei);

    //p的子分类请求数据
    void showSubToView(IModel iModel, ISub iSub);

    //p的商品列表请求数据
    void showProductListToView(IModel iModel, IProductList iProductList);

    //p的商品商品详情请求数据
    void showDetailToView(IModel iModel, IDetail iDetail);

    //p的添加购物车请求数据
    void showAddcartToView(IModel iModel, IAddCart iAddCart);

    //接受从m传上来的数据
    void getDataLogin(LoginBean loginBean);

    void getDataRegister(RegisterBean registerBean);

    void getDataUser(UserNameBean userNameBean);

    void getDataShoppCart(ShoppCartBean shoppCartBean);

    void getDataHome(HomeBean homeBean);

    void getDataFenlei(FenleiBean fenleiBean);

    void getDataSub(SubBean subBean);

    void getDataProductList(ProductListBean productListBean);

    void getDataDetail(DetailBean detailBean);

    void getDataAddcart(AddCartBean addCartBean);

    //接受异常
    void getError(String error);
}
