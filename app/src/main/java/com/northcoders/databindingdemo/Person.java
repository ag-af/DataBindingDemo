package com.northcoders.databindingdemo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Person extends BaseObservable {
    private String name;
    private Integer age;
    private String email;

    public Person(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getAge() {
        if(age==null){
            return null;
        }
        return String.valueOf(age);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAge(String age) {
        try{
            this.age = Integer.parseInt(age);
        } catch (NumberFormatException e){
            this.age = null;
        }
        notifyPropertyChanged(BR.age);
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
}
