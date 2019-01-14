package com.dot.noback;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardDaoImpl implements BusinessCardDao {
    private BusinessCardData businessCardData;

    public BusinessCardDaoImpl(){
        businessCardData = new BusinessCardData();
    }

    @Override
    public List<BusinessCard> getList(String number) {
        return null;
    }

    @Override
    public List<BusinessCard> find(String key, String value) {
        load("./busniessCard.json");
        List<BusinessCard> relist = new ArrayList<BusinessCard>();
        List<BusinessCard> list = businessCardData.getBusinessCardList();

        String keyId = null;

        for(int i = 0; i<list.size(); i++) {
            switch(key) {
                case "0" : keyId = Integer.toString(list.get(i).getId()); break;
                case "1" : keyId = list.get(i).getName(); break;
                case "2" : keyId = list.get(i).getPhone(); break;
                case "3" : keyId = list.get(i).getCorporatioName(); break;
                case "4" : keyId = ""; break;
            }
            if(keyId.contains(value)) {
                relist.add(list.get(i));
            }
        }
        return relist;
    }

    @Override
    public boolean insert(BusinessCard businessCard) {
        boolean flag = true;
        try {
            flag = true;
            businessCard.setId(businessCardData.getMaxNum());
            businessCardData.add(businessCard);
        } catch(Exception em) {
            flag = false;
            System.out.println(em);
        }
        return flag;
    }

    @Override
    public boolean update(String id, String key, String value) {
        load("./busniessCard.json");
        boolean flag = true;
        String result;
        try {
            flag = true;
            List<BusinessCard> list = businessCardData.getBusinessCardList();
            for(BusinessCard bc : list) {
                result = Integer.toString(bc.getId());
                if(result.equals(id)) {
                    if(key.equals("1")) {
                        bc.setName(value);
                    } else if(key.equals("2")) {
                        bc.setPhone(value);
                    } else {
                        bc.setCorporatioNname(value);
                    }
                    save("./busniessCard.json");
                }
            }
        } catch(Exception em) {
            flag = false;
            System.out.println(em);
        }
        return flag;
    }

    @Override
    public boolean remove(String id) {
        load("./busniessCard.json");
        boolean flag = false;
        String result;
        try {
            List<BusinessCard> list = businessCardData.getBusinessCardList();
            for(int i=0; i<list.size(); i++) {
                result = Integer.toString(list.get(i).getId());
                if(result.equals(id)) {
                    list.remove(i);
                    save("./busniessCard.json");
                }
            }
            flag = true;

        } catch(Exception em) {
            System.out.println(em);
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean save(String pathname){
        ObjectMapper objectMapper = new ObjectMapper();
        boolean flag = false;
        File file = new File(pathname);
        try {
            objectMapper.writeValue(file, businessCardData);
            flag = true;
        } catch(Exception em) {
            System.out.println(em);
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean load(String pathname) {
        ObjectMapper objectMapper = new ObjectMapper();
        boolean flag = false;
        File file = new File(pathname);
        try {
            flag = true;
            businessCardData = objectMapper.readValue(file, BusinessCardData.class);
        } catch(Exception em) {
            flag = false;
            System.out.println(em);
        }
        return flag;
    }
}
