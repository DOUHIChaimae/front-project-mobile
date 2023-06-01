package ma.enset.front_project_mobile;
import android.os.Parcel;
import android.os.Parcelable;

public class Feature implements Parcelable {
    private String key;
    private String value;

    public Feature(String key, String value) {
        this.key = key;
        this.value = value;
    }

    protected Feature(Parcel in) {
        key = in.readString();
        value = in.readString();
    }

    public static final Creator<Feature> CREATOR = new Creator<Feature>() {
        @Override
        public Feature createFromParcel(Parcel in) {
            return new Feature(in);
        }

        @Override
        public Feature[] newArray(int size) {
            return new Feature[size];
        }
    };

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(key);
        dest.writeString(value);
    }
}
