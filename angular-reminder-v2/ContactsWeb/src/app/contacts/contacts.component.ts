import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { ContactService } from 'src/services/contact.service';
import { Router } from '@angular/router';
import { Contact } from 'src/model/model.contact';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.component.html',
  styleUrls: ['./contacts.component.scss']
})
export class ContactsComponent implements OnInit {

  pageContacts: any;
  motCle: string = "";
  currentPage: number = 0;
  size: number = 5;
  pages: Array<number>;

  constructor(private contactService: ContactService, private router: Router) { }

  ngOnInit() {

  }

  doSearch() {
    this.contactService.getContacts(this.motCle, this.currentPage, this.size)
      .subscribe(data => {
        this.pageContacts = data;
        this.pages = new Array(data.totalPages);
      }, err => {
        console.log(err);
      })
  }

  chercher() {
    this.doSearch();
  }

  goToPage(i: number) {
    this.currentPage = i;
    this.doSearch();
  }

  onEditContact(id: number) {
    this.router.navigate(['/edit-contact', id]);
  }

  onDeleteContact(contact: Contact) {
    let confirm = window.confirm('Etes-vous sure de vouloir supprimer ?');
    if (confirm == true) {
      this.contactService.deleteContact(contact.id)
        .subscribe(data => {
          this.pageContacts.content.splice(
            this.pageContacts.content.indexOf(contact), 1
          );
          alert("suppression ok");
        }, err => {
          console.log(err);
        })

    }
  }

}
