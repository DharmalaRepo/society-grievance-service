package com.tech.society.grievance.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "grievances")
public class Grievance {

    @Id
    private String id;
    private String societyId;
    private String residentId;
    private String grievanceDescription;
    private String category; // e.g., maintenance, security
    private String severity; // e.g., low, medium, high
    private String status; // e.g., Open, In Progress, Resolved
    private String assignedTo; // Staff member assigned to resolve the grievance
    private Date createdDate;
    private Date updatedDate;
    private boolean isActive; // 0 or 1 to mark if grievance is active or resolved
    private int customId; // Custom numeric ID for the grievance

    // Getters, setters, constructors, and toString()


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getResidentId() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public String getGrievanceDescription() {
        return grievanceDescription;
    }

    public void setGrievanceDescription(String grievanceDescription) {
        this.grievanceDescription = grievanceDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customId) {
        this.customId = customId;
    }
}