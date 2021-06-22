package com.crm_system.springbootback.tool;

import java.util.Random;

public class NewCore {
    public String getRandom(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        Random rand=new Random();
        StringBuilder stringBuilder=new StringBuilder(4);
        for(int i=0;i<4;i++){
            char c=str.charAt(rand.nextInt(str.length()));
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
