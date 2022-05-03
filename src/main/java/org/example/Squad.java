package org.example;

import java.util.ArrayList;

public class Squad {
    private static ArrayList<Squad> instances = new ArrayList<>();
    private String mName;
    private int mSize;
    private String mCause;
    public String mGender;

    public Squad (int size, String cause, String gender, String name){
        this.mSize = size;
        this.mCause= cause;
        this.mGender=gender;
        this.mName=name;
        this.instances.add(this);

    }
    public String getName(){
        return mName;
    }
    public int getSize(){
        return mSize;
    }
    public String getCause(){
        return mCause;
    }
    public String getGender(){
        return mGender;
    }
    public Boolean inSquad(){
        return  true;
    }

    public static ArrayList<Squad> getAll() {
        return instances;
    }

}
