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
    public static String id_user = "PLG001";
    public static String auth;
    public static String nama_user = "Budi Santoso";
    public static String no_telp = "081234567890";
    public static String alamat = "Jl. Melati No.1";
    
    public static void set_User(String id,String nama){
        AP_Data.id_user = id;
        AP_Data.nama_user = nama;
        AP_Data.auth = "admin";
    }
    
    public static void set_User(String id,String nama,String alamat,String no_telp){
        AP_Data.id_user = id;
        AP_Data.nama_user = nama;
        AP_Data.alamat = alamat;
        AP_Data.no_telp = no_telp;         
        AP_Data.auth = "customer";
    }

}
