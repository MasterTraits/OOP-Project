package com.projectoop.serverbackend;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Employee getEmployee(ObjectId id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(String first_name, String last_name, String contact, String email,
            String employment_type, String job_title, String dateString, String payType, String uniqueId ,String id) {
        Employee TheEmployee = employeeRepository.insert(
                new Employee(first_name, last_name, contact, email, employment_type, job_title, dateString, payType, uniqueId));

        mongoTemplate.update(User.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().push("employees").value(TheEmployee))
                .first();

        return TheEmployee;
    }

    public Employee updateEmployee(ObjectId id, String first_name, String last_name, String contact, String email,
        String employment_type, String job_title, String dateString, String payType) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update()
            .set("first_name", first_name)
            .set("last_name", last_name)
            .set("contact", contact)
            .set("email", email)
            .set("employment_type", employment_type)
            .set("job_title", job_title)
            .set("dateString", dateString)
            .set("payType", payType);

        mongoTemplate.updateFirst(query, update, Employee.class);
        return mongoTemplate.findOne(query, Employee.class);
    }

    public void deleteEmployee(ObjectId id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query, Employee.class);
    }

    // public Employee createChat(String message , ObjectId id) {
    // Employee chat = new Employee(message);
    // }
}
