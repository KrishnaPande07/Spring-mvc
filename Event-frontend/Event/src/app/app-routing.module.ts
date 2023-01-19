import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateEventComponent } from './create-event/create-event.component';
import { EventListComponent } from './event-list/event-list.component';
import { UpdateEventComponent } from './update-event/update-event.component';

const routes: Routes = [
  {path : 'events',component:EventListComponent},
  {path:'create-event',component:CreateEventComponent},
{path:'',redirectTo:'events',pathMatch:'full'},
{path:'update-event/:id',component:UpdateEventComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
