import { Component, OnInit } from '@angular/core';
import { Contact } from 'src/model/model.contact';
import { ContactService } from 'src/services/contact.service';

@Component({
  selector: 'app-new-contact',
  templateUrl: './new-contact.component.html',
  styleUrls: ['./new-contact.component.scss']
})
export class NewContactComponent implements OnInit {

  contact: Contact = new Contact();

  constructor(private contactService: ContactService) { }

  ngOnInit() {
  }

  saveContact() {
    this.contactService.saveContact(this.contact)
      .subscribe(data => {
        console.log(data)
      }, err => {
        console.log(err);
      })
  }

}
