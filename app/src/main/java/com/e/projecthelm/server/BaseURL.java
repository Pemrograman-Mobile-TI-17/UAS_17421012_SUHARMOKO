package com.e.projecthelm.server;

public class BaseURL {

    public static String baseUrl ="http://192.168.43.7:4040/";
    public static String login = baseUrl + "user/login";
    public static String regis = baseUrl + "user/registrasi";

    //buku
    public static String dataHelm = baseUrl + "helm/datahelm";
    public static String editDatahelm = baseUrl + "helm/ubah/";
    public static String hapusData = baseUrl + "helm/hapus/";
    public static String inputhelm = baseUrl + "helm/input";
}
