import { Annonce } from '../models/Annonce';
import { DataServicesService } from './../services/data-services.service';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SharedService } from '../services/shared.service';
import { debounceTime } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
})
export class HomePageComponent {
  searchSubject: Subject<string> = new Subject<string>();

  priceFilter: string | null = null; // By default, no filter selected
  cartItemCount: number = 0;
  annonces: Annonce[] = [];
  filteredAnnoncesList: Annonce[] = [];
  searchText: string = '';
  searchTerm: string = '';

  nouvelleAnnonce: Annonce = {
    description: '',
    lieu: '',
    dimension: '',
    etat: '',
    prix: 0,
    date_creation: new Date(),
    id_annonce: 0,
    id: 0,
    utilisateurId: undefined,
  };
  public annoncesList: any;
  list: any;
  displayedList: any;
  selectedAnnonce: Annonce | null = null;

  constructor(
    private dataServicesService: DataServicesService,
    private sharedService: SharedService
  ) {}

  ngOnInit(): void {
    let cartItems = localStorage.getItem('cartItems');
    if (cartItems) {
      this.cartItemCount = JSON.parse(cartItems).length;
    }
    this.dataServicesService.getAnnoncesData().subscribe((data) => {
      this.annoncesList = data;
      console.log(data);
      this.filterAnnonces();
    });
    this.searchSubject
      .pipe(debounceTime(300))
      .subscribe((searchTerm: string) => {
        this.searchTerm = searchTerm;
        this.filterAnnonces();
      });
  }
  openModal(annonce: Annonce) {
    this.selectedAnnonce = annonce;
    // Code pour ouvrir la modale (vous devez implémenter cette partie)
  }
  onSearch(): void {
    this.searchSubject.next(this.searchTerm);
    this.filterAnnonces();
  }

  filterByPrice(annoncesList: any[]): any[] {
    if (!this.priceFilter || !this.priceFilter.includes('-')) {
      return annoncesList; // If no filter selected or invalid filter, return all the annonces
    }

    const [minPercentage, maxPercentage] = this.priceFilter
      .split('-')
      .map(Number);
    const priceRange = maxPercentage - minPercentage;
    const sortedList = annoncesList.sort((a, b) => a.prix - b.prix);
    const startIndex = Math.floor((minPercentage / 100) * annoncesList.length);
    const endIndex = Math.ceil((maxPercentage / 100) * annoncesList.length);
    return sortedList.slice(startIndex, endIndex);
  }
  onPriceFilterChange(event: Event): void {
    const target = event.target as HTMLSelectElement;
    this.priceFilter = target.value || null;
    this.filterAnnonces();
  }
  filterAnnonces(): void {
    let filteredList = this.annoncesList.slice(); // Crée une copie de la liste des annonces

    // Filtrer par terme de recherche
    if (this.searchTerm.trim() !== '') {
      filteredList = filteredList.filter((annonce: Annonce) => {
        const searchTermLower = this.searchTerm.toLowerCase();

        return (
          annonce.lieu.toLowerCase().includes(searchTermLower) ||
          annonce.description.toLowerCase().includes(searchTermLower) ||
          annonce.dimension.toLowerCase().includes(searchTermLower) ||
          annonce.etat.toLowerCase().includes(searchTermLower) ||
          annonce.prix.toString().includes(searchTermLower) ||
          annonce.date_creation.toString().includes(searchTermLower)
        );
      });
    }

    // Filtrer par prix
    if (this.priceFilter) {
      filteredList = this.filterByPrice(filteredList);
    }

    this.filteredAnnoncesList = filteredList;
  }
  deleteannonce(id: number): void {
    const confirmation = window.confirm(
      'Êtes-vous sûr de vouloir supprimer cette annonce ?'
    );

    if (confirmation) {
      this.dataServicesService.deleteAnnonce(id).subscribe(
        (response: any) => {
          // Gérer le succès de la suppression
          console.log('Annonce supprimée avec succès');

          const index = this.annoncesList.findIndex(
            (annonce: { id_annonce: number }) => annonce.id_annonce === id
          );
          if (index !== -1) {
            this.annoncesList.splice(index, 1);
          }

          // Afficher l'alerte après la suppression réussie
          alert('Annonce supprimée avec succès !');
        },
        (error) => {
          // Gérer les erreurs de suppression
          console.error(
            "Une erreur s'est produite lors de la suppression de l'annonce",
            error
          );
        }
      );
    }
  }
  ajouterAnnonce() {
    this.dataServicesService.addAnnonce(this.nouvelleAnnonce).subscribe(
      (response: any) => {
        console.log('Annonce ajoutée avec succès');
        this.dataServicesService.getAnnoncesData().subscribe((data: any) => {
          this.annoncesList = data;
          this.filterAnnonces();
        });
      },
      (erreur) => {
        console.error("Erreur lors de l'ajout de l'annonce", erreur);
      }
    );
  }
  addToCart(annonceId: number): void {
    let cartItems = localStorage.getItem('cartItems');
    let cartItemsArray: number[] = [];

    if (cartItems) {
      cartItemsArray = JSON.parse(cartItems);
    }

    // Vérifier si l'ID de l'annonce existe déjà dans le panier
    if (cartItemsArray.includes(annonceId)) {
      alert('Cette annonce existe déjà dans le panier!');
      return;
    }

    // Ajouter l'ID de l'annonce au panier
    cartItemsArray.push(annonceId);

    // Stocker le panier mis à jour dans le localStorage
    localStorage.setItem('cartItems', JSON.stringify(cartItemsArray));
    this.cartItemCount = cartItemsArray.length;

    // Afficher un message ou effectuer d'autres actions si nécessaire
    alert('Annonce ajoutée au panier avec succès!');
  }
}
