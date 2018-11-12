import { Component, OnInit } from '@angular/core';
import { Contact } from 'src/model/model.contact';
import { ContactService } from 'src/services/contact.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-contact',
  templateUrl: './edit-contact.component.html',
  styleUrls: ['./edit-contact.component.scss']
})
export class EditContactComponent implements OnInit {

  contact: Contact;
  idContact: number;

  constructor(
    private contactService: ContactService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {

    this.idContact = this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    this.contactService.getContact(this.idContact)
      .subscribe(data => {
        this.contact = data;
      }, err => {
        console.log(err);
      })
  }

  updateContact() {
    this.contactService.updateContact(this.contact)
      .subscribe(data => {
        alert("Mise à jour effectuée");
        this.router.navigate(['/contacts']);
      }, err => {
        console.log(err);
      })
  }
}
