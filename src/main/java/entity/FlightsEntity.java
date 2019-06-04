package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flights", schema = "autobase", catalog = "")
public class FlightsEntity {
    private int id;
    private int id_order;
    private int id_driver;
    private Boolean status;

    public FlightsEntity() {
    }

    public FlightsEntity(int id_order, int id_driver, Boolean status) {
        this.id_order = id_order;
        this.id_driver = id_driver;
        this.status = status;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_order")
    public int getIdOrder() {
        return id_order;
    }

    public void setIdOrder(int id_order) {
        this.id_order = id_order;
    }

    @Basic
    @Column(name = "id_driver")
    public int getIdDriver() {
        return id_driver;
    }

    public void setIdDriver(int id_driver) {
        this.id_driver = id_driver;
    }

    @Basic
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightsEntity that = (FlightsEntity) o;
        return id == that.id &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, status);
    }
}
