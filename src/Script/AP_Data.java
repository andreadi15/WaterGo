/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Script;

/**
 *
 * @author asus
 */
public class AP_Data {
    public static String id_user;
    public static String auth;
    public static String nama_user;
    public static String no_telp;
    public static String alamat;
    
    public static void set_User(String id,String nama){
        AP_Data.id_user = id;
        AP_Data.nama_user = nama;
        AP_Data.auth = "admin";
    }
    
    public static void set_User(String id,String nama,String alamat,String no_telp){
        AP_Data.id_user = id;
        AP_Data.nama_user = nama;
        AP_Data.no_telp = no_telp;                 
        AP_Data.alamat = alamat;
        AP_Data.auth = "customer";
    }
    
    public static void update_User(String nama,String no_telp,String alamat){
        AP_Data.nama_user = nama;
        AP_Data.no_telp = no_telp;                 
        AP_Data.alamat = alamat;
        AP_Data.auth = "customer";
    }
    
    public static void reset_User(){
        AP_Data.id_user = "";
        AP_Data.nama_user = "";
        AP_Data.alamat = "";
        AP_Data.no_telp = "";         
        AP_Data.auth = "";
    }
}
