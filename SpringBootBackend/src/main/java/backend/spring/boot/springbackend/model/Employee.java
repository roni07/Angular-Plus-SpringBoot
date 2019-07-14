package backend.spring.boot.springbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "employees")
public class Employee {
    @Id
    private String empId;
    private String fName;
    private String lName;
    private String email;
}
