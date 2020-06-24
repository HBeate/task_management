package at.bha;
import java.util.ArrayList;
import java.util.List;

public class TaskVO {
    private int id = 0;
    private String name;

    public TaskVO(int id, String name) {
        this.id = id;
        this.name = name;
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
}