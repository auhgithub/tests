package designPartternsTes;

/**
 *  加入这样的代码使得这个类只有单个实例
 * @author fls
 * @time 2015年12月5日上午12:18:15
 */
public class SingleTonHungry {
    private static SingleTonHungry SingleTonHungry = null;

    /**
     * 单例模式的实现---饥汉模式
     * @author fls
     * @time 2015年12月5日上午12:10:44
     */
    public synchronized static SingleTonHungry getStr() {
        if (SingleTonHungry == null) {
            SingleTonHungry = new SingleTonHungry();
        }
        return SingleTonHungry;
    }

}
