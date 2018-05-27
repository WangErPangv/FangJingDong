package wby.laowang.fangjingdong.view.Iview;

import wby.laowang.fangjingdong.bean.DetailBean;

public interface IDetail {

    //展示商品详情
    void showDetail(DetailBean detailBean);

    //商品详情的pid
    int pid();
}
