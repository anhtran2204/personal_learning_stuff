package sample.Data;

import javafx.beans.property.SimpleStringProperty;

public class Info {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty age = new SimpleStringProperty("");
    private SimpleStringProperty height = new SimpleStringProperty("");

    public Info() {
    }

    public Info(String name, String age, String height) {
        this.name.set(name);
        this.age.set(age);
        this.height.set(height);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getHeight() {
        return height.get();
    }

    public SimpleStringProperty heightProperty() {
        return height;
    }

    public void setHeight(String height) {
        this.height.set(height);
    }

    @Override
    public String toString() {
        return "Info{" +
                "name=" + name +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
