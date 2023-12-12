import { Component } from '@angular/core';
import { RoomService } from '../../service/room.service';
import { Rooms } from '../../model/rooms';

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css'],
})
export class RoomListComponent {
  constructor(private roomService: RoomService) {}

  rooms: Rooms | undefined;

  ngOnInit(): void {
    this.roomService
      .getRooms()
      .subscribe((rooms) => (this.rooms = rooms));
  }

  onDelete(id: string) {
    this.roomService.deleteRoom(id).subscribe(() => this.ngOnInit());
  }
}
