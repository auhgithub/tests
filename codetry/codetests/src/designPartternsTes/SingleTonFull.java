package designPartternsTes;

/**
 * 加入这样的代码使得这个类只有单个实例
 * 单例模式之饱汉模式
 * @author fls
 * @time 2015年12月5日上午12:26:42
 */
public class SingleTonFull {
    private static final SingleTonFull SingleTonFull = new SingleTonFull();

    public static SingleTonFull getSingletonfull() {
        return SingleTonFull;
    }
}
