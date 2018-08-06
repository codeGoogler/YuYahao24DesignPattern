package design.yuer.com.yuyahao24designpattern.activity.factory;

import design.yuer.com.yuyahao24designpattern.bean.CarBean;
import design.yuer.com.yuyahao24designpattern.utils.LogUtils;

/**
 * 类功能描述：</br>
 *
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：2018/8/6</br> 修改备注：</br>
 */
public class UfoCar implements ICar<CarBean> {
    @Override
    public CarBean makeCar() {
        CarBean carBean = new CarBean();
        carBean.setName("智能飞船");
        carBean.setPrice(300000);
        LogUtils.i("yuyahao","生产了一辆"+carBean.getName()+"");
        return carBean;
    }

    @Override
    public void driveWay() {
        LogUtils.i("yuyahao","我是智能飞船，智能在天空中穿梭");
    }

}