/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.ItemAccount;
import cn.edu.sdut.softlab.service.ItemAccountFacade;
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
@Named("itemAccountManager")
@RequestScoped
public class ItemAccountManagerImpl implements ItemAccountManager{
         @Inject
  private transient Logger logger;
          @Inject
  private Credentials credentials;
      @Inject
      ItemAccountFacade ItemAccountService;
  @Inject
  private UserTransaction utx;
    private ItemAccount newItemAccount = new ItemAccount();

    public ItemAccount getNewItemAccount() {
        return newItemAccount;
    }

    public void setNewItemAccount(ItemAccount newItemAccount) {
        this.newItemAccount = newItemAccount;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
  @Produces
  @Named
  @RequestScoped
      public List<ItemAccount> getItemAccounts() throws Exception{
    try {
      utx.begin();
      return ItemAccountService.findAll();
    } finally {
      utx.commit();
}
}
       @Override
    public String addItemAccount() throws Exception {
        
         try {
      utx.begin();
      ItemAccountService.create(newItemAccount);
      logger.log(Level.INFO, "Added {0}", newItemAccount);
      return "/items.xhtml?faces-redirect=true";
    } finally {
      utx.commit();
    }
  }
}
