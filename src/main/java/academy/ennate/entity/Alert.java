package academy.ennate.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
//@NamedQueries({
//        @NamedQuery(name = "Alert.findbyPriorityAndReadings_timestamp",
//                query = "SELECT reading.vin, alert.priority, alert.message FROM emp_db.Alert alert, Reading reading " +
//                "WHERE alert.readings_vin = reading.vin AND " +
//                " alert.priority=:paramPriority AND" +
//                " reading.timestamp >= :paramTimestamp" +
//                " ORDER BY reading.timestamp ")
//        })
public class Alert {

    @Id
    private String id;

    private String message;
    private String priority;

    @OneToOne
    public Reading readings;

    public Alert(){
        this.id = UUID.randomUUID().toString();
    }

    public Alert(String message, String priority, Reading readings) {
        this.message = message;
        this.priority = priority;
        this.readings = readings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Reading getReadings() {
        return readings;
    }

    public void setReadings(Reading readings) {
        this.readings = readings;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", priority='" + priority + '\'' +
                ", readings=" + readings +
                '}';
    }
}
