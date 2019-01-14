package com.dot.noback;

import java.util.List;
import java.util.Map;

public interface BusinessCardDao {
    List<BusinessCard> getList(String number);

    List<BusinessCard> find(String key, String value);

    boolean insert(BusinessCard businessCard);

    boolean update(String id, String key, String value);

    boolean remove(String id);

    boolean save(String pathname);

    boolean load(String pathname);
}
