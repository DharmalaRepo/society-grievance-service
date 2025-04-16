package com.tech.society.grievance.services;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    // Simple notification method (you can integrate email/SMS here)
    public void sendNotification(String recipient, String message) {
        // In real-world application, integrate email/SMS service
        System.out.println("Sending notification to " + recipient + ": " + message);
    }

    public void notifyGrievanceUpdate(String grievanceId, String status, String assignedTo) {
        String message = "Your grievance (ID: " + grievanceId + ") has been updated. Status: " + status + ". Assigned to: " + assignedTo;
        sendNotification(assignedTo, message); // Notify the staff member
    }
}