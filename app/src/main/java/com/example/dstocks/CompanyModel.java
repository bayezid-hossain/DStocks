package com.example.dstocks;

import android.os.Parcel;
import android.os.Parcelable;

public class CompanyModel implements Parcelable {
    private String code;
    private String name;
    private double ltp;
    private double change;
    private double changeP;
    private double closep;
    private double high;
    private double low;
    private double ycp;
    private double trade;
    private double value;
    private boolean isFav=false;

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }

    private double volume;
    CompanyModel(String code, double ltp, double change, double changeP){
        this.code=code;
        this.ltp=ltp;
        this.change=change;
        this.changeP=changeP;
    }

    public double getClosep() {
        return closep;
    }

    public double getVolume() {
        return volume;
    }

    CompanyModel(String name,String code, double ltp, double high, double low, double closep, double ycp, double change, double changeP, double trade, double value, double volume){
        this.name=name;
        this.code=code;
        this.ltp=ltp;
        this.change=change;
        this.changeP=changeP;
        this.high=high;
        this.low=low;
        this.ycp=ycp;
        this.trade=trade;
        this.value=value;
        this.closep=closep;
        this.volume=volume;
    }
    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int arg1) {
        // TODO Auto-generated method stub
        dest.writeString(code);
        dest.writeString(name);
        dest.writeDouble(ltp);
        dest.writeDouble(change);
        dest.writeDouble(changeP);
        dest.writeDouble(high);
        dest.writeDouble(low);
        dest.writeDouble(ycp);
        dest.writeDouble(trade);
        dest.writeDouble(value);
        dest.writeDouble(closep);
        dest.writeDouble(volume);
        dest.writeInt(isFav ? 1 : 0);
    }
    public CompanyModel(Parcel in) {
        code = in.readString();
        name = in.readString();
        ltp=in.readDouble();
        change=in.readDouble();
        changeP=in.readDouble();
        high=in.readDouble();
        ltp=in.readDouble();
        ycp=in.readDouble();
        trade=in.readDouble();
        value=in.readDouble();
        closep=in.readDouble();
        volume=in.readDouble();
        isFav=(in.readInt() != 0);
    }

    public static final Creator<CompanyModel> CREATOR = new Creator<CompanyModel>() {
        public CompanyModel createFromParcel(Parcel in) {
            return new CompanyModel(in);
        }

        public CompanyModel[] newArray(int size) {
            return new CompanyModel[size];
        }
    };
    public String getName() {
        return name;
    }

    public Double getLtp() {
        return ltp;
    }

    public Double getChange() {
        return change;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getYcp() {
        return ycp;
    }

    public double getTrade() {
        return trade;
    }

    public double getValue() {
        return value;
    }

    public Double getChangeP() {
        return changeP;
    }

    public String getCode() {
        return code;
    }
    public void setName(String name) {
        this.name=name;
    }
}