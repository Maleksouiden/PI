import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DataServicesService } from '../services/data-services.service';

@Component({
  selector: 'app-reclamations',
  templateUrl: './reclamations.component.html',
  styleUrls: ['./reclamations.component.css']
})
export class ReclamationsComponent {

  form!: FormGroup;
  constructor(private formBuilder: FormBuilder, private dataServicesService:DataServicesService) {}

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      Contenu: '',
    });
  }

  submitForm(): void {
    if (this.form.valid) {
      const formData = this.form.value;
      var data = {
        "contenu_reclamation": formData["Contenu"],
        "date_reclamation":new Date(),
        "utilisateur_id_utilisateur":2
      }
      this.dataServicesService.addReclamation(data).subscribe(
        (data) => {
          console.log('Item added successfully:', data);
        }
      );
    }
  }

}
