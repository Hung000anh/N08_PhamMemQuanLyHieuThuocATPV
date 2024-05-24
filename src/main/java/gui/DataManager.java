package gui;

import java.util.ArrayList;

import entity.ChiTietHoaDon;



public class DataManager {

	private static String userName;
	private static String role = "QL";
	private static String rolePassword = "QLpassword";
	private static boolean loadSDTCho = false;
	private static String maNhanVien;
	private static ArrayList<ChiTietHoaDon> dsCTHDTam=new ArrayList<ChiTietHoaDon>();
	
	
	public static ArrayList<ChiTietHoaDon> getDsCTHDTam() {
		return dsCTHDTam;
	}
	public static void setDsCTHDTam(ArrayList<ChiTietHoaDon> dsCTHDTam) {
		DataManager.dsCTHDTam = dsCTHDTam;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		DataManager.userName = userName;
	}
	public static String getRole() {
		return role;
	}
	public static void setRole(String role) {
		DataManager.role = role;
	}
	public static String getRolePassword() {
		return rolePassword;
	}
	public static void setRolePassword(String rolePassword) {
		DataManager.rolePassword = rolePassword;
	}
	public static boolean isLoadSDTCho() {
		return loadSDTCho;
	}
	public static void setLoadSDTCho(boolean loadSDTCho) {
		DataManager.loadSDTCho = loadSDTCho;
	}
	public static String getMaNhanVien() {
		return maNhanVien;
	}
	public static void setMaNhanVien(String maNhanVien) {
		DataManager.maNhanVien = maNhanVien;
	}
	
	
}