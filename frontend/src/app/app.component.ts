import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service';
import { DataModel } from '../interfaces/data.interface';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Application de Gestion de Données';
  data: DataModel[] = [];
  newData: DataModel = {
    timestamp: new Date(),
    content: '',
    status: 'PENDING'
  };
  isLoading = false;
  errorMessage = '';
  
  constructor(private dataService: DataService) {}

  ngOnInit(): void {
    this.loadData();
    console.log('app.component.ts ngOnInit exécuté');
  }

  loadData(): void {
    console.log('app.component.ts loadData begin');
    this.isLoading = true;
    this.errorMessage = '';

    this.dataService.getData()
      .subscribe({
          next: (data) => {
            console.log('Données reçues:', data);
            this.data = data;
            this.isLoading = false;
          },
          error: (err) => {
            console.error('Error fetching data:', err);
            this.errorMessage = 'Impossible de charger les données. Veuillez réessayer.';
            this.isLoading = false;
          }
        });
      console.log('app.component.ts loadData end');
   }

  submitData(): void {
    console.log('app.component.ts submitData begin');
    // Vérification de base
    if(!this.newData.content || this.newData.content.trim() === '') {
      this.errorMessage = 'Le contenu ne peut pas être vide';
      return;
    }
    this.isLoading = true;
    this.errorMessage = '';

    // Créer une copie pour éviter les références partagées
    const dataToSubmit: DataModel = {
      timestamp: new Date(),
      content: this.newData.content.trim(),
      status: 'PENDING'
    };

    console.log('app.component.ts Données à soumettre:', dataToSubmit);

    // On ne rentre pas dans le subscribe
    this.dataService.postData(dataToSubmit)
      .subscribe({
        next: (createdData) => {
          console.log('app.component.ts Données créées:', createdData);
          this.data.unshift(createdData); // Ajouter au début de la liste
          this.newData.content = ''; // Réinitialiser le formulaire
          this.isLoading = false;
        },
        error: (err) => {
          console.error('app.component.ts Error submitting data:', err);
          this.errorMessage = 'Impossible d\'enregistrer les données. Veuillez réessayer.';
          this.isLoading = false;
        },
        complete: () => {
          console.log('app.component.ts Requête terminée');
        }
      });

      console.log('app.component.ts Données tratiées');
      console.log('app.component.ts submitData end');
    }
}