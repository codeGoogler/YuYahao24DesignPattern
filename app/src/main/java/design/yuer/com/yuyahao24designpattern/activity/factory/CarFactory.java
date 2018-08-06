package design.yuer.com.yuyahao24designpattern.activity.factory;

/**
 * 类功能描述：</br>
 *
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：2018/8/6</br> 修改备注：</br>
 */
public class CarFactory  {

    public  ICar createCar(String carTypeCalzz){
        switch (carTypeCalzz){
            case "Autocar":
                return new Autocar();
            case "BicycleCar":
                return new BicycleCar();
            case "UfoCar":
                return new UfoCar();
            case "TrainCar":
                return new TrainCar();
        }
        return new ICar() {
            @Override
            public Object makeCar() {
                return null;
            }

            @Override
            public void driveWay() {

            }
        };
    }
}
