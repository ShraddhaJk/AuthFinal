package com.example.auth;

public class Profile {
    private String name;
    private String email;
    private String desc;

    private String location;
    private String profilePic;
    private boolean permission;

    public Profile() {
    }

    public Profile(String name, String email, String desc,String location) {
        this.name = name;
        this.email = email;
        this.desc = desc;
        this.location = location;
        //this.profilePic = profilePic;
      //  this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    /*

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }


    public boolean getPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
    */
}
