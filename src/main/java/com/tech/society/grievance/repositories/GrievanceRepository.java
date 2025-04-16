package com.tech.society.grievance.repositories;

import com.tech.society.grievance.models.Grievance;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface GrievanceRepository extends MongoRepository<Grievance, String> {

    List<Grievance> findBySocietyIdAndStatus(String societyId, String status);

    Grievance findByCustomId(int customId);

    List<Grievance> findByResidentIdAndStatus(String residentId, String status);

    // Add other custom query methods as needed
}