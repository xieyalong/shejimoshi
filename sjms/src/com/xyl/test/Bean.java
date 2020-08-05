package com.xyl.test;

import java.io.Serializable;
import java.util.List;

public class Bean implements Serializable {
    private  String key;
    private  String value;
    private String keyId;
    private String ycfl;
    private String lb;
    private String mc;
    private String efective;
    private String flag;
    private String yl;
    private List<Bean> list;
    private  int type=1;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKey() {
        if (1==getType()){
            key=getYcfl();
        }else if (2==getType()){
            key=getLb();
        }else if (3==getType()){
            key=getMc();
        }
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        if (1==getType()){
            value=getYcfl();
        }else if (2==getType()){
            value=getLb();
        }else if (3==getType()){
            value=getMc();
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Bean> getList() {
        return list;
    }

    public void setList(List<Bean> list) {
        this.list = list;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
    public String getKeyId() {
        return keyId;
    }

    public void setYcfl(String ycfl) {
        this.ycfl = ycfl;
    }
    public String getYcfl() {
        return ycfl;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }
    public String getLb() {
        return lb;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }
    public String getMc() {
        return mc;
    }

    public void setEfective(String efective) {
        this.efective = efective;
    }
    public String getEfective() {
        return efective;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    public String getFlag() {
        return flag;
    }

    public void setYl(String yl) {
        this.yl = yl;
    }
    public String getYl() {
        return yl;
    }
}
