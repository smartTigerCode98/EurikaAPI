package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "drivers", schema = "autobase", catalog = "")
public class DriversEntity {
    private int id;
    private String name;
    private String surname;
    private int id_car;
    private Boolean isFree;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "id_car")
    public int getIdCar() {
        return id_car;
    }

    public void setIdCar(int id_car) {
        this.id_car = id_car;
    }

    @Basic
    @Column(name = "is_free")
    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriversEntity that = (DriversEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(isFree, that.isFree);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, isFree);
    }
}
