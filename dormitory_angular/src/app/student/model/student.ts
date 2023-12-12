import { Room } from 'src/app/room/model/room';
import { CreateStudent } from './createStudent';

export interface Student extends CreateStudent {
  id: string;
  room: Room;
}
