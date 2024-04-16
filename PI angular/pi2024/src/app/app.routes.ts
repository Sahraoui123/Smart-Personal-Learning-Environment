import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DeleteReclamationComponent} from "./delete-reclamation/delete-reclamation.component";
import {AddReclamationComponent} from "./add-reclamation/add-reclamation.component";

const routes: Routes = [
  { path: 'deleteReclamation', component: DeleteReclamationComponent },
  { path: 'AddReclamation', component: AddReclamationComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
