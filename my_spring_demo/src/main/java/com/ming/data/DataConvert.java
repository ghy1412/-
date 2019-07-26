package com.ming.data;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConvert extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(text);
            setValue(date);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
