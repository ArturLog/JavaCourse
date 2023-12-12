import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainComponent } from './components/main/main.component';
import { NavComponent } from './components/nav/nav.component';
import { AppRoutingModule } from './app-routing.module';
import { RoomListComponent } from './room/view/room-list/room-list.component';
import { StudentListComponent } from './student/view/student-list/student-list.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RoomService } from './room/service/room.service';
import { RoomEditComponent } from './room/view/room-edit/room-edit.component';
import { StudentEditComponent } from './student/view/student-edit/student-edit.component';
import { RoomDetailsComponent } from './room/view/room-details/room-details.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    NavComponent,
    RoomListComponent,
    StudentListComponent,
    RoomEditComponent,
    StudentEditComponent,
    RoomDetailsComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [RoomService],
  bootstrap: [AppComponent],
})
export class AppModule {}
