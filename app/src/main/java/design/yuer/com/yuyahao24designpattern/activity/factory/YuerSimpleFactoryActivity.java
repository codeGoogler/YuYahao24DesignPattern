package design.yuer.com.yuyahao24designpattern.activity.factory;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import design.yuer.com.yuyahao24designpattern.R;

/**
 * 类功能描述：工厂方法测试类</br>
 *  公众号：终端研发部
 *  个人主页：https://blog.csdn.net/androidstarjack
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：2018/8/6</br> 修改备注：</br>
 */
public class YuerSimpleFactoryActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuersimplefactory);
        CarFactory carFactory = new CarFactory();
        ICar iCar =  carFactory.createCar("Autocar");
        iCar.makeCar();
        iCar.driveWay();
        iCar =  carFactory.createCar("BicycleCar");
        iCar.makeCar();
        iCar.driveWay();
        iCar =  carFactory.createCar("TrainCar");
        iCar.makeCar();
        iCar.driveWay();
        iCar =  carFactory.createCar("UfoCar");
        iCar.makeCar();
        iCar.driveWay();
    }
}
