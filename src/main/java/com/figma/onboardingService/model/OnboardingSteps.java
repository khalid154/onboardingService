package com.figma.onboardingService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : Khalid Hasan
 */
@Entity(name = "Onboarding_Steps")
@Data
@NoArgsConstructor
public class OnboardingSteps implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Header")
    private String header;

    @Column(name = "Description")
    private String description;

    @Column(name = "Image_Url")
    private String imageUrl;

    @Column(name = "Sort_Order")
    private int sortOrder;

    @Column(name = "Language_Id")
    private int languageId;
}
