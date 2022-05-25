package com.priyanka.atmapplication;

public class model {
    String total;
    String _100rs;

    public model(String amtEntered, String _100rs, String _200rs, String _500rs, String _2000rs) {
        this.total = amtEntered;
        this._100rs = _100rs;
        this._200rs = _200rs;
        this._500rs = _500rs;
        this._2000rs = _2000rs;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String get_100rs() {
        return _100rs;
    }

    public void set_100rs(String _100rs) {
        this._100rs = _100rs;
    }

    public String get_200rs() {
        return _200rs;
    }

    public void set_200rs(String _200rs) {
        this._200rs = _200rs;
    }

    public String get_500rs() {
        return _500rs;
    }

    public void set_500rs(String _500rs) {
        this._500rs = _500rs;
    }

    public String get_2000rs() {
        return _2000rs;
    }

    public void set_2000rs(String _2000rs) {
        this._2000rs = _2000rs;
    }

    String _200rs;
    String _500rs;
    String _2000rs;
}
