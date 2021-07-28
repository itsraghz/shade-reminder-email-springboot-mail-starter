package com.example.emailapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Appeal")
@Table(name = "TblAppealInfo")
public class Appeal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;

    private long beneficiaryId;

    private Date dateEntered;

    private String cause;

    private String description;

    private String status;

    private String paymentMode;

    private String accountDetails;

    private double fundsReqd;

    private double fundsRaised;

    private Date targetDate;

    private String shadeInCharge;

    private Date createdDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;

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

    public long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(String accountDetails) {
        this.accountDetails = accountDetails;
    }

    public double getFundsReqd() {
        return fundsReqd;
    }

    public void setFundsReqd(double fundsReqd) {
        this.fundsReqd = fundsReqd;
    }

    public double getFundsRaised() {
        return fundsRaised;
    }

    public void setFundsRaised(double fundsRaised) {
        this.fundsRaised = fundsRaised;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getShadeInCharge() {
        return shadeInCharge;
    }

    public void setShadeInCharge(String shadeInCharge) {
        this.shadeInCharge = shadeInCharge;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
