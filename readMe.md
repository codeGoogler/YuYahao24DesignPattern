#### 前言
最近一直在Java方向奋斗[**终于，我还是下决心学Java后台了**](http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=2247486120&idx=1&sn=db5f94ad8554bd2739d962b7724033f3&chksm=eb476636dc30ef2072bacb21fa532eae3c9ab9315fac62becfd052ad990857f7d400e6584e72&scene=21#wechat_redirect)，今天抽空开始学习Java的设计模式了
。计划有时间就去学习，你这么有时间，还不来一起上车吗？

之所以要学习Java模式，是因为面试的时候有时间回答的不是太完整，面试过后才想起来如何回答。所以，我说了了： **只有总结才是王道，只有总结才能提高**

####设计模式

其实正规的来说Java其实是23中设计模式，不过网上也有说是24种或者是26中的！设计模式不过是前人对代码的一种封装。用专业的话来讲：设计模式是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结

**创建型模式，共五种：**
- 1.工厂方法模式、
- 2.抽象工厂模式、
- 3.单例模式、
- 4.建造者模式、
- 5.原型模式。

**结构型模式，共七种：**
- 6.适配器模式、
- 7.装饰器模式、
- 8.代理模式、
- 9.外观模式、
- 10.桥接模式、
- 11.组合模式、
- 12.享元模式。

**行为型模式，共十一种：**
- 13.策略模式、
- 14.模板方法模式、
- 15.观察者模式、
- 16.迭代子模式、
- 17.责任链模式、
- 18.命令模式、
- 19.备忘录模式、
- 20.状态模式、
- 21.访问者模式、
- 22.中介者模式、
- 23.解释器模式。

### 今日重点：简单工厂模式

工厂模式是创建型模式之一，又称为静态工厂方法模式！

##### 组成部分


简单工厂模式由三种角色组成：
（1）工厂角色：简单工厂模式的核心，它负责实现创建所有实例的内部逻辑。工厂类的创建产品类的方法可以被外界直接调用，创建所需的产品对象。
（2）抽象产品角色：简单工厂模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
（3）具体产品角色：是简单工厂模式的创建目标，所有创建的对象都是充当这个角色的某个具体类的实例。

优点：
工厂类是整个模式的关键.包含了必要的逻辑判断,根据外界给定的信息,决定究竟应该创建哪个具体类的对象.通过使用工厂类,外界可以从直接创建具体产品对象的尴尬局面摆脱出来,仅仅需要负责“消费”对象就可以了。而不必管这些对象究竟如何创建及如何组织的．明确了各自的职责和权利，有利于整个软件体系结构的优化。
缺点：
	由于工厂类集中了所有实例的创建逻辑，违反了高内聚责任分配原则，将全部创建逻辑集中到了一个工厂类中；它所能创建的类只能是事先考虑到的，如果需要添加新的类，则就需要改变工厂类了。
当系统中的具体产品类不断增多时候，可能会出现要求工厂类根据不同条件创建不同实例的需求．这种对条件的判断和对具体产品类型的判断交错在一起，很难避免模块功能的蔓延，对系统的维护和扩展非常不利；
用途：
	工厂类负责创建的对象比较少；
客户只知道传入工厂类的参数，对于如何创建对象（逻辑）不关心；
由于简单工厂很容易违反高内聚责任分配原则，因此一般只在很简单的情况下应用。
经典例子：没啥好说的，这不是一个真正的设计模式

示例代码：
![ ](https://upload-images.jianshu.io/upload_images/4614633-bf1e5072b06f6e8e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![ ](https://upload-images.jianshu.io/upload_images/4614633-de439665dfc976e4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![ ](https://upload-images.jianshu.io/upload_images/4614633-df2893b69638d71b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![ 测试类：](https://upload-images.jianshu.io/upload_images/4614633-32aa3ba1badb887e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/4614633-90f7e045079acaac.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### 注意事项
有人把工厂模式分为： **简单工厂模式 ，工厂方法模式，抽象工厂模式**，所以多出一种模式，这里简单工厂模式比较简单，实际中用的的很少，只在很简单的情况下用，在这里我就不做讨论了。希望 大家也不用纠结！

> 项目地址：
>
>https://github.com/androidstarjack/YuYahao24DesignPattern

### 总结
学习一个知识点要知道**是什么，为什么,怎么办，**要知其然。也要知其所以然！
###阅读更多

[**终于，我还是下决心学Java后台了**](http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=2247486120&idx=1&sn=db5f94ad8554bd2739d962b7724033f3&chksm=eb476636dc30ef2072bacb21fa532eae3c9ab9315fac62becfd052ad990857f7d400e6584e72&scene=21#wechat_redirect)

[**来谈一下android中的MVVM**](http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=2247486115&idx=1&sn=db4acacd3ae36a3548cd579b96bcee08&chksm=eb47663ddc30ef2b4e8ac4e205490bd24724e03858924231763e53fdf306cab52dc82480b576&scene=21#wechat_redirect)

[**金9银10的面试黄金季节，分享几个重要的面试题**](http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=2247486108&idx=1&sn=b9c1a6fabd0a239b5f04db47d4d05c12&chksm=eb476602dc30ef14004f6aaae370b6c0a9092104b4e87fec80e09441e2062974429d88c05f1c&scene=21#wechat_redirect)

[**身为程序员写一百万行代码的感觉**](http://mp.weixin.qq.com/s?__biz=MzI3OTU0MzI4MQ==&mid=2247486107&idx=1&sn=5273efef7295c130af6ce1c21c630601&chksm=eb476605dc30ef134c8a7aad96cb4f113b956cf8d9212652ef2292aa2ca31df7bf51055b01f5&scene=21#wechat_redirect)

#### 相信自己，没有做不到的，只有想不到的

在这里获得的不仅仅是技术！

![ ](http://upload-images.jianshu.io/upload_images/4614633-ae570119ec82bd86?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
