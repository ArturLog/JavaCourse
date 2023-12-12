import { Component } from '@angular/core';
import { RoomService } from '../../service/room.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CreateRoom } from '../../model/createRoom';

@Component({
  selector: 'app-room-edit',
  templateUrl: './room-edit.component.html',
  styleUrls: ['./room-edit.component.css'],
})
export class RoomEditComponent {
  constructor(
    private roomService: RoomService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  id: string = '';

  room: CreateRoom = {
    name: '',
    bedsNumber: 0,
  };

  orginalRoom: CreateRoom = {
    name: '',
    bedsNumber: 0,
  };

  ngOnInit() {
    this.route.params.subscribe((params) => {
      this.id = params['id'];
    });

    if (this.id) {
      this.roomService.getRoom(this.id).subscribe(
        (room) => {
          this.id = room.id;
          this.room = room;
          this.orginalRoom = { ...this.room };
        },
        () => {
          this.router.navigate(['/rooms/add']);
        }
      );
    }
  }

  onSubmit() {
    if (this.id) {
      this.roomService
        .updateRoom(this.id, this.room)
        .subscribe(() => {
          this.router.navigate(['/rooms', this.id, 'details']);
        });
    } else {
      this.roomService.createRoom(this.room).subscribe(() => {
        this.router.navigate(['/rooms']);
      });
    }
  }
}
