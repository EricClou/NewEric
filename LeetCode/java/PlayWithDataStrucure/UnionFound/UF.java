package PlayWithDataStrucure.UnionFound;

/**
 * 并查集问题就是检查两个点是否相连问题
 * 并查集的接口有三个方法
 * 1、getSize，查看并查集内部有多少个元素
 * 2、isConnected，查看点p和点q是否链接
 * 3、unionElements，将点p和点q链接
 */
public interface UF {

    int getSize ();

    boolean isConnected ( int p, int q );

    void unionElements ( int p, int q );
}
