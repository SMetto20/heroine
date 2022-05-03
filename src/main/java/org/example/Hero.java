package org.example;

public class Hero {
    private String name;
    private int height;
    private String power;
    private int age;
    private String weakness;
    public Hero(String name, int height, String power, int age,String weakness){
        this.name = name;
        this.height= height;
        this.power= power;
        this.age = age;
        this.weakness=weakness;
    }
    public String getName(){
        return name;}
    public int getHeight(){
        return height;}
    public String getPower(){
        return power;}
    public int getAge(){
        return age;}
    public String getWeakness(){ return weakness;}

}
