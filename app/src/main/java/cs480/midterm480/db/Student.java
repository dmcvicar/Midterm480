package cs480.midterm480.db;

import java.util.ArrayList;

/**
 * Created by davidmcvicar on 3/27/15.
 */
public class Student {

    private int id;
    private String name;
    private String eid;
    private String major;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return name + " | " + eid + " | " + major + " | " + gender;
    }

}
