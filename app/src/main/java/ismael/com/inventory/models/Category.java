package ismael.com.inventory.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by espino on 20/04/17.
 */

public class Category implements Parcelable{

    private int id;
    private String name,
        sortname,
        description;

    public Category() {

    }

    public Category(int id, String name, String sortname, String description) {
        this.id = id;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
    }

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
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sortname='" + sortname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
