package ismael.com.inventory.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by espino on 20/04/17.
 */

public class ProductClass implements Parcelable {

    private int id;
    private String description;

    public ProductClass(){}

    public ProductClass(int id, String description) {
        this.id = id;
        this.description = description;
    }

    protected ProductClass(Parcel in) {
        id = in.readInt();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProductClass> CREATOR = new Creator<ProductClass>() {
        @Override
        public ProductClass createFromParcel(Parcel in) {
            return new ProductClass(in);
        }

        @Override
        public ProductClass[] newArray(int size) {
            return new ProductClass[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductClass{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
