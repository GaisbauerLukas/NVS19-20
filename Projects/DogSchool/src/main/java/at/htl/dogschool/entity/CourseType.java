package at.htl.dogschool.entity;

import javax.persistence.*;

/**
 * abbreviation:
 * - bg1 ... Begleithunde1
 * - bg2 ... Begleithunde2
 * - w ... Welpenkurs
 */

@Entity
@Table(name="S_Course_Type")
public class CourseType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String abbr; // abbreviation

    //region Constructors
    public CourseType() {
    }

    public CourseType(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
    }

//endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%s (%s)", name, abbr);
    }
}