import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Rooms } from '../model/rooms';
import { Room } from '../model/room';
import { CreateRoom } from '../model/createRoom';
import {v4 as uuidv4} from "uuid";


@Injectable()
export class RoomService {
  constructor(private http: HttpClient) {}

  getRooms() {
    return this.http.get<Rooms>('/api/rooms');
  }
 
  getRoom(id: string) {
    return this.http.get<Room>('/api/rooms/' + id);
  }

  createRoom(Room: CreateRoom) {
    const id = uuidv4();
    return this.http.put('/api/rooms/' + id, Room);
  }

  updateRoom(id: string, Room: CreateRoom) {
    return this.http.put('/api/rooms/' + id, Room);
  }

  deleteRoom(id: string) {
    return this.http.delete('/api/rooms/' + id);
  }
}
