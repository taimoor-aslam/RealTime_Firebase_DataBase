package com.example.realtimefirebasedatabase;

import android.graphics.Bitmap;

public class MyListData {
    private String id;
    private String mName;
    private String mAge;
    private String mEmail;
    private String mPasscode;
    private String mHobbies;
    private String mGender;
    private Bitmap mPhoto;
    private byte[] bphoto;
    public MyListData(String id,String mName, String mAge, String mEmail, String mPasscode, String mHobbies, String mGender, Bitmap mPhoto)
    {
        this.id=id;
        this.mName=mName;
        this.mAge=mAge;
        this.mEmail=mEmail;
        this.mPasscode=mPasscode;
        this.mHobbies=mHobbies;
        this.mGender=mGender;
        this.mPhoto=mPhoto;

    }
    public MyListData(String id,String mName, String mAge, String mEmail, String mPasscode, String mHobbies, String mGender)
    {
        this.id=id;
        this.mName=mName;
        this.mAge=mAge;
        this.mEmail=mEmail;
        this.mPasscode=mPasscode;
        this.mHobbies=mHobbies;
        this.mGender=mGender;

    }
    public String getmName()
    {
        return mName;
    }
    public String getmAge()
    {
        return mAge;
    }
    public String getmEmail()
    {
        return mEmail;
    }
    public String getmPasscode()
    {
        return mPasscode;
    }
    public String getmHobbies()
    {
        return mHobbies;
    }
    public String getmGender()
    {
        return mGender;
    }
    public void setmPhoto(Bitmap mPhoto)
    {
        this.mPhoto=mPhoto;
    }
    public void setmName(String mName)
    {
        this.mName=mName;
    }
    public void setmAge(String mAge)
    {
        this.mAge=mAge;
    }
    public void setmEmail(String mEmail)
    {
        this.mEmail=mEmail;
    }
    public Bitmap getmPhoto()
    {
        return mPhoto;
    }
    public void setmPasscode(String mPasscode)
    {
        this.mPasscode=mPasscode;
    }
    public void setmHobbies(String mHobbies)
    {
        this.mHobbies=mHobbies;
    }
    public void setmGender(String mGender)
    {
        this.mGender=mGender;
    }

}
