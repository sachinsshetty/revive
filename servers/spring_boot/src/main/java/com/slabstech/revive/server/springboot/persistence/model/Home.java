package com.slabstech.revive.server.springboot.persistence.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "home")
@EntityListeners(AuditingEntityListener.class)
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "home_generator")
    @SequenceGenerator(name="home_generator", sequenceName = "home_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Address must not be blank")
    @Size(min = 4, max = 50)
    @Column(name = "address")
    String address;

    @NotBlank(message = "Photos must not be blank")
    @Size(min = 6, max = 255)
    @Column(name = "photos_url")
    String photos_url;

    @NotBlank(message = "Living Area Size must not be blank")
    @Column(name = "living_area")
    float living_area;


    @Min(value = 250, message = "Minimum Rent Price = 250")
    @Max(value = 5000, message = "Maximun Rent Prices = 5000")
    @Column(name = "rent_price")
    float rent_price;


    @Min(value = 250, message = "Minimum Rent Price = 250")
    @Max(value = 5000, message = "Maximun Rent Prices = 5000")
    @Column(name = "warm_extra_price")
    String warmExtraPrice;

    @Min(value = 0, message = "Set to 0, if disabled")
    @Max(value = 1, message = "Set to 1, if enabled")
    @Column(name = "status")
    private long status = 1;

    @Min(value = 1, message = "Set to 1, For initiation")
    @Max(value = 100)
    @Column(name = "version")
    private long version=1;



    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public float getLiving_area() {
        return living_area;
    }

    public float getRent_price() {
        return rent_price;
    }

    public String getWarmExtraPrice() {
        return warmExtraPrice;
    }
    public long getStatus() {
        return status;
    }

    public long getVersion() {
        return version;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhotos_url(String photos_url) {
        this.photos_url = photos_url;
    }

    public void setLiving_area(float living_area) {
        this.living_area = living_area;
    }

    public void setRent_price(float rent_price) {
        this.rent_price = rent_price;
    }

    public void setWarmExtraPrice(String warmExtraPrice) {
        this.warmExtraPrice = warmExtraPrice;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
