package by.bsu.databinding.entity;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Student extends BaseObservable implements Parcelable {

    private ObservableField<String> surname = new ObservableField<>();
    private ObservableField<String> name = new ObservableField<>();

    public Student() {}

    public ObservableField<String> getSurname() {
        return surname;
    }

    public ObservableField<String> getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(surname, student.surname) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(surname, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname=" + surname +
                ", name=" + name +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(surname.get());
        dest.writeString(name.get());
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        // распаковываем объект из Parcel
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    private Student(Parcel parcel) {
        surname.set(parcel.readString());
        name.set(parcel.readString());
    }
}
