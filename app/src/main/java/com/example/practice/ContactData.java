package com.example.practice;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ContactData implements Parcelable {
    private int Id;
    private String image;
    private String FullName;
    private String PhoneNumber;

    public ContactData(int id, String image, String fullName, String phoneNumber) {
        Id = id;
        this.image = image;
        FullName = fullName;
        PhoneNumber = phoneNumber;
    }

    protected ContactData(Parcel in) {
        Id = in.readInt();
        image = in.readString();
        FullName = in.readString();
        PhoneNumber = in.readString();
    }

    public static final Creator<ContactData> CREATOR = new Creator<ContactData>() {
        @Override
        public ContactData createFromParcel(Parcel in) {
            return new ContactData(in);
        }

        @Override
        public ContactData[] newArray(int size) {
            return new ContactData[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(image);
        dest.writeString(FullName);
        dest.writeString(PhoneNumber);
    }
}
