package at.htl.dogschool.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="S_Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="id")
    private List<Course> courses;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="id")
    private List<Dog> dogs;

    private LocalDate bookingDate;
    private double price;

    //region Constructor
    public Booking() {
    }

    public Booking(List<Course> course, List<Dog> dog, LocalDate bookingDate, double price) {
        this.courses = course;
        this.dogs = dog;
        this.bookingDate = bookingDate;
        this.price = price;
    }
    //endregion


    //region Getter and Setter
    public Long getId() {
        return id;
    }


    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Course> getCourse() {
        return courses;
    }

    public void setCourse(List<Course> course) {
        this.courses = course;
    }

    public List<Dog> getDog() {
        return dogs;
    }

    public void setDog(List<Dog> dog) {
        this.dogs = dog;
    }

    //endregion


//    @Override
//    public String toString() {
//        return String.format("Buchung: %s mit %s (%s %s)",
//                course.getName(),
//                dog.getName(),
//                dog.getOwner().getFirstName(),
//                dog.getOwner().getLastName());
//    }
}
