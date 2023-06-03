package api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Dog {

    private int id;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<Tag> tags;
    private Category category;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id &&
                Objects.equals(name, dog.name) &&
                Objects.equals(photoUrls, dog.photoUrls) &&
                Objects.equals(tags, dog.tags) &&
                Objects.equals(category, dog.category) &&
                Objects.equals(status, dog.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, photoUrls, tags, category, status);
    }
}
