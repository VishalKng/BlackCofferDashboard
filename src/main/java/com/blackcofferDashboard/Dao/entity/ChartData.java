package com.blackcofferDashboard.Dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


@Getter
@Setter
@Entity
public class ChartData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "endYear")
    private String endYear;

    @Column(name = "citylng")
    private Double citylng;

    @Column(name = "citylat")
    private Double citylat;

    @Column(name = "intensity")
    private Integer intensity;

    @Column(name = "topic")
    private String topic;

    @Column(name = "region")
    private String region;

    @Column(name = "start_year")
    private String start_year;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;


    @Column(name = "pestle")
    private String pestle;


    @Column(name = "likelihood")
    private Integer likelihood;

    @Column(name = "impact")
    private Integer impact;

    @Column(name = "source")
    private String source;

    @Column(name = "relevance")
    private Integer relevance;

}
