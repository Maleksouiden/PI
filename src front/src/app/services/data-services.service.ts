import { Annonce } from './../models/Annonce';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Reclamation } from '../models/Reclamation';

@Injectable({
  providedIn: 'root',
})
export class DataServicesService {
  router: any;
  constructor(private http: HttpClient) {}

  getAnnoncesData() {
    return this.http.get('http://localhost:3030/SpringMVC/annonces');
  }
  getUser() {
    return this.http.get('http://localhost:3030/SpringMVC/utilisateurs');
  }
  getUserco(id: number) {
    const url = 'http://localhost:3030/SpringMVC/utilisateurs/connect';
    // Remplacez par l'id de l'utilisateur connecté

    const headers = new HttpHeaders({
      'Content-Type': 'application/json', // Définition du type de contenu en tant que JSON
    });

    this.http.post(url, id, { headers }).subscribe(
      (response) => {
        console.log('Réponse du serveur:', response);
      },
      (error) => {
        console.error('Erreur lors de la requête:', error);
      }
    );
  }

  getSingleData(id: number) {
    return this.http.get('http://localhost:3030/SpringMVC/annonces/' + id);
  }

  addAnnonce(annonce: Annonce) {
    return this.http.post('http://localhost:3030/SpringMVC/annonces', annonce);
  }

  deleteAnnonce(id: number) {
    return this.http.delete('http://localhost:3030/SpringMVC/annonces/' + id);
  }

  addReclamation(reclamation: Reclamation) {
    return this.http.post(
      'http://localhost:3030/SpringMVC/reclamations/add',
      reclamation
    );
  }

  // postTodo(todo:Todo){
  //   return this.http.post('http://localhost:8090/SpringMVC/reclamations',todo)
  // }
}
