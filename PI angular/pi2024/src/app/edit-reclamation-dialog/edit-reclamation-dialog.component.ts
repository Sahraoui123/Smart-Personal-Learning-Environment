import { Component } from '@angular/core';
import {MatFormField} from "@angular/material/form-field";
import {FormsModule} from "@angular/forms";
import {MatInput} from "@angular/material/input";
import {MatDialogActions} from "@angular/material/dialog";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-edit-reclamation-dialog',
  standalone: true,
  imports: [
    MatFormField,
    FormsModule,
    MatInput,
    MatDialogActions,
    MatButton
  ],
  templateUrl: './edit-reclamation-dialog.component.html',
  styleUrl: './edit-reclamation-dialog.component.css'
})
export class EditReclamationDialogComponent {

}
