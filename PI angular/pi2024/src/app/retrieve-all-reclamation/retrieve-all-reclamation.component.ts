import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {
  MatCell, MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef, MatRow,
  MatRowDef,
  MatTable
} from "@angular/material/table";
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-retrieve-all-reclamation',
  standalone: true,
  imports: [
    MatTable,
    MatHeaderRowDef,
    MatRowDef,
    MatHeaderCell,
    MatCell,
    MatColumnDef,
    MatHeaderRow,
    MatRow,
    MatHeaderCellDef,
    MatCellDef,
    MatIcon,
    MatIconButton,
    FormsModule
  ],
  templateUrl: './retrieve-all-reclamation.component.html',
  styleUrl: './retrieve-all-reclamation.component.css'
})
export class RetrieveAllReclamationComponent {
  selectedFile: File | null = null;
  reclamations: any[] = [];
  displayedColumns: string[] = ['reclamationId', 'description', 'reason', 'status', 'dateSubmitted', 'dateUpdated', 'delete', 'update'];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getReclamations();
  }
  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0];
  }

  onUpload(): void {
    if (this.selectedFile) {
      const formData = new FormData();
      formData.append('image', this.selectedFile);

      this.http.post<any>('http://localhost:8089/pi2024/reclamation/upload-image', formData).subscribe(
        response => {
          console.log('File uploaded successfully:', response);
          // Handle success message or further actions
        },
        error => {
          console.error('Error uploading file:', error);
          // Handle error message or error handling logic
        }
      );
    }
  }

  getReclamations(): void {
    this.http.get<any[]>('http://localhost:8089/pi2024/reclamation/retrieve-all-reclamations')
      .subscribe(
        reclamations => {
          this.reclamations = reclamations;
        },
        error => {
          console.log('Error fetching reclamations:', error);
        }
      );
  }
  deleteReclamation(reclamationId: number): void {
    this.http.delete(`http://localhost:8089/pi2024/reclamation/remove-reclamation/${reclamationId}`)
      .subscribe(
        () => {
          this.reclamations = this.reclamations.filter(reclamation => reclamation.reclamationId !== reclamationId);
        },
        error => {
          console.log('Error deleting reclamation:', error);
        }
      );
  }
  toggleUpdate(reclamation: any): void {
    reclamation.isUpdating = !reclamation.isUpdating;
    if (!reclamation.isUpdating) {
      this.getReclamations();
    }
  }

  updateReclamation(reclamation: any): void {
    this.http.put<any>('http://localhost:8089/pi2024/reclamation/modify-reclamation', reclamation)
      .subscribe(
        updatedReclamation => {
          // Find and replace the updated reclamation in the list
          const index = this.reclamations.findIndex(r => r.reclamationId === updatedReclamation.reclamationId);
          if (index !== -1) {
            this.reclamations[index] = updatedReclamation;
          }
          // Toggle back to view mode
          this.toggleUpdate(reclamation);
        },
        error => {
          console.error('Error updating reclamation:', error);
        }
      );
  }

}
