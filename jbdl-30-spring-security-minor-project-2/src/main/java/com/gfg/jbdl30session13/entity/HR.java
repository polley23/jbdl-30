package com.gfg.jbdl30session13.entity;

import com.gfg.jbdl30session13.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorColumn(name = "designation")
@DiscriminatorValue(value = "hr")
@SuperBuilder
public class HR extends Employee {
}
