package backend.spring.boot.springbackend.repository;

import backend.spring.boot.springbackend.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends MongoRepository<Employee, String> {
}
