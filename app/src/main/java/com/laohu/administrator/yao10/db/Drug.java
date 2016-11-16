package com.laohu.administrator.yao10.db;

/**
 * Created by Administrator on 2016/9/23.
 */

public class Drug {
    private  int id;
    private String drugName;
    private String drugCode;
    private  int drugsubclassId;

    public int getId(){return id;}
    public void  setId(int id){this.id=id;}

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public int getDrugsubclassId() {
        return drugsubclassId;
    }

    public void setDrugsubclassId(int drugsubclassId) {
        this.drugsubclassId = drugsubclassId;
    }
}
