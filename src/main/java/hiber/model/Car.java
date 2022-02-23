package hiber.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@ToString
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "car_model")
    private String model;
    @Column(name = "car_series")
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}

