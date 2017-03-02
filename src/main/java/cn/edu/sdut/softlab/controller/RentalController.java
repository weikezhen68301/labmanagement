/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.Item;
import cn.edu.sdut.softlab.service.ItemFacade;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;

/**
 *
 * @author weikezhen
 */
@SessionScoped
@Named("rental")
public class RentalController implements Serializable {

    private static final long serialVersionUID = 7965455427888195913L;
    @Inject
    private transient Logger logger;
    @Inject
    Shelve shelve;
    @Inject
    ItemFacade rentalService;
    @Inject
    FacesContext facesContext;
    @Inject
    private UserTransaction utx;
    private Item newItem = new Item();

    public Item getNewItem() {
        return newItem;
    }

    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }

    public void rental1() throws Exception {
           // Item item = rentalService.findByName(newItem.getName());
            
    }

    public String rental() throws Exception {

        Item item = rentalService.findByName(newItem.getName());
        if (null != item) {

            item.setStatus("已借出");

        }

        try {
            utx.begin();
            rentalService.edit(item);
            logger.log(Level.INFO, "Added {0}", item);
            return "/rental.xhtml?faces-redirect=true";
        } finally {
            utx.commit();
        }
    }
}
