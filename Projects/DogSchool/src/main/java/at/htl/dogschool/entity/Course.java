package at.htl.dogschool.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="S_Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private double price;
    private LocalDateTime startDatetime;
    private int noOfMeetings;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="id")
    private CourseType courseType;



    //region Constructors
    public Course() {
    }

    public Course(
            String name,
            double price,
            LocalDateTime startDatetime,
            int noOfMeetings,
            CourseType courseType) {

        this.name = name;
        this.price = price;
        this.startDatetime = startDatetime;
        this.noOfMeetings = noOfMeetings;
        this.courseType = courseType;
    }

    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoOfMeetings() {
        return noOfMeetings;
    }

    public void setNoOfMeetings(int noOfMeetings) {
        this.noOfMeetings = noOfMeetings;
    }

    public CourseType getCourseTypes() {
        return courseType;
    }

    public void setCourseTypes(CourseType courseTypes) {
        this.courseType = courseTypes;
    }

    //endregion



    @Override
    public String toString() {
        return name;
    }
}
