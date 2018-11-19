package ro.lorenaApps.partTimeJob.repository;

import org.springframework.data.repository.Repository;
import ro.lorenaApps.partTimeJob.model.Job;

public interface JobRepository extends Repository<Job, Long> {
}
