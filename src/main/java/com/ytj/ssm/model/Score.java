package com.ytj.ssm.model;

import lombok.Data;

@Data
public class Score {
    private  Integer id;
    private  String chinese;
    private  String math;
    private  String english;
    private  String art;
    private  String music;
    private  String history;
    private  Integer studentId;
}
