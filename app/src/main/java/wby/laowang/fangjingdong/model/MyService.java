package wby.laowang.fangjingdong.model;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import wby.laowang.fangjingdong.bean.AddCartBean;
import wby.laowang.fangjingdong.bean.DetailBean;
import wby.laowang.fangjingdong.bean.FenleiBean;
import wby.laowang.fangjingdong.bean.FindVideoBean;
import wby.laowang.fangjingdong.bean.HomeBean;
import wby.laowang.fangjingdong.bean.LoginBean;
import wby.laowang.fangjingdong.bean.ProductListBean;
import wby.laowang.fangjingdong.bean.RegisterBean;
import wby.laowang.fangjingdong.bean.ShoppCartBean;
import wby.laowang.fangjingdong.bean.SubBean;
import wby.laowang.fangjingdong.bean.UserNameBean;

public interface MyService {

    //登录
    @GET("user/login")
    Observable<LoginBean> getlogin(@QueryMap Map<String, String> map);
    //注册
    @GET("user/reg")
    Observable<RegisterBean> getregister(@QueryMap Map<String, String> map);
    //获取用户信息
    @GET("user/getUserInfo")
    Observable<UserNameBean> getuser(@Query("uid") String uid);
    //购物车
    @GET("product/getCarts")
    Observable<ShoppCartBean> getshoppcart(@QueryMap Map<String, String> map);
    //发现的视频
    @GET("satinApi")
    Call<FindVideoBean> getvideodata(@QueryMap Map<String,String> map);
    //首页
    @GET("ad/getAd")
    Observable<HomeBean> gethome();
    //分类
    @GET("product/getCatagory")
    Observable<FenleiBean> getfenlei();
    //子分类
    @GET("product/getProductCatagory")
    Observable<SubBean> getsub(@Query("cid") String cid);
    //商品列表
    @GET("product/searchProducts")
    Observable<ProductListBean> getproductlist(@QueryMap Map<String, String> map);
    //商品详情
    @GET("product/getProductDetail")
    Observable<DetailBean> getdetail(@Query("pid") int pid);
    //添加购物车
    @GET("product/addCart")
    Observable<AddCartBean> getaddcart(@QueryMap Map<String, String> map);

}
