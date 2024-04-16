import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-image-upload',
  templateUrl: './image-upload.component.html',
  styleUrls: ['./image-upload.component.css']
})
export class ImageUploadComponent {
  selectedFile: File | null = null;

  constructor(private http: HttpClient) { }

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
}
