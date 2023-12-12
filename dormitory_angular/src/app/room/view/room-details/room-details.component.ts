import { Component } from '@angular/core';
import { RoomService } from '../../service/room.service';
import { StudentService } from 'src/app/student/service/student.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from '../../model/room';
import { Student } from 'src/app/student/model/student';
import { Students } from 'src/app/student/model/students';

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.css'],
})
export class RoomDetailsComponent {
  constructor(
    private roomService: RoomService,
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  roomId: string = '';
  room: Room = {
    id: '',
    name: '',
    bedsNumber: 0,
  };
  students: Students = {
    students: [],
  };

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.roomId = params['id'];
    });

        this.studentService
      .getStudents()
      .subscribe((students) => (
        this.students.students = students.students.filter(student => student.room.id == this.roomId)
        ));

    if (this.roomId) {
      this.roomService.getRoom(this.roomId).subscribe(
        (room) => {
          this.room = room;
        },
        () => {
          this.router.navigate(['/rooms']);
        }
      );
    }
  }

  onDelete(studentId: string) {
    this.studentService.deleteStudent(studentId).subscribe(() => {
      this.ngOnInit();
    });
  }
}
