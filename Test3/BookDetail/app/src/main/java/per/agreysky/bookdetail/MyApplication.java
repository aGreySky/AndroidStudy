package per.agreysky.bookdetail;

import android.app.Application;

import per.agreysky.greendao.BookDao;
import per.agreysky.greendao.DaoMaster;
import per.agreysky.greendao.DaoSession;


/**
 * Created by Administrator on 2018/4/26 0026.
 */

public class MyApplication extends Application {

    private static DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();
        //数据库初始化
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "book.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        session = daoMaster.newSession();
    }

    public static BookDao getDao() {
        return session.getBookDao();
    }

}
