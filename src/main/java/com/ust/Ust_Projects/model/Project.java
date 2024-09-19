package com.ust.Ust_Projects.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {
    @Id
    private int projectId;
    private String projectName;
    private String projectDescription;
    private String projectLink;
    private String psNumber;
    private String username;
    @Enumerated(value= EnumType.STRING)
    private ProjectStatus projectStatus;


}
