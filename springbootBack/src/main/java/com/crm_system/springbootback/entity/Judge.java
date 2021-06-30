package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value="judge")
public class Judge {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private int working_ability;
    private int working_attitude;
    private int environmental_behavior;
    private int discipline;
    private int bonus_point;
    private int deduct_point;
    private String judge_time= String.valueOf(new Date());
    private String judgePeople;
    private String judgedPeople;
    private double performance;

    public Judge() {
    }

    public Judge(int working_ability, int working_attitude, int environmental_behavior, int discipline, int bonus_point, int deduct_point, String judge_people, String judged_people) {
        this.working_ability = working_ability;
        this.working_attitude = working_attitude;
        this.environmental_behavior = environmental_behavior;
        this.discipline = discipline;
        this.bonus_point = bonus_point;
        this.deduct_point = deduct_point;
        this.judgePeople = judge_people;
        this.judgedPeople = judged_people;

    }

    public Judge(Integer id, int working_ability, int working_attitude, int environmental_behavior, int discipline, int bonus_point, int deduct_point, Date judge_time, String judge_people, String judged_people,double performance) {
        this.id = id;
        this.working_ability = working_ability;
        this.working_attitude = working_attitude;
        this.environmental_behavior = environmental_behavior;
        this.discipline = discipline;
        this.bonus_point = bonus_point;
        this.deduct_point = deduct_point;
        this.judge_time= String.valueOf(judge_time);
        this.judgePeople = judge_people;
        this.judgedPeople = judged_people;
        this.performance=performance;
    }
}
