package at.htl.dogschool.control;

import at.htl.dogschool.entity.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.ws.rs.ApplicationPath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

@ApplicationScoped
@Transactional
public class InitBean {

    private final String FILE_NAME = "META-INF/courses.csv";

    @PersistenceContext
    EntityManager em;

    @Inject
    CourseTypeRepository courseTypeRepository;

    private void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        initDb();
        //createBookings();
        readCsv();
    }


    /**
     * Ändern Sie den Inhalt dieser Methode NICHT
     */
    private void initDb() {

        Person matt = new Person("Matt", "Murdock");
        Person mathilda = new Person("Mathilda", "Lando");

        em.persist(new Dog("Timmy", matt));
        em.persist(new Dog("Tino", matt));
        em.persist(new Dog("Arko", mathilda));
        em.persist(new Dog("Rex", mathilda));
        em.persist(new Dog("Edi", mathilda));

        CourseType welpenkurs = new CourseType("Welpenkurs", "w");
        CourseType begleithunde1 = new CourseType("Begleithunde1", "bg1");
        CourseType begleithunde2 = new CourseType("Begleithunde2", "bg2");
        em.persist(welpenkurs);
        em.persist(begleithunde1);
        em.persist(begleithunde2);

        readCsv();

    }

    /**
     * Einlesen des csv-Files und speichern in der DB.
     * Das Course-Objekt wird unter Verwendung der Methode parseCourse(...) erstellt,
     * und anschließend in dieser Methode persistiert
     *
     * ACHTUNG: Doppelte Kurse dürfen nicht eingelesen werden
     *          (dh name, startdatetime, price und no_of_days sind gleich)
     */
    private void readCsv() {

        new BufferedReader(new InputStreamReader(this.getClass()
                .getResourceAsStream(FILE_NAME), Charset.defaultCharset()))
                .lines()
                .skip(1)
                .map(s -> s.split(";"))
                .map(a -> parseCourse(a))
                .distinct()
                .forEach(em::merge);
    }

    /**
     * parse one line of the csv-file and create a course-object
     *
     * we are using ISO-8601 for the datetime-field
     *
     * Use for getteing the coursetype a named-jpa-query
     *
     * @param elems
     * @return the new Course-object
     */


    private Course parseCourse(String[] elems) {

        return new Course(
                elems[4],
                Double.valueOf(elems[2]),
                LocalDateTime.parse(elems[1]),
                Integer.valueOf(elems[3]),
                em.createNamedQuery("CourseType.GetCourseByName",CourseType.class)
                        .setParameter("NAME",elems[0])
                        .getSingleResult());
    }

}
