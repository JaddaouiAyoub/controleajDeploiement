package test.test.entity;


import jakarta.persistence.*;
import lombok.Data;
import test.test.Post;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;

    @ElementCollection
    @CollectionTable(name = "Employee_Skills", joinColumns = @JoinColumn(name = "employee_id"))
    private List<String> skills;

    @Enumerated(EnumType.STRING)
    private Post post;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeProjectAssignment> projectAssignments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return this.skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<String> getProjectAssignments() {
        return projectAssignments.stream()
                .map(assignment -> assignment.getProject().getName() + "(" + assignment.getImplecation() + ")")
                .collect(Collectors.toList());
    }

    public void setProjectAssignments(List<EmployeeProjectAssignment> projectAssignments) {
        this.projectAssignments = projectAssignments;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", skills=" + skills +
                ", post=" + post +
                '}';
    }
}
