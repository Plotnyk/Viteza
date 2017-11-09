package entity;

import enums.PositionType;

import javax.persistence.*;
import java.util.Date;

/**
 Employee (Сотрудник):
 - Уникальный номер
 - Фамилия
 - Имя
 - Дата рождения
 - Дата приема на работу
 - Должность (Enum)
 - Администратор
 - Продавец
 - Кассир
 - Директор
 - Логин (в системе)
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    @SequenceGenerator(name = "employeeId", sequenceName = "EMPLOYEE_ID_SEQ", initialValue = 100, allocationSize = 3)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeId")
    private Long id;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATE_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Column(name = "DATE_EMPLOYMENT")
    @Temporal(TemporalType.DATE)
    private Date dateEmployment;

   //@Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private PositionType positionType;

    @Column(name = "USER")
    @OneToOne
    private User user;

    public Employee() {
    }

    public Employee(String surname, String name, Date dateBirth, Date dateEmployment, PositionType positionType, User user) {
        this.surname = surname;
        this.name = name;
        this.dateBirth = dateBirth;
        this.dateEmployment = dateEmployment;
        this.positionType = positionType;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Date getDateEmployment() {
        return dateEmployment;
    }

    public void setDateEmployment(Date dateEmployment) {
        this.dateEmployment = dateEmployment;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

