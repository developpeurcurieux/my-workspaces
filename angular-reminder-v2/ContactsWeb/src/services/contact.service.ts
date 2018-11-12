import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map } from 'rxjs/operators';
import { Contact } from "src/model/model.contact";

@Injectable()
export class ContactService {

    pageContacts: any;

    constructor(private http: HttpClient) { }

    getContacts(motCle: string, page: number, size: number) {
        return this.http.get("http://192.168.1.13:8080/chercherContacts?motCle=" + motCle + "&size=" + size + "&page=" + page)
            .pipe(map(res => res))
    }

    saveContact(contact: Contact) {
        return this.http.post("http://192.168.1.13:8080/contacts", contact)
            .pipe(map(res => res))
    }

    getContact(id: number) {
        return this.http.get("http://192.168.1.13:8080/contacts/" + id)
            .pipe(map(res => res))
    }

    updateContact(contact: Contact) {
        return this.http.put("http://192.168.1.13:8080/contacts/" + contact.id, contact)
            .pipe(map(res => res))
    }

    deleteContact(id: number) {
        return this.http.delete("http://192.168.1.13:8080/contacts/" + id)
            .pipe(map(res => res))
    }
}