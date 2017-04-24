package ismael.com.inventory.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by espino on 20/04/17.
 */

public class Product implements Parcelable{

    private int id;
    private String serial,
            shortName,
            description,
            category,
            subcategory,
            productClass;

    public Product(){}

    public Product(int id, String serial, String shortName, String description, String category, String subcategory, String productClass) {
        this.id = id;
        this.serial = serial;
        this.shortName = shortName;
        this.description = description;
        this.category = category;
        this.subcategory = subcategory;
        this.productClass = productClass;
    }

    protected Product(Parcel in) {
        id = in.readInt();
        serial = in.readString();
        shortName = in.readString();
        description = in.readString();
        category = in.readString();
        subcategory = in.readString();
        productClass = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(serial);
        dest.writeString(shortName);
        dest.writeString(description);
        dest.writeString(category);
        dest.writeString(subcategory);
        dest.writeString(productClass);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", productClass='" + productClass + '\'' +
                '}';
    }
}
