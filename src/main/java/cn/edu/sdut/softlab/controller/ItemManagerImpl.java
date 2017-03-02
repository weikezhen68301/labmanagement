/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.Item;
import cn.edu.sdut.softlab.service.CategoryFacade;

import cn.edu.sdut.softlab.service.ItemFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;

/**
 *
 * @author weikezhen
 */
@Named("itemManager")
@RequestScoped
public class ItemManagerImpl implements ItemManager {
      @Inject
  private transient Logger logger;
      @Inject
      ItemFacade ItemService;
  @Inject
  private UserTransaction utx;
   @Inject
    CategoryFacade categoryservice;
    @Inject
  private Credentials credentials;
  private Item newItem = new Item();
  public Item getNewItem(){
  return newItem;
  }
    public void setNewItem(Item newItem) {
        this.newItem = newItem;
    }
 private String categoryname;

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
  @Override
  @Produces
  @Named
  @RequestScoped
public List<Item> getItems() throws Exception{
    try {
      utx.begin();
      return ItemService.findAll();
    } finally {
      utx.commit();
}
}
 
    @Override
    public String addItem() throws Exception {
         try {
      utx.begin();
      ItemService.create(newItem);
      logger.log(Level.INFO, "Added {0}", newItem);
      return "/items.xhtml?faces-redirect=true";
    } finally {
      utx.commit();
    }
  }

    @Override
    public String removeItem() throws Exception {
        Item item=ItemService.findByName(credentials.getItemname());
          try {
      utx.begin();
      ItemService.remove(item);
      logger.log(Level.INFO, "Added {0}", newItem);
      return "/items.xhtml?faces-redirect=true";
    } finally {
      utx.commit();
    }
    }

    @Override
    public String rentalItem() throws Exception {
               Item item=ItemService.findByName(credentials.getItemname());
               if(item.getNumTotal()!=0){
               item.setNumTotal(item.getNumTotal()-1);
               }
          try {
      utx.begin();
      ItemService.edit(item);
      logger.log(Level.INFO, "Added {0}", newItem);
      return "/items.xhtml?faces-redirect=true";
    } finally {
      utx.commit();
    }
    }

    @Override
    public String returnItem() throws Exception {
             Item item=ItemService.findByName(credentials.getItemname());
              
               item.setNumTotal(item.getNumTotal()+1);
               
          try {
      utx.begin();
      ItemService.edit(item);
      logger.log(Level.INFO, "Added {0}", newItem);
      return "/items.xhtml?faces-redirect=true";
    } finally {
      utx.commit();
    }
    }

}
