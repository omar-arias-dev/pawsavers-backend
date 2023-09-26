package com.oad.pawsavers.common.Requestbodies;

public class DateAsStringRequestBody {

    private String datetime;

    public DateAsStringRequestBody() {
    }

    public DateAsStringRequestBody(String datetime) {
        this.datetime = datetime;
    }

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
