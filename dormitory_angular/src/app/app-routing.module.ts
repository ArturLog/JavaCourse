import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RoomListComponent } from './room/view/room-list/room-list.component';
import { StudentListComponent } from './student/view/student-list/student-list.component';
import { RoomEditComponent } from './room/view/room-edit/room-edit.component';
import { StudentEditComponent } from './student/view/student-edit/student-edit.component';
import { RoomDetailsComponent } from './room/view/room-details/room-details.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'rooms', component: RoomListComponent },
  { path: 'rooms/add', component: RoomEditComponent },
  { path: 'rooms/:id/edit', component: RoomEditComponent },
  { path: 'rooms/:id/details', component: RoomDetailsComponent },
  { path: 'rooms/:roomId/addStudent', component: StudentEditComponent },
  {
    path: 'rooms/:roomId/students/:id/edit',
    component: StudentEditComponent,
  },
  { path: 'students', component: StudentListComponent },
  { path: 'students/add', component: StudentEditComponent },
  { path: 'students/:id/edit', component: StudentEditComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
