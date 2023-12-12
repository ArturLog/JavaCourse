import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Students } from '../model/students';
import { Student } from '../model/student';
import { CreateStudent } from '../model/createStudent';
import {v4 as uuidv4} from "uuid";

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  constructor(private http: HttpClient) {}

  getStudents() {
    return this.http.get<Students>('/api/students');
  }

  getStudent(id: string) {
    return this.http.get<Student>('/api/students/' + id);
  }

  createStudent(Student: CreateStudent) {
    const id = uuidv4();
    return this.http.put('/api/students/' + id, Student);
  }

  updateStudent(id: string, Student: CreateStudent) {
    return this.http.put('/api/students/' + id, Student);
  }

  deleteStudent(id: string) {
    return this.http.delete('/api/students/' + id);
  }
}
