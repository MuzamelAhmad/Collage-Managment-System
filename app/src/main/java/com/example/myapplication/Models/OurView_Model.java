package com.example.myapplication.Models;

public class OurView_Model {
    public OurView_Model() {
    }

    public int imgView,profileImg;
    public String P_name,P_email,Exp , Educ,Org;
    public OurView_Model(int imgView, int profileImg, String p_name, String p_email, String exp, String educ, String org) {
        this.imgView = imgView;
        this.profileImg = profileImg;
        P_name = p_name;
        P_email = p_email;
        Exp = exp;
        Educ = educ;
        Org = org;
    }

    public OurView_Model(String p_name, String p_email, String exp, String educ, String org) {
        P_name = p_name;
        P_email = p_email;
        Exp = exp;
        Educ = educ;
        Org = org;
    }

    public int getImgView() {
        return imgView;
    }

    public void setImgView(int imgView) {
        this.imgView = imgView;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public String getP_name() {
        return P_name;
    }

    public void setP_name(String p_name) {
        P_name = p_name;
    }

    public String getP_email() {
        return P_email;
    }

    public void setP_email(String p_email) {
        P_email = p_email;
    }

    public String getExp() {
        return Exp;
    }

    public void setExp(String exp) {
        Exp = exp;
    }

    public String getEduc() {
        return Educ;
    }

    public void setEduc(String educ) {
        Educ = educ;
    }

    public String getOrg() {
        return Org;
    }

    public void setOrg(String org) {
        Org = org;
    }
}
