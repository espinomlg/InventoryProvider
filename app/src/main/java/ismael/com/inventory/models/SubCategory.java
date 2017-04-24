package ismael.com.inventory.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by espino on 20/04/17.
 */

public class SubCategory implements Parcelable {

    private int id;
    private String name,
        sortname,
        description;

    public SubCategory(){}

    public SubCategory(int id, String name, String sortname, String description) {
        this.id = id;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
    }

    protected SubCategory(Parcel in) {
        id = in.readInt();
        name = in.readString();
        sortname = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(sortname);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SubCategory> CREATOR = new Creator<SubCategory>() {
        @Override
        public SubCategory createFromParcel(Parcel in) {
            return new SubCategory(in);
        }

        @Override
        public SubCategory[] newArray(int size) {
            return new SubCategory[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sortname='" + sortname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
