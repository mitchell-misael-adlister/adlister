package dao;

public class Config {
    public static String getUrl() {
        return "jdbc:mysql://studentdb.fulgentcorp.com/ymir_adlister_2?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public static String getUser() {
        return "ymir_adlister_2";
    }

    public static String getPassword() {
        return "tomato";
    }
}
