package com.gfg.jbdl30session13.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
@DiscriminatorColumn(name = "designation")
@DiscriminatorValue(value = "manager")
public class Manager extends Employee {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private List<Employee> subordinates;
}
