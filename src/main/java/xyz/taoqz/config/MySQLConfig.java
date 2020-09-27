package xyz.taoqz.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
public class MySQLConfig extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
