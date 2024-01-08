package com.imran.domain;

import java.io.InputStream;

public class User extends Domain{

    private String firstName;
    private String lastName;
    private String email;
    private String loginPassword;
    private String accountNo;
    private String accountPassword;
    private InputStream photo;
    private byte[] image;
    private String base64Image;

    public User() {}

    public User(String firstName, String lastName, String email, String loginPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.loginPassword = loginPassword;
    }

    public User(String firstName,
                String lastName,
                String accountNo,
                String accountPassword,
                String base64Image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNo = accountNo;
        this.accountPassword = accountPassword;
        this.base64Image = base64Image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public InputStream getPhoto() {
        return photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
