import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Employee} from '../employee';
import {EmployeeService} from '../employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Observable<Employee[]>;

  constructor(private employeeService: EmployeeService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getEmployeeList();
  }

  deleteEmployee(empId: string) {
    this.employeeService.deleteEmployee(empId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
          },
        error => console.log(error));
  }

  employeeDetails(empId: string) {
    this.router.navigate(['details', empId]);
  }

}
