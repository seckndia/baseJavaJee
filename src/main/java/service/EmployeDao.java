package service;

import model.Employer;
import model.Service;
import model.User;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeDao {
    public List<Service> findServices(){
        List<Service> services = new ArrayList<>();
        try{
            String sql = "SELECT * FROM Service";
            DatabaseHelper db = DatabaseHelper.getInstance();
            ResultSet rs = db.My_ExecuteQuery(sql);
            while (rs.next()){
                Service s = new Service();
                s.setId(rs.getInt(1));
                s.setLib(rs.getString(2));
                services.add(s);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return services;
    }

    public void addEmploye(Employer e) throws Exception{

        try{
            String sql = "INSERT INTO Employe values (null,?,?,?,?,?,?)";
            DatabaseHelper db = DatabaseHelper.getInstance();
            db.iniPreparedCmd(sql);
            db.getPstmt().setString(1,e.getMat());
            db.getPstmt().setString(2,e.getNom());
            db.getPstmt().setString(3,e.getTelephone());
            db.getPstmt().setString(4,e.getDateNaissance().toString());
            db.getPstmt().setInt(5,e.getSalaire());
            db.getPstmt().setInt(6,e.getService().getId());

            db.My_ExecutePrepareUpdate();

        }catch (Exception ex){
            //ex.printStackTrace();
            throw ex;
        }
    }
    public List<Employer> findEmployes(){
        List<Employer> employes = new ArrayList<>();
        try {
            String sql= "SELECT * FROM Employe e,Service s WHERE e.ServiceId=s.ServiceId";
            DatabaseHelper db = DatabaseHelper.getInstance();
            ResultSet rs = db.My_ExecuteQuery(sql);
            DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");
            while (rs.next()){
                Employer em = new Employer();
                em.setId(rs.getInt(1));
                em.setMat(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTelephone(rs.getString(4));
                em.setDateNaissance(LocalDate.parse(rs.getString(5),df));
                em.setSalaire(rs.getInt(6));
                Service s = new Service();
                s.setId(rs.getInt(8));
                s.setLib(rs.getString(9));
                em.setService(s);
                employes.add(em);
            }
            rs.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return employes;

    }
}
