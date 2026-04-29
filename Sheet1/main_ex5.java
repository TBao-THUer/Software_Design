import java.io.*;

class Developer {
    public String name;
    public float hourlyRate;
    public String degree;
    public int experienceYears;
    public String[] skills;

    Developer(String name, float hourlyRate, String degree, int experienceYears, String[] skills) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.degree = degree;
        this.experienceYears = experienceYears;
        this.skills = skills;
    }

    public void code(String task) {
        System.out.printf("I'm doing the %s\n", task);
    }

    public void attendMeeting(String IDMeeting) {
        System.out.print("I'm joining the Meeting");
    }

    public void setHourlyRate(float rate) {
        this.hourlyRate = rate;
    }

    public void setExperience(int year) {
        this.experienceYears = year;
    }

    public void addSkill(String newSkill) {
        this.skills.append(newSkill);
    }
}

public class main_ex5 {
    public static void main(String args[]) {
        
    }
}
