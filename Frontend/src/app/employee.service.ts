import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8082/emp-api/employees';

  constructor(private http: HttpClient) {}

  getEmployee(empId: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${empId}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, employee);
  }

  updateEmployee(empId: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${empId}`, value);
  }

  deleteEmployee(empId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${empId}`,{responseType: 'text'});
  }

  getEmployeeList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
