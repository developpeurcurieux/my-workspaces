import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-etudiant',
  templateUrl: './etudiant.component.html',
  styleUrls: ['./etudiant.component.scss']
})
export class EtudiantComponent implements OnInit {
  listFormations;
  listEtudiants;
  currentFormation = -1;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.httpClient.get('http://192.168.1.13:8080/formations')
      .subscribe(data => {
        this.listFormations = data;
      }, err => {
        console.log(err);
      })
  }

  onGetEtudiants(f) {
    this.currentFormation = f;
    this.httpClient.get('http://192.168.1.13:8080/formations/' + f.id + '/etudiants')
      .subscribe(data => {
        this.listEtudiants = data;
      }, err => {
        console.log(err);
      })
  }

}
