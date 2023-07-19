import { Component } from '@angular/core';
import { DataServicesService } from '../services/data-services.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-anonce-details',
  templateUrl: './anonce-details.component.html',
  styleUrls: ['./anonce-details.component.css']
})
  /*details component*/
export class AnonceDetailsComponent {

  public annonceDetails : any ;
  public annonceID : any

  constructor(private dataServicesService:DataServicesService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.annonceID = this.route.snapshot.paramMap.get('id');
    this.dataServicesService.getSingleData(this.annonceID).subscribe(data => this.annonceDetails = data)
  }

}
