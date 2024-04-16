import { Component } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {MatFormField, MatFormFieldModule} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect, MatSelectModule} from "@angular/material/select";
import {MatInput, MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {RetrieveAllReclamationComponent} from "../retrieve-all-reclamation/retrieve-all-reclamation.component";

@Component({
  selector: 'app-add-reclamation',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormField,
    MatOption,
    MatSelect,
    MatInput,
    MatSelectModule,
    MatButtonModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    RetrieveAllReclamationComponent
  ],
  templateUrl: './add-reclamation.component.html',
  styleUrl: './add-reclamation.component.css'
})
export class AddReclamationComponent {
  reclamationForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {
    this.reclamationForm = this.formBuilder.group({
      description: '',
      reason: '',
      status: 'submitted'
    });
  }

  onSubmit() {
    const reclamationData = this.reclamationForm.value;
    this.http.post<any>('http://localhost:8089/pi2024/reclamation/add-reclamation', reclamationData).subscribe(response => {
      console.log(response);
    });
  }
}


