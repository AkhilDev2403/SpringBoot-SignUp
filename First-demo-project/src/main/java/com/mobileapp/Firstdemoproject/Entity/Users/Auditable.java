package com.mobileapp.Firstdemoproject.Entity.Users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Auditable extends BaseEntity{

    @Column(name = "created_at", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonSerialize(using = CustomMadeDateSerializer.class)
    private Long createdDate;

    @Column(name = "updated_at", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonSerialize(using = CustomMadeDateSerializer.class)
    private Long UpdatedDate;

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        UpdatedDate = updatedDate;
    }

    public void setCreatedTime(){
        Long currentTime = System.currentTimeMillis();
        if(this.getCreatedDate() == null){
            this.setCreatedDate(currentTime);
        }
        this.setUpdatedDate(currentTime);
    }

}
