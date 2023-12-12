import { Component } from '@angular/core';
import { StudentService } from '../../service/student.service';
import { Students } from '../../model/students';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
})
export class StudentListComponent {
  constructor(private studentService: StudentService) {}

  students: Students | undefined;

  ngOnInit(): void {
    this.studentService
      .getStudents()
      .subscribe((students) => (
        this.students = students
        ));
  }

  onDelete(id: string) {
    this.studentService.deleteStudent(id).subscribe(() => this.ngOnInit());
  }
}
