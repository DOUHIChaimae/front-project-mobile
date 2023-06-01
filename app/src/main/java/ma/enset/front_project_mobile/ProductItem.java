package ma.enset.front_project_mobile;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductItem implements Parcelable {
    private String name;
    private String description;
    private double price;
    private int quantity;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    private int imageResource;

    public ProductItem(String name, String description, double price, int quantity, int imageResource) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageResource = imageResource;
    }
    public ProductItem(String name, double price, int quantity, int imageResource) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageResource = imageResource;
    }

    protected ProductItem(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readDouble();
        quantity = in.readInt();
        imageResource = in.readInt();
    }

    public static final Creator<ProductItem> CREATOR = new Creator<ProductItem>() {
        @Override
        public ProductItem createFromParcel(Parcel in) {
            return new ProductItem(in);
        }

        @Override
        public ProductItem[] newArray(int size) {
            return new ProductItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getImageResource() {
        return imageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeDouble(price);
        dest.writeInt(quantity);
        dest.writeInt(imageResource);
    }
}
