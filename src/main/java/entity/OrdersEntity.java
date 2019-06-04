package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Date;

@Entity
@Table(name = "orders", schema = "autobase", catalog = "")
public class OrdersEntity {
    private int id;
    private Date when;
    private String fromWhere;
    private String where_;
    private String markAuto;
    private String bodyType;
    private Integer countOfSits;
    private Boolean processed;

    @Id
    @Column(name = "id", updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "when", updatable = false)
    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    @Basic
    @Column(name = "from_where", updatable = false)
    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    @Basic
    @Column(name = "where_", updatable = false)
    public String getWhere_() {
        return where_;
    }

    public void setWhere_(String where) {
        this.where_ = where;
    }

    @Basic
    @Column(name = "mark_auto", updatable = false)
    public String getMarkAuto() {
        return markAuto;
    }

    public void setMarkAuto(String markAuto) {
        this.markAuto = markAuto;
    }

    @Basic
    @Column(name = "body_type", updatable = false)
    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Basic
    @Column(name = "count_of_sits", updatable = false)
    public Integer getCountOfSits() {
        return countOfSits;
    }

    public void setCountOfSits(Integer countOfSits) {
        this.countOfSits = countOfSits;
    }

    @Basic
    @Column(name = "processed")
    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return id == that.id &&
                Objects.equals(when, that.when) &&
                Objects.equals(fromWhere, that.fromWhere) &&
                Objects.equals(where_, that.where_) &&
                Objects.equals(markAuto, that.markAuto) &&
                Objects.equals(bodyType, that.bodyType) &&
                Objects.equals(countOfSits, that.countOfSits) &&
                Objects.equals(processed, that.processed);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, when, fromWhere, where_, markAuto, bodyType, countOfSits, processed);
    }
}
