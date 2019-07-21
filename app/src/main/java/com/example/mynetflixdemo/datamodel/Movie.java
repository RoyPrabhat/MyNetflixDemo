package com.example.mynetflixdemo.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.mynetflixdemo.R;

public class Movie implements Parcelable {
    private String name;
    private int image;
    private String description;

    public static int[] movieImageList = new int[]{R.drawable.movie_1,
            R.drawable.movie_2,
            R.drawable.movie_3,
            R.drawable.movie_4,
            R.drawable.movie_5,
            R.drawable.movie_6,
            R.drawable.movie_7,
            R.drawable.movie_8,
            R.drawable.movie_9,
            R.drawable.movie_10};
    public static String[] movieNameList = new String[]{"One","Two" ,"Three","Four","Five","Six","Seven" ,"Eight","Nine","Ten"
    };

    public Movie(Parcel in) {
        readFromParcel(in);
    }

    public Movie() {
    }

    public Movie(String name, int image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Object[] newArray(int i) {
            return new Object[0];
        }
    };

    private void readFromParcel(Parcel in) {
        name = in.readString();
        image = in.readInt();
        description = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
        dest.writeInt(image);
        dest.writeString(description);
    }
}
