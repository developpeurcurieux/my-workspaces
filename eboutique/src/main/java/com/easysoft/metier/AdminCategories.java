package com.easysoft.metier;

import com.easysoft.entities.Categorie;
import com.easysoft.entities.Role;
import com.easysoft.entities.User;

public interface AdminCategories extends AdminProduits {
	public Categorie ajouterCategorie(Categorie categorie);
	public void supprimerCategorie(Long idCategorie);
	public void modifierCategorie(Categorie categorie);
	public void ajouterUser(User user);
	public void attribuerRole(Role role, Long idUser);
}
