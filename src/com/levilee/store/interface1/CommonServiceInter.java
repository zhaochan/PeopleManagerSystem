package com.levilee.store.interface1;

import java.io.Serializable;

public interface CommonServiceInter {
       public boolean add(Object o);
       public boolean delete(Object o);
       public boolean update(Object o);
       public boolean get();
       public boolean get(Serializable id);
}
