package mx.edu.utez.ejemplo.model;

import java.time.LocalDateTime;

public class Login {
    private long id;
    private String userName;
    private String ipAddress;
    private LocalDateTime date;


    public Login(String userName, String ipAddress) {
        this.userName = userName;
        this.ipAddress = ipAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
