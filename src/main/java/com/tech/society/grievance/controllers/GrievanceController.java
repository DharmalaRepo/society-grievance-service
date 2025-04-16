package com.tech.society.grievance.controllers;

import com.tech.society.grievance.models.Grievance;
import com.tech.society.grievance.services.GrievanceService;
import com.tech.society.grievance.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    @Autowired
    private GrievanceService grievanceService;

    @Autowired
    private NotificationService notificationService;

    // Endpoint to log a grievance
    @PostMapping("/log")
    public Grievance logGrievance(@RequestBody Grievance grievance) {
        Grievance loggedGrievance = grievanceService.logGrievance(grievance);
        notificationService.notifyGrievanceUpdate(loggedGrievance.getId(), loggedGrievance.getStatus(), loggedGrievance.getAssignedTo());
        return loggedGrievance;
    }

    // Endpoint to update the grievance status
    @PutMapping("/update/{grievanceId}")
    public Grievance updateGrievanceStatus(@PathVariable String grievanceId, @RequestParam String status, @RequestParam String assignedTo) {
        Grievance updatedGrievance = grievanceService.updateGrievanceStatus(grievanceId, status, assignedTo);
        notificationService.notifyGrievanceUpdate(grievanceId, status, assignedTo);
        return updatedGrievance;
    }

    // Endpoint to track a grievance by ID
    @GetMapping("/{grievanceId}")
    public Grievance trackGrievance(@PathVariable String grievanceId) {
        return grievanceService.trackGrievance(grievanceId);
    }

    // Endpoint to get grievances by status and societyId
    @GetMapping("/status")
    public List<Grievance> getGrievancesByStatus(@RequestParam String societyId, @RequestParam String status) {
        return grievanceService.getGrievancesByStatus(societyId, status);
    }

    // Endpoint to assign a grievance to a staff member
    @PutMapping("/assign/{grievanceId}")
    public Grievance assignGrievance(@PathVariable String grievanceId, @RequestParam String staffId) {
        return grievanceService.assignGrievanceToStaff(grievanceId, staffId);
    }

    // Endpoint to get grievances for a resident
    @GetMapping("/resident")
    public List<Grievance> getResidentGrievances(@RequestParam String residentId, @RequestParam String status) {
        return grievanceService.getResidentGrievances(residentId, status);
    }
}