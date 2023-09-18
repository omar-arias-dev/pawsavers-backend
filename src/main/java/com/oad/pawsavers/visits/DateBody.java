package com.oad.pawsavers.visits;

public class DateBody {

    private String datetime;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "DateBody{" +
                "datetime='" + datetime + '\'' +
                '}';
    }
}
