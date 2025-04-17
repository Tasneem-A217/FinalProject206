public class Job{
    private String jobID;
    private String title;
    private double salary;
    private String duty;
    

    
    public Job(String jobID, String title, double salary, String duty){
        this.jobID = jobID;
        this.title = title;
        this.salary = salary;
        this.duty = duty;
    }
    public Job(Job job) {
        this.jobID = job.getJobID();
        this.title = job.getTitle();
        this.salary = job.getSalary();
     }
     public String getJobID() { return this.jobID; }
     public String getTitle() { return this.title; }
     public double getSalary() { return this.salary; }
     public String getDuty() {return this.duty;}
  
     public void setJobID(String jobID) {
        if (jobID == null || jobID.equals("")) {
           throw new IllegalArgumentException("Job ID cannot stay empty!!");
        }    
        this.jobID = jobID;
     }
     public void setTitle(String title) {
        if (title == null || title.equals("")) {
           throw new IllegalArgumentException("Title cannot stay empty!!");
        }    
        this.title = title;
     }
     
     public void setSalary(double salary) {
        if (salary < 0.00) {
           throw new IllegalArgumentException("Salary can't be less than 0!!");
        }    
        this.salary = salary;
     }
     public void setDuty(String duty) {
        if (duty == null || duty.equals("")) {
           throw new IllegalArgumentException("Job duty cannot stay empty!!");
        }    
        this.duty = duty;
     }
     public String toString(){
        return "Job ID: " + this.getJobID() + "\n"
        + "Job Title is: " + this.getTitle() + "\n"
        + "Salary: " + this.getSalary() + "\n"
        + "Job Duty: " + this.getDuty() + "\n";
     }


}
