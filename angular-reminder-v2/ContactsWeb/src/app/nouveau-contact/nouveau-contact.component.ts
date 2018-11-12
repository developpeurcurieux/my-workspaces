import { Component, OnInit } from '@angular/core';
import { Contact } from 'src/model/model.contact';
import { ContactService } from 'src/services/contact.service';

@Component({
  selector: 'app-nouveau-contact',
  templateUrl: './nouveau-contact.component.html',
  styleUrls: ['./nouveau-contact.component.scss']
})
export class NouveauContactComponent implements OnInit {

  constructor(private contactService: ContactService) { }

  ngOnInit() {
  }

  onSaveContact(dataForm) {
    this.contactService.saveContact(dataForm)
      .subscribe(data => {
        console.log(data);
      }, err => {
        console.log(JSON.parse(err._body).message);
      })
  }

}
