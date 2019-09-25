package model;

import model.Employer;

//import java.lang.reflect.Array;
import java.util.*;

public class Service {
 private int id;
 private String lib;

    public List<Employer> getEmployers() {
        return Employers;
    }

    public void setEmployers(Employer e) {
        List<Employer> employers =new ArrayList<Employer>();
        employers.add(e);
        Employers = employers;
    }

    private List<Employer> Employers=new ArrayList<Employer>() ;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }
 public String getLib() {
  return lib;
 }

 public void setLib(String lib) {
  this.lib = lib;
 }

}
