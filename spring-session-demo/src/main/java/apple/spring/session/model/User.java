package apple.spring.session.model;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-04-06 20:16
 */
public class User implements Serializable {

    private static final long serialVersionUID = 962135815780832287L;

    private Long id;
    private String name;
    private String password;
    private Integer age;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
