import util.HibernateUtil;

/**
 * Created by Женя on 09.11.2017.
 */
public class Test {
    public static void main(String[] args) {
        HibernateUtil.factory();

        HibernateUtil.factory().close();
    }
}
