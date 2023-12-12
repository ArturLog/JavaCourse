import { Component } from '@angular/core';
import { StudentService } from '../../service/student.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PutStudent } from '../../model/putStudent';
import { RoomService } from 'src/app/room/service/room.service';
import { Rooms } from 'src/app/room/model/rooms';
import { Room } from 'src/app/room/model/room';

@Component({
  selector: 'app-Student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.css'],
})
export class StudentEditComponent {
  constructor(
    private studentService: StudentService,
    private roomService: RoomService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  id: string = '';
  room: Room | undefined;
  avaliableRooms: Rooms = {
    rooms: [],
  };

  Student: PutStudent = {
    room: undefined,
    name: '',
    surname: '',
  };

  orginalStudent: PutStudent = {
    room: undefined,
    name: '',
    surname: '',
  };

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
      this.room = params['roomId'];
    });

    this.roomService.getRooms().subscribe((Rooms) => {
      this.avaliableRooms = Rooms;
    });

    if (this.id) {
      this.studentService.getStudent(this.id).subscribe(
        (Student) => {
          this.id = Student.id;
          this.Student = {
            room: Student.room,
            name: Student.name,
            surname: Student.surname,
          };
          this.orginalStudent = {
            room: Student.room,
            name: Student.name,
            surname: Student.surname,
          };
        },
        () => {
          this.router.navigate(['/students/add']);
        }
      );
    }

    if (this.room) {
      this.Student.room = this.room;
      this.orginalStudent.room = this.room;
    }
  }

  navigateBack() {
    if (this.room) {
      this.router.navigate(['/rooms/' + this.room + '/details']);
    } else {
      this.router.navigate(['/students']);
    }
  }

  onSubmit() {
    if (this.id) {
      this.studentService.updateStudent(this.id, this.Student).subscribe(() => {
        this.navigateBack();
      });
    } else {
      this.studentService.createStudent(this.Student).subscribe(() => {
        this.navigateBack();
      });
    }
  }
}
