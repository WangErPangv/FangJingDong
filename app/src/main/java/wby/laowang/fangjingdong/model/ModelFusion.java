package wby.laowang.fangjingdong.model;

import java.util.Map;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wby.laowang.fangjingdong.bean.DetailBean;
import wby.laowang.fangjingdong.bean.FenleiBean;
import wby.laowang.fangjingdong.bean.HomeBean;
import wby.laowang.fangjingdong.bean.LoginBean;
import wby.laowang.fangjingdong.bean.ProductListBean;
import wby.laowang.fangjingdong.bean.ShoppCartBean;
import wby.laowang.fangjingdong.bean.SubBean;
import wby.laowang.fangjingdong.bean.UserNameBean;
import wby.laowang.fangjingdong.presenter.IPresenter;
import wby.laowang.fangjingdong.util.RetrofitUtil;


/**
 * model的具体实现
 */

public class ModelFusion implements IModel {

    private IPresenter iPresenter;

    public ModelFusion(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    @Override
    public void getDataLogin(Map<String, String> map) {

        //网络请求
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<LoginBean> observable = myService.getlogin(map);
        //请求执行
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                        iPresenter.getDataLogin(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getUser(String uid) {

        //网络请求
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<UserNameBean> observable = myService.getuser(uid);
        //请求执行
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserNameBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserNameBean userNameBean) {
                        iPresenter.getDataUser(userNameBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataShoppCart(Map<String, String> map) {

        //网络请求
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<ShoppCartBean> observable = myService.getshoppcart(map);
        //请求执行
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShoppCartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShoppCartBean shoppCartBean) {

                        iPresenter.getDataShoppCart(shoppCartBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataHome() {

        //网络请求
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<HomeBean> observable = myService.gethome();
        //请求执行
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        iPresenter.getDataHome(homeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataFenlei() {

        //网络请求
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<FenleiBean> observable = myService.getfenlei();

        //请求执行
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenleiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FenleiBean fenleiBean) {
                        iPresenter.getDataFenlei(fenleiBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataSub(String cid) {

        //网络请求
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<SubBean> observable = myService.getsub(cid);

        //请求执行
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SubBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SubBean subBean) {
                        iPresenter.getDataSub(subBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataProductList(Map<String, String> map) {

        //网络请求
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<ProductListBean> observable = myService.getproductlist(map);

        //请求执行
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductListBean productListBean) {
                        iPresenter.getDataProductList(productListBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDataDetail(int pid) {

        //网络请求
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<DetailBean> observable = myService.getdetail(pid);

        //请求执行
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailBean detailBean) {
                        iPresenter.getDataDetail(detailBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
