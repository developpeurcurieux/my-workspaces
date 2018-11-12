import { Component, OnInit } from '@angular/core';
import { AboutService } from 'src/services/about.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {

  infos: { nom: string, email: string, tel: number };
  comments = [];
  commentaire = { date: null, message: '' };

  constructor(private aboutService: AboutService) {
    this.infos = aboutService.getInfo();
    this.comments = aboutService.getAllComments();
  }

  ngOnInit() {
  }

  onAddCommentaire(c) {
    this.aboutService.addComment(c);
    this.commentaire.message = "";
    this.comments = this.aboutService.getAllComments();
  }

}
