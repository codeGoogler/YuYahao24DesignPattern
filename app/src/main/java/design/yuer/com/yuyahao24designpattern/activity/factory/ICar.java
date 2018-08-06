package design.yuer.com.yuyahao24designpattern.activity.factory;

/**
 * 类功能描述：一个抽象的创造类，用于创造各种汽车类</br>
 *  公众号：终端研发部
 *  个人主页：https://blog.csdn.net/androidstarjack
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：2018/8/6</br> 修改备注：</br>
 */
public interface ICar<T> {
    T makeCar();
    void driveWay();
}
