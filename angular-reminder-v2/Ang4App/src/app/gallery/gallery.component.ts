import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { pipe } from '@angular/core/src/render3';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.scss']
})
export class GalleryComponent implements OnInit {
  pagePhotos: any;
  currentPage: number = 1;
  size: number = 10;
  totalPages: number = 0;
  pages: Array<number> = [];
  motCle: string = '';

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  onSearch(dataForm) {
    console.log('----- DEBUT -----');
    console.log(dataForm.motCle);
    console.log('---- FIN ---- ');
    this.http.get('https://pixabay.com/api/?key=7480167-c8e4794ce60e502f2c2c87e47&q=' + dataForm.motCle + '&per_page' + this.size + '&page=' + this.currentPage)
      .pipe(map(res => res))
      .subscribe(data => {
        console.log(data);
        this.pagePhotos = data;
      })
  }


}
