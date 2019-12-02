package com.tanxm.girl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Proxy(lazy = false)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内!")
    private Integer age;
}
