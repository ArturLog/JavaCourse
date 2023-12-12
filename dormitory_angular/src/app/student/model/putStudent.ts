import { Room } from 'src/app/room/model/room';
import { CreateStudent } from './createStudent';

export interface PutStudent extends CreateStudent {
  room: Room | undefined;
}
