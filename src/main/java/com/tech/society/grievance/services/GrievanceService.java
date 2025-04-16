package com.tech.society.grievance.services;

import com.tech.society.grievance.models.Grievance;
import com.tech.society.grievance.repositories.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GrievanceService {

    @Autowired
    private GrievanceRepository grievanceRepository;

    // Method to log a grievance
    public Grievance logGrievance(Grievance grievance) {
        grievance.setCreatedDate(new Date());
        grievance.setUpdatedDate(new Date());
        grievance.setStatus("Open"); // Default status when grievance is logged
        grievance.setActive(true);
        return grievanceRepository.save(grievance);
    }

    // Method to update a grievance status
    public Grievance updateGrievanceStatus(String grievanceId, String status, String assignedTo) {
        Grievance grievance = grievanceRepository.findById(grievanceId).orElse(null);
        if (grievance != null) {
            grievance.setStatus(status);
            grievance.setAssignedTo(assignedTo);
            grievance.setUpdatedDate(new Date());
            return grievanceRepository.save(grievance);
        }
        return null;
    }

    // Method to track a grievance by its ID
    public Grievance trackGrievance(String grievanceId) {
        return grievanceRepository.findById(grievanceId).orElse(null);
    }

    // Method to get grievances by status and societyId
    public List<Grievance> getGrievancesByStatus(String societyId, String status) {
        return grievanceRepository.findBySocietyIdAndStatus(societyId, status);
    }

    // Method to assign grievance to a staff member
    public Grievance assignGrievanceToStaff(String grievanceId, String staffId) {
        Grievance grievance = grievanceRepository.findById(grievanceId).orElse(null);
        if (grievance != null) {
            grievance.setAssignedTo(staffId);
            grievance.setUpdatedDate(new Date());
            return grievanceRepository.save(grievance);
        }
        return null;
    }

    // Method to find grievances for a resident
    public List<Grievance> getResidentGrievances(String residentId, String status) {
        return grievanceRepository.findByResidentIdAndStatus(residentId, status);
    }

    // Method to get grievance history (can be fetched using trackGrievance())
    public Grievance getGrievanceHistory(String grievanceId) {
        return trackGrievance(grievanceId);
    }
}