package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars", schema = "autobase", catalog = "")
public class CarsEntity {
    private int id;
    private String marka;
    private String type;
    private String serialNumber;
    private Integer numberOfSeats;
    private Boolean isBroke;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "marka")
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "serial_number")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "number_of_seats")
    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Basic
    @Column(name = "is_broke")
    public Boolean getIsBroke() {
        return isBroke;
    }

    public void setIsBroke(Boolean isBroke) {
        this.isBroke = isBroke;
    }


    public CarsEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarsEntity that = (CarsEntity) o;
        return id == that.id &&
                Objects.equals(marka, that.marka) &&
                Objects.equals(type, that.type) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(numberOfSeats, that.numberOfSeats) &&
                Objects.equals(isBroke, that.isBroke);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, marka, type, serialNumber, numberOfSeats, isBroke);
    }
}
