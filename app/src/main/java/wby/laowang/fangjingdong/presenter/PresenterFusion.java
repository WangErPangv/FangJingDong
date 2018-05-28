package wby.laowang.fangjingdong.presenter;

import java.util.HashMap;
import java.util.Map;

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

/**
 * Presenter的操作类
 */

public class PresenterFusion implements IPresenter {

    private ILogin iLogin;
    private IRegister iRegister;
    private IUser iUser;
    private IShoppCart iShoppCart;
    private IHome iHome;
    private IFenLei iFenLei;
    private ISub iSub;
    private IProductList iProductList;
    private IDetail iDetail;
    private IAddCart iAddCart;

    @Override
    public void showLoginToView(IModel iModel, ILogin iLogin) {
        this.iLogin = iLogin;
        //model请求数据
        Map<String,String> map = new HashMap<>();
        map.put("mobile", iLogin.mobile());
        map.put("password", iLogin.pass());
        iModel.getDataLogin(map);

    }

    @Override
    public void showRegisterToView(IModel iModel, IRegister iRegister) {
        this.iRegister = iRegister;

        Map<String,String> map = new HashMap<>();
        map.put("mobile", iRegister.mobile());
        map.put("password", iRegister.pass());
        iModel.getDataRegister(map);
    }

    @Override
    public void showUserToview(IModel iModel, IUser iUser) {
        this.iUser = iUser;
        iModel.getUser(iUser.uid());
    }

    @Override
    public void showShoppCartToView(IModel iModel, IShoppCart iShoppCart) {
        this.iShoppCart = iShoppCart;
        Map<String,String> map = new HashMap<>();
        map.put("uid",iShoppCart.uid());
        iModel.getDataShoppCart(map);
    }

    @Override
    public void showHomeToView(IModel iModel, IHome iHome) {
        this.iHome = iHome;
        iModel.getDataHome();
    }

    @Override
    public void showFenleiToView(IModel iModel, IFenLei iFenLei) {
        this.iFenLei = iFenLei;
        iModel.getDataFenlei();
    }

    @Override
    public void showSubToView(IModel iModel, ISub iSub) {
        this.iSub = iSub;
        iModel.getDataSub(iSub.cid());
    }

    @Override
    public void showProductListToView(IModel iModel, IProductList iProductList) {
        this.iProductList = iProductList;

        Map<String,String> map = new HashMap<>();
        map.put("keywords",iProductList.keywords());
        map.put("page",String.valueOf(iProductList.page()));
        iModel.getDataProductList(map);
    }

    @Override
    public void showDetailToView(IModel iModel, IDetail iDetail) {
        this.iDetail = iDetail;
        iModel.getDataDetail(iDetail.pid());
    }

    @Override
    public void showAddcartToView(IModel iModel, IAddCart iAddCart) {
        this.iAddCart = iAddCart;

        Map<String,String> map = new HashMap<>();
        map.put("uid",iAddCart.auid());
        map.put("pid",iAddCart.apid());
        iModel.getDataAddcart(map);
    }

    @Override
    public void getDataLogin(LoginBean loginBean) {

        iLogin.showLoginSuccess(loginBean);

    }

    @Override
    public void getDataRegister(RegisterBean registerBean) {
        iRegister.showRegisterSuccess(registerBean);
    }

    @Override
    public void getDataUser(UserNameBean userNameBean) {
        iUser.showUser(userNameBean);
    }

    @Override
    public void getDataShoppCart(ShoppCartBean shoppCartBean) {
        iShoppCart.showShoppCart(shoppCartBean);
    }

    @Override
    public void getDataHome(HomeBean homeBean) {
        iHome.showHome(homeBean);
    }

    @Override
    public void getDataFenlei(FenleiBean fenleiBean) {
        iFenLei.showFenLei(fenleiBean);
    }

    @Override
    public void getDataSub(SubBean subBean) {
        iSub.showSub(subBean);
    }

    @Override
    public void getDataProductList(ProductListBean productListBean) {
        iProductList.showProductList(productListBean);
    }

    @Override
    public void getDataDetail(DetailBean detailBean) {
        iDetail.showDetail(detailBean);
    }

    @Override
    public void getDataAddcart(AddCartBean addCartBean) {
        iAddCart.showAddcart(addCartBean);
    }

    @Override
    public void getError(String error) {
        iLogin.showLoginError(error);
    }
}
