package com.nike.runclubreport.mapper;

import org.skife.jdbi.v2.SQLStatement;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.Binder;

/**
 * Created by bing.du on 4/23/14.
 */
public class EnumBinder<T extends Enum<T>> implements Binder<Bind, T> {
    @Override
    public void bind(SQLStatement<?> sqlStatement, Bind bind, T t) {
        sqlStatement.bind(bind.value(), t.toString());
    }
}